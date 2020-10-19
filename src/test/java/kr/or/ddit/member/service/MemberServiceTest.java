package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.model.MemberVo;

public class MemberServiceTest {

	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);
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
		
		assertEquals(answerMemberVo.getUserid(), memberVo.getUserid());
		assertEquals(answerMemberVo.getPass(), memberVo.getPass());
	}
	@Test
	public void getMemberPage() {
		MemberServiceI memberService = new MemberService();
		PageVo pv = new PageVo(1, 7);
		
		/***When***/
		//memberList 확인
		Map<String, Object> map = memberService.selectMemberPageList(pv);
		List<MemberVo> memberList = (List<MemberVo>)map.get("memberList");
		
		//생성해야할 page 수
		int pages = (int)map.get("pages");
		/***Then***/
		assertEquals(3, pages);
		assertEquals(7, memberList.size());
		
	}
	@Test
	public void localeListTest() {
		Locale[] locales =  SimpleDateFormat.getAvailableLocales();
		for(Locale locale : locales) {
			logger.debug(locale.toString());
		}
			
	}
}

















