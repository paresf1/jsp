package kr.or.ddit.fileupload;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.or.ddit.WebTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
//스프링 빈 두개 생성 웹기반
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/root-context.xml",
							"classpath:kr/or/ddit/config/spring/application-context.xml"})
@WebAppConfiguration //스프링 컨테이너를 웹기반에서 동작하는 컨테이너로 생성하는 옵션(@Controller, @RequestMapping)
public class FileuploadTest extends WebTestConfig {

	
	@Test
	public void ViewTest() throws Exception {
		//is ok 는 정상이라는 의미
		mockMvc.perform(get("/fileupload/view"))
				.andExpect(status().isOk())
				.andExpect(view().name("fileupload/fileupload"));
		
	}

	@Test
	public void uploadTest() throws Exception {
//		MockMultipartFile file = new MockMultipartFile("file", "sally.png", "image/png");
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/sally.png");
//		FileInputStream fis = new FileInputStream("D:\\A_TeachingMaterial\\6.JspSpring\\workspace\\spring\\src\\test\\resources\\kr\\or\\ddit\\upload\\sally.png");
		MockMultipartFile file = new MockMultipartFile("file", "sally.png", "image/png", is);
		
		mockMvc.perform(fileUpload("/fileupload/upload")
				.file(file)
				.param("userid", "브라운"))
				.andExpect(view().name("fileupload/fileupload"))
				.andExpect(status().isOk());
	}
}









