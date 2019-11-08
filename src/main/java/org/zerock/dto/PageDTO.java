package org.zerock.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class PageDTO {
	
	private Integer bno;	// null이 가능하면 Integer로
	private int page = 1;
	private int amount = 10;
	private String keyword;
	private String type;
	
	public String[] getTypes() {
		if(type == null || type.trim().length() == 0) {
			return null;
		}
		return type.split("");
	}
	
	public int getSkip() {
		
		return (page-1)*amount;
	}
	
	public String getLink(Integer bno) throws UnsupportedEncodingException {
		String result = "";
		
		result = UriComponentsBuilder.newInstance()
		.queryParam("bno", bno)
		.queryParam("keyword", URLEncoder.encode("서울 종로 종로1가","UTF-8"))
		.build().getQuery();
		
		return result;
	}
}
