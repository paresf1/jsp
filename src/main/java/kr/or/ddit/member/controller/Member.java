package kr.or.ddit.member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.FileUpload.FileUploadUtil;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberServiceI;

//@WebServlet("/memberList")
@RequestMapping(path="/member")
@Controller
public class Member{
	private static final Logger logger = LoggerFactory.getLogger(Member.class);
	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	@RequestMapping(path="/memberList")
//	public String memberList(PageVo pv, Model model) {
	public String memberList(PageVo pv, Model model) {
		
		int page = pv.getPage() == 0 ?  1 : pv.getPage();
		int pageSize = pv.getPageSize() == 0 ?  5 : pv.getPageSize();
		
		PageVo pvresult = new PageVo(page, pageSize);
		
		Map<String, Object> map =  memberService.selectMemberPageList(pvresult);
		
		model.addAttribute("memberList", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		
		return "member/memberList";
	}
	
	@RequestMapping(path="/memberContent")
	public String memberContent(@RequestParam(name="userid")String userid,Model model) {
		
		MemberVo memberVo = memberService.getMember(userid);
		model.addAttribute("memberVo", memberVo);
		
		return "member/memberContent";
	}
	
	@RequestMapping(path="/memberRegist", method = RequestMethod.GET)
	public String memberRegistG() {
		
		return "member/memberRegist"; 
	}
	
	@RequestMapping(path="/memberRegist", params= {"userid"}, method = RequestMethod.POST)
//	public String memberRegistP(MemberVo memberVo,BindingResult br, @RequestPart("realFilename2") MultipartFile file) {
		public String memberRegistP(@Valid MemberVo memberVo,BindingResult br, @RequestPart("realFilename2") MultipartFile file) {
		
//		new MemberVoValidator().validate(memberVo, br);
		
		//검증을 통과하지 못했으므로 사용자 등록 화면으로 이동
		if(br.hasErrors()) {
			return "member/memberRegist";
		}
		String realfileName = file.getOriginalFilename();
		String fileExtension = FileUploadUtil.getExtension(realfileName);
		String fileName = "D:\\profile\\"+UUID.randomUUID().toString() + "."+fileExtension;
		
		File uploadFile = new File(fileName);
        	try {
				file.transferTo(uploadFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
        	
		memberVo.setRealFilename(realfileName);
		memberVo.setFilename(fileName);
		logger.debug("memberVoRegist!!!!!!!!{}", memberVo);
		int result = memberService.insertMember(memberVo);
		
		logger.debug("regist결과!!!!!!!!!{}",result);
		if(result==1) {
			return "redirect:/member/memberList";
		}else {
			return "member/memberRegist";
		}
	}
	
	@RequestMapping(path="/memberUpdate", method = RequestMethod.GET)
	public String memberUpdateG(@RequestParam(name="userid")String userid,Model model){
		MemberVo memberVo = memberService.getMember(userid);
		model.addAttribute("memberVo", memberVo);
		
		return "member/memberUpdate";
	
	}
//	@RequestParam(S)
	
	@RequestMapping(path="/memberUpdate", method = RequestMethod.POST)
	public String memberUpdateP(MemberVo memberVo, Model model, @RequestPart("realFilename2") MultipartFile file) {
		MemberVo memberVoresult = memberService.getMember(memberVo.getUserid());
		
		String realfileName = file.getOriginalFilename();
		String fileExtension = FileUploadUtil.getExtension(realfileName);
		String fileName = "D:\\profile\\"+UUID.randomUUID().toString() + "."+fileExtension;
		
		logger.debug("paresf1memberVo{}",memberVoresult);
		if(realfileName == null||realfileName.equals("")) {
			realfileName = memberVoresult.getRealFilename();
			fileName = memberVoresult.getFilename();
			logger.debug("if절"+realfileName);
		}else {
			
			File uploadFile = new File(fileName);
			try {
				file.transferTo(uploadFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
		memberVo.setRealFilename(realfileName);
		memberVo.setFilename(fileName);
		int result = memberService.updateMember(memberVo);
		if(result==1) {
			return "redirect:/member/memberContent?userid="+memberVoresult.getUserid();
		}else {
			return "member/memberUpdate?userid="+memberVo.getUserid();
		}
	}
	
	@RequestMapping(path="/profileImg")
	public String profileImg(MemberVo memberVo, HttpServletResponse response) throws Exception {
		
		//response content-type 설정
		response.setContentType("image/png");
		// 사용자 아이디 파라미터 확인하고
		
		// db에서 사용자 filename 확인
		MemberVo getmemberVo = memberService.getMember(memberVo.getUserid());
		
		// 경로 확인 후 파일 입출력을 통해서 응답생성
		// 파일 읽기
		// 응답 생성
		
		// 파일경로
		FileInputStream fis = new FileInputStream(getmemberVo.getFilename());
		ServletOutputStream sos =  response.getOutputStream();
		byte [] buffer = new byte[512];
		
		while(fis.read(buffer)!= -1) {
			sos.write(buffer);
		}
		
		fis.close();
		sos.flush();
		sos.close();
	
		return "";
	}
}







