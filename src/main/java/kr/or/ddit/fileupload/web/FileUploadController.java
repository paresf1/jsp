package kr.or.ddit.fileupload.web;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.member.model.MemberVo;

@RequestMapping("/fileupload")
@Controller
public class FileUploadController {

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	//localhost/fileupload/view 요청시
	//jsp로 응답생성
	//jsp 에서는 파일을 선택할 수 있는 input 태그 1개
	//userid 파라미터를 보낼수 있는 input 태그 1개
	// 전송을 담당하는 submit input 태그 1개를 작성
	// jsp : /WEB-INF/view/fileupload/fileupload.jsp
	// 테스트 코드 까지 작성
	@RequestMapping(path="/view")
	public String View() {
		
		return "fileupload/fileupload";
	}
	
	@RequestMapping(path="/upload", method = RequestMethod.POST, params= {"userid"})
	//multipartFile filename 을 memberVo에 선언하면은 이것도 똑같이 command객체로 memberVo에서 하나로 가능하다
	// 만약 위에같이 선언하면 memberVo하나로 모두 선언 가능
	public String FileResult(String userid, @RequestPart("file") MultipartFile file) {
		logger.debug("fileresult {}", userid);
		logger.debug("name : {} / filename : {} / size : {}",file.getName(), file.getOriginalFilename(), file.getSize() );
		
		File uploadFile = new File("d:\\upload\\"+file.getOriginalFilename());
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "fileupload/fileupload";
	}
	
	
}














