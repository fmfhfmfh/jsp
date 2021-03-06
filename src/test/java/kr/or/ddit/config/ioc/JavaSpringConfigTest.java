package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.repository.BoardRepositoryI;
import kr.or.ddit.board.service.BoardServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JavaSpringConfig.class})
public class JavaSpringConfigTest {

	@Resource(name="boardRepository")
	private BoardRepositoryI boardRepository;
	
	@Resource(name="boardService")
	private BoardServiceI boardService;
	
	// boardRepository, boardService 스프링 빈이 정상적으로 등록되었는지 확인
	@Test
	public void beanTest() {
		/***Given***/
		
		/***When***/
		BoardVO bv = boardService.getBoard(1);

		/***Then***/
		assertNotNull(boardRepository);
		assertNotNull(boardService);
		assertEquals(bv.getContent(), "내용");
	}
}
