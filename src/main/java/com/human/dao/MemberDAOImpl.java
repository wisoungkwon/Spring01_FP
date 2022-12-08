package com.human.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.human.vo.MemberVO;

@Repository
public class MemberDAOImpl implements IF_MemberDAO {
	private static String maaperQuery = "com.human.dao.IF_MemberDAO";
	@Inject
	private SqlSession sqlSession;
	@Override
	public void insertMember(MemberVO mvo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(maaperQuery+".insertMember", mvo);
	}
	
}
