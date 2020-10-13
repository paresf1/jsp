package kr.or.ddit.jobs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.jobs.model.JobsVo;

public class JobsDao implements JobsDaoI {

	private static JobsDaoI dao;
	
	public static JobsDaoI getService() {
		if(dao == null) {
			dao = new JobsDao();
		}
		return dao;
	}
	
	@Override
	public List<JobsVo> JobsSelectAll() {
		
		SqlSession session = MybatisUtil.getSqlSession();
		
		List<JobsVo> listjobs = session.selectList("Jobs.JobsSelectAll");
		
		return listjobs;
	}

}
