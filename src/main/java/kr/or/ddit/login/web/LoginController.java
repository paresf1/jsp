package kr.or.ddit.login.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

//@WebServlet 혹은 web.xml url-mapping을 통해 url 등록
@SessionAttributes("rangers")
@RequestMapping(path = "/login")
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource(name="memberService")
	private MemberServiceI memberService ;
	
	@ModelAttribute("rangers")
	public List<String> ranger(){
		logger.debug("ranger()");
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("sally");
		rangers.add("cony");
		
		return rangers;
	}
	
	//localhost/login/view 요청시 처리되는 메서드
	//요청 메소드가 GET일 때만 처리
//	@RequestMapping(path="/view", method = {RequestMethod.GET, RequestMethod.POST})
//	@GetMapping()
	@RequestMapping(path="/view", method = RequestMethod.GET)
	public String getView() {
		
		logger.debug("LoginController.getView()");
		return "login/view";
	}
	
	// 파라미터 이름과 동일한 이름의 메소드 인자를 선언하면
	// 스프링 프레임워크가 자동적으로 바인딩 해준다.
	// 값을 담을 수 있는 객체를 메소드 인자로 선언한 경우에도 필드명과 파라미터 명이
	// 동일하면 자동으로 바인딩 처리를 해준다
	// 이떄 값을 담는 객체를 스프링 프레임워크에서는 command객체라고 명명한다.
	
	//Model : view객체에서 응답을 생성할 때 참조할 데이터를 담는객체
	//		   jsp/servlet 기반의 request 역할을 담당
	
//	@RequestMapping(path="/process", params= {"userid"})
	@RequestMapping(path="/process")
	public String process(String userid, String pass, MemberVo memberVo, 
						HttpSession session,Model model, 
						@RequestParam(name="email", required = false, defaultValue = "brown@line.kr") 
						String user_id )//파라미터가 반드시 있어야 한다. 
	{
		
		logger.debug("LoginController.process(){} /{} / {}", userid, pass, memberVo);
		logger.debug("user_id : {}",user_id);
		MemberVo memberVo2 = memberService.getMember(userid);
		logger.debug("LoginController.process(){} /{} / {}", userid, pass, memberVo);
		
		//db에서 조회한 사용자 정보가 존재하면 ==> main.jsp로 이동
		//db에서 조회한 사용자 정보가 존재하지 않으면 ==> login.jsp로 이동
		if(memberVo!=null && memberVo.getPass().equals(memberVo2.getPass())) {
			session.setAttribute("S_MEMBER", memberVo2);
			
			// jsp/servlet 기반에서 사용한 코드 : request.setAttribute("to_day", new Date());
			model.addAttribute("to_day", new Date());
			return "main"; 
			
		}else {
			// prefix : /WEB-INF/views/
			// main만 써도 가능하다.
			// surfix : .jsp
			
			model.addAttribute("msg", "fail");
			return "login/view";
		}
	}	
	
	// localhost/login/unt/dd
	@RequestMapping("/unt/{unt_cda}")
	public String untMain(@PathVariable("unt_cda")String result) {
		logger.debug("unt_cd :{}", result);
		return "main";
	}
	
	// localhost/login/mavView
	@RequestMapping("/mavView")
	public ModelAndView mavView(@ModelAttribute("rangers") List<String> rangers,
								@ModelAttribute("test") MemberVo memberVo ) {
		ModelAndView mav = new ModelAndView();
		logger.debug("View rangers:{}", rangers);
		logger.debug("memberVo {}", memberVo);
		
		//view 위의 메서드의 main과 똑같은 역할
		//view name 설정
		mav.setViewName("main");
		
		mav.getModel().put("msg", "success");
		mav.getModelMap().addAttribute("msg", "fail");
		
		return mav;
	}
	
}





