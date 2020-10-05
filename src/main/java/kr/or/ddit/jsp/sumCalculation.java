package kr.or.ddit.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class jspTestServlet
 */
@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory.getLogger(sumCalculation.class);
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//입력화면 요청 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getAttribute("start");
//		request.getAttribute("end");
		
		
		request.getRequestDispatcher("jsp/getTest.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("sumCalculation.doPost()");
		int start = Integer.parseInt((request.getParameter("start")));
		int end = Integer.parseInt((request.getParameter("end")));
		
		int sum = 0;
		for(int i = start ; i <=end ; i++) {
			sum += i;
		}
		
		request.setAttribute("sumResult", sum);
		
		logger.debug("{}",sum);
		request.getRequestDispatcher("jsp/sumResult.jsp").forward(request, response);
//		// 5 1 12345
//		// 7 3 34567
//		// 8 6 7
		
		
	}

}
