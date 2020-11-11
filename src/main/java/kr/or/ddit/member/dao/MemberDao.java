package kr.or.ddit.member.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

@Repository("memberDao")
public class MemberDao implements MemberDaoI{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public MemberVO getMember(String userId) {
		
		MemberVO memberVo = sqlSession.selectOne("member.getMember", userId);
		
		return memberVo;
	}
	
	@Override
	public List<MemberVO> selectAllMember() {
		
		List<MemberVO> list = sqlSession.selectList("member.selectAllMember");

		return list;
	}

	@Override
	public List<MemberVO> selectMemberPageList(PageVO pv) {
		
		return sqlSession.selectList("member.selectMemberPageList", pv);
	}

	@Override
	public int selectMemberTotalCnt() {
		
		return sqlSession.selectOne("member.selectMemberTotalCnt");
	}

	@Override
	public int insertMember(MemberVO mv) {
		
		return sqlSession.insert("member.insertMember", mv);
	}

	@Override
	public int deleteMember(String userid) {
		
		int cnt = sqlSession.delete("member.deleteMember", userid);
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) {
		
		int cnt = sqlSession.delete("member.updateMember", mv);
		
		return cnt;
	}

}
