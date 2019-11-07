package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;

public interface BoardService {

	public boolean register(BoardVO vo);
	
	// 트랜잭션의 영향에 따라 메서드 개수 정하기
	// 화면에 따라 
	
	public List<BoardVO> getList(PageDTO dto);

	public int getListCount(PageDTO dto);
	
}
