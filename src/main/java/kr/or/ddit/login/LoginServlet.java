package kr.or.ddit.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	
	private MemberServiceI memberService;
	
	@Override
	public void init() throws ServletException {
		// service 객체 생성
		memberService = new MemberService();
		
	}
	
	//login 화면을 클라이언트에게 응답으로 생성 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("loginServlet doGet");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}
	
	//login 화면에서 사용자가 보낸 아이디 비밀번호를 사용하여 로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		logger.debug("userId : {}, password : {}", userId, password);
		
		/*
		파라미터로 온 userId가 디비상에 존재하는지 확인하고, 비밀번호가 데이터베이스에 저장된 비밀번호와 일치하는지 확인 
		Select*
		from 회원
		where 회원 아이디 = 파라미터로 넘어온 userid
		
		public MemberVo getMember(String userId)*/
		
		
		MemberVo memberVo = memberService.getMember(userId);
		
//		일치할 경우 main 일치하지않는 경우 다시 loginpage로
		
		// 디비에 등록된 회원이 없는 경우 (로그인 페이지), 비밀번호 일치하지 않을떄
		if(memberVo ==null || !memberVo.getPass().equals(password)) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		// 비밀번호가 일치하는 경우(메인페이지로 이동)
		else if(memberVo.getPass().equals(password)) {
			request.getSession().setAttribute("S_MEMBER", memberVo);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}
		
		
		
		//쿠키정보
//		Cookie[] cookies = request.getCookies();
//		for(Cookie cookie : cookies) {
//			logger.debug("name : {}, value : {}",cookie.getName(),cookie.getValue() );
//		}
//		Cookie cookie = new Cookie("SERVERCOOKIE", "COOKIEVALUE");
//		
//		//초단위로 나오는 쿠키의 유효기간
//		cookie.setMaxAge(60*60*24);
//		
//		response.addCookie(cookie);
		
	}
}












