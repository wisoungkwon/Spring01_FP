package com.human.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.dao.IF_MemberDAO;
import com.human.vo.MemberVO;

@Service
public class MemberServiceImpl implements IF_MemberService {
	@Inject
	private IF_MemberDAO memberdao;

	@Override
	public void insertMember(MemberVO mvo) throws Exception {
		// TODO Auto-generated method stub
		memberdao.insertMember(mvo);
	}
}
