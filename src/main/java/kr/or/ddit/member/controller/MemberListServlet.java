package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@WebServlet("/memberList")
public class MemberListServlet extends HttpServlet {
	
	MemberServiceI memberService;
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// page
		String page_str = req.getParameter("page");
		
		int page = page_str == null ? 1 : Integer.parseInt(page_str);
		
		req.setAttribute("page", page);
		
		// pageSize
		String pageSize_str = req.getParameter("pageSize");
		
		int pageSize = pageSize_str == null ? 5 : Integer.parseInt(pageSize_str);
		
		req.setAttribute("pageSize", pageSize);
		
		// PageVO : page, pageSize
		PageVO pv = new PageVO(page, pageSize);
		
		// req.setAttribute("list", memberService.selectAllList());
		// memberService.selectMemberPageList(page) ==> List<MemberVO> ==> Map<String, Object>
		
		Map<String, Object> map = memberService.selectMemberPageList(pv);
		req.setAttribute("list", map.get("memberList"));
		req.setAttribute("pages", map.get("pages"));
		
		req.getRequestDispatcher("/member/memberList.jsp").forward(req, resp);
		
	}
	
	
}
