package org.bkr.web;

import java.math.BigDecimal;

public class Bread {

	private Long id;
	private String breadName;
	private BigDecimal price;
	
	
	
	public Bread() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBreadName() {
		return breadName;
	}
	public void setBreadName(String breadName) {
		this.breadName = breadName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Bread [id=" + id + ", breadName=" + breadName + ", price=" + price + "]";
	}
	
	
	
}
