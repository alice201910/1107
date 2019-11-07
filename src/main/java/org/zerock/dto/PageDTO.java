package org.zerock.dto;

import lombok.Data;

@Data
public class PageDTO {
	
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
}
