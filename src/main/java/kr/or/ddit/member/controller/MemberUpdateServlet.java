package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileUpload.FileUploadUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate")
@MultipartConfig
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberUpdateServlet.class);
	
	private MemberServiceI memberService;
	MemberVO mv = new MemberVO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		memberService = new MemberService();
		
		String userid = request.getParameter("userid");
		
		// service 객체 호출
		logger.debug("{}",userid);
		mv = memberService.getMember(userid);
		
		request.setAttribute("mv", mv);
		
		// jsp로 위임
		request.getRequestDispatcher("/member/memberUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String alias = request.getParameter("alias");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		
		
		Part profile = request.getPart("realfilename");
		logger.debug("file : {}", profile.getHeader("Content-Disposition"));
		
		String realFileName = FileUploadUtil.getFileName(profile.getHeader("Content-Disposition"));
		String fileName = UUID.randomUUID().toString();
		String filePath = "";
		
		if(realFileName == null || realFileName.equals("")) {
			realFileName = mv.getRealfilename();
			filePath = mv.getFilename();
		}
		logger.debug("filename : {}", mv.getFilename());
		logger.debug("realfilename : {}", mv.getRealfilename());
		logger.debug("filePath : {}", filePath);
		
		if(profile.getSize() > 0) {
			String ext = FileUploadUtil.getExtension(realFileName);
			filePath = "D:\\profile\\" + fileName + "." + ext;
			profile.write(filePath);
		}
		
		logger.debug("parameter : {}, {}, {}, {}, {}, {}, {}, {}, {}", userid, usernm, alias, pass, addr1, addr2, zipcode, filePath, realFileName);
		
		MemberVO mvv = new MemberVO(userid, pass, usernm, alias, addr1, addr2, zipcode, filePath, realFileName); 
		
		int cnt = memberService.updateMember(mvv);
		
		if(cnt == 1) {
			response.sendRedirect(request.getContextPath() + "/member?userid=" + userid);
		}else {
			doGet(request, response);
		}
		
	} 
}
