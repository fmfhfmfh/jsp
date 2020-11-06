package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.PageVO;
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
	
	@Override
	public List<MemberVO> selectAllMember() {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		List<MemberVO> list = sqlSession.selectList("member.selectAllMember");

		sqlSession.close();
		
		return list;
	}

	@Override
	public List<MemberVO> selectMemberPageList(SqlSession sqlSession, PageVO pv) {
		
		return sqlSession.selectList("member.selectMemberPageList", pv);
	}

	@Override
	public int selectMemberTotalCnt(SqlSession sqlSession) {
		
		return sqlSession.selectOne("member.selectMemberTotalCnt");
	}

	@Override
	public int insertMember(MemberVO mv) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = 0;
		try {
			cnt = sqlSession.insert("member.insertMember", mv);
		}catch (Exception e) {
			
		}
		
		if(cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return cnt;
	}

	@Override
	public int deleteMember(String userid) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		int cnt = sqlSession.delete("member.deleteMember", userid);
		
		if(cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		int cnt = sqlSession.delete("member.updateMember", mv);
		
		if(cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return cnt;
	}

}
