package kr.or.ddit.jobs.service;

import java.util.List;

import kr.or.ddit.jobs.model.JobsVO;

public interface JobsServiceI {
	
	// job의 모든 정보 조회
	List<JobsVO> selectAllJobs();
}
