package kr.or.ddit.jobs.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.jobs.model.JobsVO;

public class JobsDaoTest {

	@Test
	public void JobsDaoTest() {
		/***Given***/
		
		JobsDaoI jobsDao = new JobsDao();
		
		/***When***/
		
		List<JobsVO> list = jobsDao.selectAllJobs();
		
		/***Then***/
		
		assertEquals(19, list.size());
	}

}
