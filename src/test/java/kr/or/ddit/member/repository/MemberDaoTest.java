package kr.or.ddit.member.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVo;


public class MemberDaoTest extends ModelTestConfig{

	@Resource(name="memberDao")
	private MemberDaoI memberDao;
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/

		/***When***/
		List<MemberVo> memberList =  memberDao.selectAllMember();
		/***Then***/
		
		assertEquals(16, memberList.size());
		
	}

	@Test
	public void deleteMemberTest() {
		/***Given***/
		String id ="brown";
		/***When***/
		int deleteCnt =  memberDao.deleteMember(id);
		/***Then***/
		assertEquals(deleteCnt, 1);
	}	
	
}
