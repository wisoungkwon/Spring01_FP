package com.human.sk;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserLogin {

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpSession session,
						@RequestParam("id") String id,
						@RequestParam("pass") String pass) {
		
		// �α��� ����
		// 1. �Ķ���� �޴��� 2. ���� ���� �� ������� ���� �Ǵ� > ���񽺴� �ʿ�

		// ����� �׽�Ʈ������ �Ѵ�.
		if(id.equals("ttt")) {		//���� ���� �� ���̵�� �н����尡 �������� ��� ���� �޴°����� ����
			// �α��� ���� ��� ���� ó��
			
			if(session.getAttribute("login") != null) {
				session.removeAttribute("login");		// ������ �ʱ�ȭ. �ѹ��� û���ϰ� ���ڴ�.
			}
			session.setAttribute("login", id);	// ����ó��
			session.setAttribute("grade", "vip"); // ó���ϰ���� ������ �����Ͽ� ���, ��ü�� �����ϴ�
		}else {
			// �α��� ���� ���
			
		}
		// ������� �׽�Ʈ��, ���߿� DB���� �ؾ� ��
		System.out.println("�α��� ������...");
		
		return "home";
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();		// ������ ����ȭ ��Ų��
		return "home";
	}
}