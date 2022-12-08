package com.human.sk;

import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.human.service.IF_MemberService;
import com.human.vo.MemberVO;

@Controller
public class LAcontrollor {
	@Inject
	private IF_MemberService msrv;
	
	
	@RequestMapping(value = "/JoinForm", method = RequestMethod.POST)
	public String joinForm(Locale locale, Model model) {
		return "JoinForm";
	}
	
	@RequestMapping(value = "/wrAction", method = RequestMethod.POST)
	public String wrAction(Locale locale, Model model, MemberVO mvo) throws Exception {
	
		msrv.insertMember(mvo);
		
		return "redirect:/home";
	}
	
	
}
