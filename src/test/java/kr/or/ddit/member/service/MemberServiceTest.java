package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.model.MemberVo;

public class MemberServiceTest {

	@Test
	public void getMembertest() {
		
		/***Given***/
		MemberServiceI memberService = new MemberService();
		String userId = "brown";
		String pass = "brownPass";
		
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		
		/***When***/
		MemberVo memberVo = memberService.getMember(userId);
		
		
		/***Then***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
		
		assertEquals(answerMemberVo, memberVo);
	}

}
