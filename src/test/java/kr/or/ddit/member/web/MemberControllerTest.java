package kr.or.ddit.member.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.InputStream;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

import kr.or.ddit.WebTestConfig;
import kr.or.ddit.member.service.MemberServiceI;

public class MemberControllerTest extends WebTestConfig{

	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	
	@Before
	public void start() {
		String userid = "dspark";
		memberService.deleteMember(userid);
	}
	
	
	@Test
	public void getMemberTest() throws Exception {
		mockMvc.perform(get("/member/member").param("userid", "brown"))
		.andExpect(status().is(200)).andExpect(view().name("tiles/member/memberContent"));
	}
	
	@Test
	public void listViewTest() throws Exception {
		mockMvc.perform(get("/member/memberList").param("page", "1")
		.param("pageSize", "5")).andExpect(status().isOk()).andExpect(view().name("tiles/member/memberListContent"));
	}
	
	@Test
	public void memberRegistViewTest() throws Exception {
		mockMvc.perform(get("/member/memberRegist")).andExpect(status().isOk())
		.andExpect(view().name("tiles/member/memberRegistContent"));
	}
	
	@Test
	public void memberRegistTest() throws Exception {

		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/ryan.png");
		MockMultipartFile file = new MockMultipartFile("realfile", "ryan.png", "image/png", is);
		mockMvc.perform(fileUpload("/member/memberRegist")
				.file(file).param("userid", "dspark")
				.param("pass", "1234")
				.param("alias", "밥")
				.param("usernm", "밥쟁이")
				.param("addr1", "대전시")
				.param("addr2", "우리집")
				.param("zipcode", "1234"))
		.andExpect(status().is(302))
		.andExpect(view().name("redirect:/member/memberList"));
		
	}
	
	@Test 
	public void memberUpdateViewTest() throws Exception {
		mockMvc.perform(get("/member/memberUpdate").param("userid", "brown")).andExpect(status().isOk())
		.andExpect(view().name("tiles/member/memberUpdateContent"));
	}
	
	@Test
	public void memberUpdateTest() throws Exception {
		
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/ryan.png");
		MockMultipartFile file = new MockMultipartFile("realfile", "ryan.png", "image/png", is);
		mockMvc.perform(fileUpload("/member/memberUpdate")
				.file(file).param("userid", "park")
				.param("pass", "1234")
				.param("alias", "밥2")
				.param("usernm", "밥쟁이2")
				.param("addr1", "대전시")
				.param("addr2", "우리집")
				.param("zipcode", "1234"))
		.andExpect(status().is(302))
		.andExpect(view().name("redirect:/member/member?userid=park"));
	}
	
	
}
