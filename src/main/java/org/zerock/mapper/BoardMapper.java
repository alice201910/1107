package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;

public interface BoardMapper {

	public int insert(BoardVO vo);
	
	public List<BoardVO> listPage(PageDTO dto);
	
	public int countPage(PageDTO dto);

	public BoardVO selectByBno(Integer bno);
	
}
