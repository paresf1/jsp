package kr.or.ddit.jobs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.jobs.dao.JobsDao;
import kr.or.ddit.jobs.model.JobsVo;
import kr.or.ddit.jobs.service.JobsService;
import kr.or.ddit.jobs.service.JobsServiceI;

/**
 * Servlet implementation class JobsSelectAllController
 */
@WebServlet("/JobsSelectAllController")
public class JobsSelectAllController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JobsServiceI Jobs =  JobsService.getService();
		
		List<JobsVo> listjobs = Jobs.JobsSelectAll();
		
		request.setAttribute("JobsVo", listjobs);
		
		request.getRequestDispatcher("db/jobs.jsp").forward(request, response);
		
	}

}
