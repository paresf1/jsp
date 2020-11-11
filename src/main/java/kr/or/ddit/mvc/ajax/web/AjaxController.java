package kr.or.ddit.mvc.ajax.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.member.model.MemberVo;

@Controller
public class AjaxController {
	
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	@RequestMapping("/ajax/view")
	public String View() {
		
		return"ajax/view";
	}
	
	// consume, produce
	// consumes : 사용자가 보내는 contentType을 제한
	// produces : 사용자가 응답 받기 희망(Accept header, jquery-dataType)하는 mimeType을 제한
	// 				mimeType을 제한
	//, consumes= {"application/xml"}
	
	@ResponseBody
	@RequestMapping(path="/ajax/json", 
					consumes= {"application/json"},
					produces = {"application/json", "application/xml"})
	// 마샬링 언마샬링 json을 파라미터로 보내야에 따라 처리 방식이 달라진다.
	public MemberVo json(@RequestBody MemberVo memberVo) {
		logger.debug(" body : {}", memberVo);
		memberVo.setAlias("곰");
		return memberVo;
		
	}
}