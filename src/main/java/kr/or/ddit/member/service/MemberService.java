package kr.or.ddit.member.service;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

@Service("memberService")
public class MemberService implements MemberServiceI {
	
	@Resource(name="memberDao")
	private MemberDaoI memberDao;
	
	@Override
	public MemberVO getMember(String userId) {
		return memberDao.getMember(userId);
	}

}
