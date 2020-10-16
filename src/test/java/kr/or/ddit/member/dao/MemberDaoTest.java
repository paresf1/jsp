package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(MemberDaoTest.class);
	
	@Test
	public void getMembertest() {
		
		/***Given***/
		MemberDao memberDao = new MemberDao();
		String userId = "brown";
		
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		answerMemberVo.setAlias("곰");
		
		
		/***When***/
		MemberVo memberVo = memberDao.getMember(userId);
//		MemberVo memberVo = memberDao.getMember(userId);
		
		
		/***Then***/
//		assertEquals("brown", memberVo.getUserId());
//		assertEquals("passBrown", memberVo.getPassword());
		
		assertEquals(answerMemberVo.getUserid(), memberVo.getUserid());
		assertEquals(answerMemberVo.getPass(), memberVo.getPass());
		assertEquals(answerMemberVo.getAlias(), memberVo.getAlias());
	}
	
	@Test
	public void selectAllMemberTest() {
		
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
		/***When***/
		List<MemberVo> memberList = memberDao.selectAllMember();
		
		/***Then***/
		assertEquals(15, memberList.size());
	}
	
	@Test
	public void getMemberPage() {
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		PageVo pv = new PageVo(1, 7);
		
		/***When***/
//		int page = 1;
		List<MemberVo> memList = memberDao.selectMemberPageList(sqlSession ,pv);
		
		/***Then***/
		assertEquals(7, memList.size());

	}
	
	@Test
	public void selectMemberTotalCnt() {
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		/***When***/
		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);

		/***Then***/
		assertEquals(15, totalCnt);

	}
	
	@Test
	public void test() {
		/***Given***/
		

		/***When***/
		logger.debug("{}",Math.ceil((double)15/7));;
		
		/***Then***/

	}
}


















