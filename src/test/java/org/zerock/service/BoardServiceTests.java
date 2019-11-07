package org.zerock.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // ApplicationContext ctx�� ����ִ� ����
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	@Test
	public void testRegister() {
		BoardVO vo = new BoardVO();
		vo.setTitle("한글테스트");
		vo.setContent("테스트용 한글......");
		vo.setWriter("세종대왕");
		
		boolean result = service.register(vo);
		
		assertTrue(result);
	}
	
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
}
