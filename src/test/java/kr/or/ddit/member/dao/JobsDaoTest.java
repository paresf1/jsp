package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.jobs.dao.JobsDao;
import kr.or.ddit.jobs.dao.JobsDaoI;
import kr.or.ddit.jobs.model.JobsVo;

public class JobsDaoTest {

	@Test
	   public void getJobsAllTest() {
	      /***Given***/
	      JobsDaoI dao = new JobsDao();

	      /***When***/
	      List<JobsVo> joblist = dao.JobsSelectAll();
	      /***Then***/
	      assertNotNull(joblist);
	   }

}

