package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {

	
	
	@Test
	public void getMembertest() {
		
		/***Given***/
		MemberDao memberDao = new MemberDao();
		String userId = "brown";
		
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		
		/***When***/
		MemberVo memberVo = memberDao.getMember(userId);
//		MemberVo memberVo = memberDao.getMember(userId);
		
		
		/***Then***/
//		assertEquals("brown", memberVo.getUserId());
//		assertEquals("passBrown", memberVo.getPassword());
		
		assertEquals(answerMemberVo, memberVo);
	}
	
	@Test
	public void selectAllMemberTest() {
		
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
		/***When***/
		List<MemberVo> memberList = memberDao.selectAllMember();
		
		/***Then***/
		assertEquals(5, memberList.size());
	}
	
	
}


















