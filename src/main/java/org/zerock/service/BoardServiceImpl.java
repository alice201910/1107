package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;
	
	
	
	@Override
	public boolean register(BoardVO vo) {
		
		log.info("service register..........." + vo);
		
		return mapper.insert(vo) == 1? true: false;
		
	}



	@Override
	public List<BoardVO> getList(PageDTO dto) {
		return mapper.listPage(dto);
	}



	@Override
	public int getListCount(PageDTO dto) {
		return mapper.countPage(dto);
	}



	@Override
	public BoardVO findByBno(Integer bno) {
		
		return mapper.selectByBno(bno);
	}
}
