package org.zerock.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageMaker {

	private int start, end;
	private boolean prev, next;
	private int total;
	private PageDTO dto;
	
	public PageMaker(PageDTO dto, int total) {
		this.dto = dto;
		this.total = total;
		
		int tempEnd = (int)Math.ceil(dto.getPage()/10.0) * 10;
		this.start = tempEnd - 9;
		
		this.prev = start != 1;
		
		int realEnd = (int)(Math.ceil(total/(double)dto.getAmount()));
		
		if(realEnd < tempEnd) {
			this.end = realEnd;
		}else {
			this.end = tempEnd;
		}
		
		this.next = this.end * dto.getAmount() < total;
	}
	
}
