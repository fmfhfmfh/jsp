package kr.or.ddit.jobs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.jobs.model.JobsVO;

public class JobsDao implements JobsDaoI{

	@Override
	public List<JobsVO> selectAllJobs() {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		List<JobsVO> list = sqlSession.selectList("jobs.selectAllJobs");
		
		sqlSession.close();
		
		return list;
	}

}
