package kr.or.ddit.jobs.service;

import java.util.List;

import kr.or.ddit.jobs.dao.JobsDao;
import kr.or.ddit.jobs.dao.JobsDaoI;
import kr.or.ddit.jobs.model.JobsVo;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;

public class JobsService implements JobsServiceI {
	
	private static JobsServiceI jobService;
	private JobsDaoI jobDao;
	
	public  JobsService() {
		jobDao = JobsDao.getService();
	}
	public static JobsServiceI getService() {
		if(jobService == null) {
			jobService = new JobsService();
		}
		return jobService;
	}
	
	@Override
	public List<JobsVo> JobsSelectAll() {
		JobsDaoI jobsDao = new JobsDao();
		return jobsDao.JobsSelectAll();
	}
	
}
