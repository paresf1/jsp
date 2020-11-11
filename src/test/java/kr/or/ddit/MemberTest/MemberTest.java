package kr.or.ddit.MemberTest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.InputStream;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.WebTestConfig;
import kr.or.ddit.member.model.MemberVo;

public class MemberTest extends WebTestConfig {

	
	@Test
	public void MemberList() throws Exception {
		MvcResult result = mockMvc.perform(get("/member/memberList")
					.param("page", "1")
					.param("pageSize", "5"))
					.andExpect(status().isOk())
					.andReturn();
		
		ModelAndView mav = result.getModelAndView();
		assertEquals("tiles.member.memberListContent", mav.getViewName());
	}
	
	@Test
	public void memberRegist() throws Exception  {
		
//		insert into users values(#{userid}, #{usernm}, #{pass}, sysdate, #{alias},
//		#{addr1}, #{addr2}, #{zipcode}, #{filename}, #{realFilename})
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/sally.png");
		MockMultipartFile file = new MockMultipartFile("realFilename2", "sally.png", "image/png", is);
		mockMvc.perform(fileUpload("/member/memberRegist")
				.file(file)
				.param("userid", "LebronJames")
				.param("usernm", "king")
				.param("pass", "coby")
				.param("alias", "kingking")
				.param("addr1", "대전")
				.param("addr2", "흰둥이집")
				.param("zipcode", "9999"))
				.andExpect(view().name("redirect:/member/memberList"));
	}
	
	
	@Test
	public void MemberContent() throws Exception {
		MvcResult result = mockMvc.perform(get("/member/memberContent")
				.param("userid", "cony"))
				.andReturn();
	
		ModelAndView mav = result.getModelAndView();
		assertEquals("tiles.member.memberContentContent", mav.getViewName());
	
		MemberVo memberVo = (MemberVo) mav.getModel().get("memberVo");
		assertEquals("cony",memberVo.getUserid());
	
	}
	
	@Test
	public void MemberUpdateG() throws Exception {

		mockMvc.perform(get("/member/memberUpdate")
				.param("userid", "brown"))
				.andExpect(status().isOk())
				.andExpect(view().name("tiles.member.memberUpdateContent"))
				.andReturn();
	}
	
	@Test
	public void MemberUpdateP() throws Exception  {
		
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/sally.png");
		MockMultipartFile file = new MockMultipartFile("realFilename2", "sally.png", "image/png", is);
		mockMvc.perform(fileUpload("/member/memberUpdate")
				.file(file)
				.param("userid", "brown")
				.param("usernm", "king")
				.param("pass", "coby")
				.param("alias", "kingking")
				.param("addr1", "대전")
				.param("addr2", "흰둥이집")
				.param("zipcode", "9999"))
				.andExpect(view().name("redirect:/member/memberContent?userid=brown"))
				.andExpect(status().is(302));
	}
	

	
}
