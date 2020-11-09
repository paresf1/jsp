package kr.or.ddit.member.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberServiceI;

@Controller
public class ProfileController {
	
	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	@RequestMapping("/profileImgView")
	public String profileImgView(String userid, Model model )throws IOException{
		//응답으로 생성하려고 하는 것 : 이미지 파일을 읽어서 output stream 객체에 쓰는 것

		MemberVo memberVo = memberService.getMember(userid);
		model.addAttribute("filepath", memberVo.getFilename());
		
		return "profileImgView";
	}
	
	@RequestMapping("/profileImg")
	public void profileImg(String userid,HttpServletResponse response) throws Exception {
		//response content-type 설정
		response.setContentType("image/png");
				
				
		// db에서 사용자 filename 확인
		MemberVo memberVo = memberService.getMember(userid);
				

		// 파일경로
		FileInputStream fis = new FileInputStream(memberVo.getFilename());
		ServletOutputStream sos =  response.getOutputStream();
		
		byte [] buffer = new byte[512];
				
		while(fis.read(buffer)!= -1) {
			sos.write(buffer);
		}
				
		fis.close();
		sos.flush();
		sos.close();		
	}
	@RequestMapping(path="profileDownloadView")
	public String profileDownloadView(String userid) {
		
		return "";
	}
	
	@RequestMapping(path="profileDownload")
	public void profileDownload(String userid, HttpServletResponse response) throws Exception {
		
		// 사용자 아이디 파라미터 확인하고
		
		// db에서 사용자 filename 확인
		MemberVo memberVo = memberService.getMember(userid);
		
		//response content-type 설정
		response.setHeader("Content-Disposition", "attachment; filename=\"" + memberVo.getRealFilename() + "\"");
		response.setContentType("application/octet-stream");
		
		// 경로 확인 후 파일 입출력을 통해서 응답생성
		// 파일 읽기
		// 응답 생성
		
		// 파일경로
		FileInputStream fis = new FileInputStream(memberVo.getFilename());
		ServletOutputStream sos =  response.getOutputStream();
		byte [] buffer = new byte[512];
		
		while(fis.read(buffer)!= -1) {
			sos.write(buffer);
		}
		
		fis.close();
		sos.flush();
		sos.close();
		
	}
}
