package com.human.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileDataUtil {
   
   private ArrayList<String> extNameArray = new ArrayList<String>()	// 허용하는 확장저를 정의한것.
   {
      {
         add("gif");
         add("jpg");
         add("png");
      }
   };		// 지금 이 코드는 선언만 한것이지 기능이 동작하지는 않는다.
   //첨부파일 업로드 경로 변수값으로 가져옴 servlet-context.xml
   @Resource(name="uploadPath")
   private String uploadPath;
   
   public String getUploadPath() {
      return uploadPath;
   }

   public void setUploadPath(String uploadPath) {
      this.uploadPath = uploadPath;
   }

   /**
    * 게시물 상세보기에서 첨부파일 다운로드 메서드 구현(공통)
    */
   @RequestMapping(value="/download", method=RequestMethod.GET)
   @ResponseBody	// 어노테이션, 어떤 데이터를 포함하여 전송.view를 지정하지 않고 바로 클라이언트 요청으로 응답.
   public FileSystemResource fileDownload(@RequestParam("filename") String fileName, HttpServletResponse response) {
      File file = new File(uploadPath + "/" + fileName);
      response.setContentType("application/download; utf-8");
      response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
      return new FileSystemResource(file);
   }
   
   /**
    * 파일 업로드 메서드(공통)
    * @throws IOException 
    */
   public String[] fileUpload(MultipartFile[] file) throws IOException {
      String[] files = new String[file.length];
	  for(int i = 0; i < file.length; i++) {
		  if(file[i].getOriginalFilename()!="") {	// 실제 file객체가 존재하다면.
			  String originalName = file[i].getOriginalFilename();//확장자를 가져오기 위해서 전체파일명을 가져옴
		      UUID uid = UUID.randomUUID();//랜덤문자 구하기
		      String saveName = uid.toString() + "." + originalName.split("\\.")[1];//한글 파일명 처리 때문에...
		   //   String[] files = new String[] {saveName};//형변환	files[0] 파일명이 들어간다.
		      byte[] fileData = file[i].getBytes();
		      File target = new File(uploadPath, saveName);
		      FileCopyUtils.copy(fileData, target);
		      files[i] = saveName;
		  }
	  }      
      return files;
   }

   public ArrayList<String> getExtNameArray() {
      return extNameArray;
   }

   public void setExtNameArray(ArrayList<String> extNameArray) {
      this.extNameArray = extNameArray;
   }
}