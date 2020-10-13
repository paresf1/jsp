package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.jobs.model.JobsVo;
import kr.or.ddit.jobs.service.JobsService;
import kr.or.ddit.jobs.service.JobsServiceI;

public class JobsServiceTest {

	@Test
	   public void getJobsAllTest() {
	      /***Given***/
	      JobsServiceI service = new JobsService();

	      /***When***/
	      List<JobsVo> joblist = service.JobsSelectAll();
	      /***Then***/
	      assertNotNull(joblist);
	   }

}
