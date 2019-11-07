package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // ApplicationContext ctx�� ����ִ� ����
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper mapper;
	
	
	@Test
	public void testListSearch() {
		
		//1 page 10
		PageDTO dto = new PageDTO();
		dto.setKeyword("9");
		dto.setType("T");
		mapper.listPage(dto).forEach(vo->{
			log.info(vo);
		}); 
		
		log.info(mapper.countPage(dto));
		
	}
	
	
	
	@Test
	public void testListPage() {
		
		//1 page 10
		PageDTO dto = new PageDTO();
		dto.setPage(13);
		dto.setAmount(30);
		mapper.listPage(dto).forEach(vo->{
			log.info(vo);
		}); 
		
		log.info(mapper.countPage(dto));
		
	}
	
	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("한글테스트");
		vo.setContent("테스트용 한글......");
		vo.setWriter("세종대왕");
		
		
		log.info("==========================================");
		log.info(mapper.insert(vo));
	}
	
}
