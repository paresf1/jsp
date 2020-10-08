package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {

	
	
	@Test
	public void getMembertest() {
		
		/***Given***/
		MemberDao memberDao = new MemberDao();
		String userId = "Brown";
		String pass = "passBrown";
		
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserId("brown");
		answerMemberVo.setPassword("passBrown");
		
		/***When***/
		MemberVo memberVo = memberDao.getMember(userId);
//		MemberVo memberVo = memberDao.getMember(userId);
		
		
		/***Then***/
//		assertEquals("brown", memberVo.getUserId());
//		assertEquals("passBrown", memberVo.getPassword());
		
		assertEquals(answerMemberVo, memberVo);
	}
}








