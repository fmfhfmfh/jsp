package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;

public interface MemberDaoI {
	MemberVO getMember(String userId);
	
	List<MemberVO> selectAllMember();
	
	List<MemberVO> selectMemberPageList(SqlSession sqlSession, PageVO pv);
	
	int selectMemberTotalCnt(SqlSession sqlSession);
	
	int insertMember(MemberVO mv);
	
	int deleteMember(String userid);
	
	int updateMember(MemberVO mv);
}
