package kr.or.ddit.member.web;

import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.mvc.view.ProfileImgView;


@Controller
public class ProfileController {
	
	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	@RequestMapping("/profileImgView")
	public String getProfileView(String userid, Model model) throws IOException {
		// 응답으로 생성하려고 하는 것 : 이미지 파일을 읽어서 output stream객체에 쓰는 것
		MemberVO mv = memberService.getMember(userid);
		model.addAttribute("filepath", mv.getFilename());
		
		return "profileImgView";
	}
	
	
	@RequestMapping("/downloadView")
	public String downloads(String userid, Model model) throws IOException {
		MemberVO mv = memberService.getMember(userid);
		
		model.addAttribute("realFile", mv.getRealfilename());
		model.addAttribute("filepath", mv.getFilename());
		
		return "downloadView";
	}

	
}
