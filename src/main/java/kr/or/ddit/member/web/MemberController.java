package kr.or.ddit.member.web;

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
	private MemberServiceI memberService;
	
	
	@RequestMapping("/member")
	public String getMember(String userid, Model model) {
		
		MemberVO mv = memberService.getMember(userid);
		
		model.addAttribute("mv", mv);
		
		return "tiles/member/memberContent";
	}
	
	@RequestMapping("/memberList")
	public String listView(@RequestParam(name="page", required = false, defaultValue = "1") int page, @RequestParam(name="pageSize", required = false, defaultValue = "5") int pageSize, Model model) {
		
		PageVO pv = new PageVO(page, pageSize);
		Map<String, Object> map = memberService.selectMemberPageList(pv);
		model.addAttribute("list", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		
//		return "member/memberList";
		return "tiles/member/memberListContent";
	}
	
	
	
	@RequestMapping(path="/memberRegist", method ={RequestMethod.GET})
	public String memberRegistView() {
		return "tiles/member/memberRegistContent";
	}
	
	@RequestMapping(path="/memberRegist", method ={RequestMethod.POST})
	public String memberRegist(@Valid MemberVO mv, BindingResult br, @RequestPart("realfile") MultipartFile profile) {
//	public String memberRegist(@Valid JSRMemberVO mv, BindingResult br, @RequestPart("realfile") MultipartFile profile) {

		// new MemberVOValidator().validate(mv, br);
		
		// 검증을 통과하지 못했으므로 사용자 등록 화면으로 이동
		if(br.hasErrors()) {
			return "tiles/member/memberRegistContent";
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
			return "tiles/member/memberRegistContent";
		}
		
	}
	
	@RequestMapping(path="/memberUpdate", method = {RequestMethod.GET})
	public String memberUpdateView(String userid, Model model) {
		
		MemberVO mv = memberService.getMember(userid);
		
		model.addAttribute("mv", mv);
		
		return "tiles/member/memberUpdateContent";
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
			return "tiles/member/memberUpdateContent";
		}
	}
	
	@RequestMapping("/memberAjaxPage")
	public String memberAjaxPage() {
		return "tiles/member/memberAjax";
	}
	
	@RequestMapping("/memberAjax")
	public String memberAjax(String userid, Model model) {
		
		MemberVO mv = memberService.getMember(userid);
		
		model.addAttribute("mv", mv);
		
		return "jsonView";
	}
	
	@RequestMapping("/listAjaxPage")
	public String listAjaxPage() {
		return "tiles/member/listAjaxPage";
	}
	
	// 페이지 요청(/list와 다르게 page, pageSize 파라미터가 반드시 존재한다는 가정으로 작성)
	@RequestMapping("/listAjax")
	public String listAjax(PageVO pv, Model model) {
		logger.debug("PageVO : {}", pv);
		
		Map<String, Object> map = memberService.selectMemberPageList(pv);
		model.addAttribute("list", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		
		return "jsonView";
	}
	
	@RequestMapping("/listAjaxHTML")
	public String listAjaxHTML(PageVO pv, Model model) {
		logger.debug("PageVO : {}", pv);
		
		Map<String, Object> map = memberService.selectMemberPageList(pv);
		model.addAttribute("list", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		
		return "member/listAjaxHTML";
	}
	
	
	
	
}
