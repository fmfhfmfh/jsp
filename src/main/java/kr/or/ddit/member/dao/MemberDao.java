package kr.or.ddit.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

@Repository("memberDao")
public class MemberDao implements MemberDaoI{

	@Override
	public MemberVO getMember(String userId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		MemberVO memberVo = sqlSession.selectOne("member.getMember", userId);
		
		sqlSession.close();
		
		return memberVo;
	}

}
