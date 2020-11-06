package kr.or.ddit.member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.fileUpload.FileUploadUtil;
import kr.or.ddit.member.model.JSRMemberVO;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.MemberVOValidator;
import kr.or.ddit.member.service.MemberServiceI;

@RequestMapping("/member")
@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource(name="memberService")
	MemberServiceI memberService;
	
	
	@RequestMapping("/member")
	public String getMember(String userid, Model model) {
		
		MemberVO mv = memberService.getMember(userid);
		
		model.addAttribute("mv", mv);
		
		return "member/member";
	}
	
	@RequestMapping("/profileImg")
	public void getProfile(String userid, HttpServletResponse response) throws IOException {
		MemberVO mv = memberService.getMember(userid);
		FileInputStream fis = new FileInputStream(mv.getFilename());
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] buffer = new byte[512];
		
		while(fis.read(buffer) != -1) {
			sos.write(buffer);
		}
		
		fis.close();
		sos.flush();
		sos.close();
	}
	
	
	@RequestMapping("/memberList")
	public String listView(@RequestParam(name="page", required = false, defaultValue = "1") int page, @RequestParam(name="pageSize", required = false, defaultValue = "5") int pageSize, Model model) {
		
		PageVO pv = new PageVO(page, pageSize);
		Map<String, Object> map = memberService.selectMemberPageList(pv);
		model.addAttribute("list", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		
		return "member/memberList";
	}
	
	
	@RequestMapping(path="/memberRegist", method ={RequestMethod.GET})
	public String memberRegistView() {
		return "member/memberRegist";
	}
	
	@RequestMapping(path="/memberRegist", method ={RequestMethod.POST})
	public String memberRegist(@Valid MemberVO mv, BindingResult br, @RequestPart("realfile") MultipartFile profile) {
//	public String memberRegist(@Valid JSRMemberVO mv, BindingResult br, @RequestPart("realfile") MultipartFile profile) {

		// new MemberVOValidator().validate(mv, br);
		
		// 검증을 통과하지 못했으므로 사용자 등록 화면으로 이동
		if(br.hasErrors()) {
			return "member/memberRegist";
		}
		
		String realFileName = profile.getOriginalFilename();
		String ext = FileUploadUtil.getExtension(realFileName);
		String fileName = UUID.randomUUID().toString();
		String filePath = "";
		if(profile.getSize() > 0) {
			filePath = "D:\\profile\\" + fileName + "." + ext;
			File file = new File("D:\\profile\\" + realFileName);
			try {
				profile.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
		mv.setFilename(filePath);
		mv.setRealfilename(realFileName);
		
		int cnt = memberService.insertMember(mv);
		
		if(cnt == 1) {
			return "redirect:/member/memberList";
		}else {
			return "member/memberRegist";
		}
		
	}
	
	@RequestMapping(path="/memberUpdate", method = {RequestMethod.GET})
	public String memberUpdateView(String userid, Model model) {
		
		MemberVO mv = memberService.getMember(userid);
		
		model.addAttribute("mv", mv);
		
		return "member/memberUpdate";
	}
	
	@RequestMapping(path="/memberUpdate", method = {RequestMethod.POST})
	public String memberUpdate(MemberVO mv,  @RequestPart("realfile") MultipartFile profile, String userid) {
		
		String realFileName = profile.getOriginalFilename();
		String ext = FileUploadUtil.getExtension(realFileName);
		String fileName = UUID.randomUUID().toString();
		String filePath = "";
		if(realFileName == null || realFileName.equals("")) {
			MemberVO mvv = memberService.getMember(userid);
			realFileName = mvv.getRealfilename();
			filePath = mvv.getFilename();
		}
		if(profile.getSize() > 0) {
			filePath = "D:\\profile\\" + fileName + "." + ext;
			File file = new File("D:\\profile\\" + realFileName);
			try {
				profile.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
		mv.setFilename(filePath);
		mv.setRealfilename(realFileName);
		
		int cnt = memberService.updateMember(mv);
		
		if(cnt == 1) {
			return "redirect:/member/member?userid="+userid;
		}else {
			return "member/memberUpdate";
		}
	}
	
	
	@RequestMapping(path="/profileDownload")
	public void profileDownload(String userid, HttpServletResponse response) throws IOException {
		MemberVO mv = memberService.getMember(userid);
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+mv.getRealfilename()+"\"");
		response.setContentType("application/octet-stream");
		
		FileInputStream fis = new FileInputStream(mv.getFilename());
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] buffer = new byte[512];
		
		while(fis.read(buffer) != -1) {
			sos.write(buffer);
		}
		
		fis.close();
		sos.flush();
		sos.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
