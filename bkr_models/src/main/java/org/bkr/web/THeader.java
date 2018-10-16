package org.bkr.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class THeader {

	private Long id;
	private String name;
	
	private List<TDetail> details=new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TDetail> getDetails() {
		return details;
	}

	public void setDetails(List<TDetail> details) {
		this.details = details;
	}
	
	
	
	
}
