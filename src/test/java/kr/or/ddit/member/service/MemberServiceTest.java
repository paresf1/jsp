                                                                                                                                                     package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.member.model.MemberVo;


public class MemberServiceTest extends ModelTestConfig{

	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/

		/***When***/
		List<MemberVo> memberList =  memberService.selectAllMember();
		/***Then***/
		assertEquals(memberList.size(), 16);
		
	}
	
	@Test
	public void deleteMemberTest() {
		/***Given***/
		String id ="ddit";
		/***When***/
		int deleteCnt =  memberService.deleteMember(id);
		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void insertMember_SUCCESS_test() {
		/***Given***/
		MemberVo memberVo = new MemberVo("temp", "dditpass", "대덕인재", "개발원", "", "", "", "", "");
		/***When***/
		int insertCnt = memberService.insertMember(memberVo);
		/***Then***/
		assertEquals(insertCnt, 1);
	}
	
//	@Test
//	public void insertMember_FAIL_test() {
//		/***Given***/
//		MemberVo memberVo = new MemberVo("ddit", "dditpass", "대덕인재", "개발원", "", "", "", "", "");
//		/***When***/
//		int insertCnt = memberService.insertMember(memberVo);
//		/***Then***/
//		assertEquals(insertCnt, 1);
//	}






}
