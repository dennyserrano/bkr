package org.bkr.web;

public class Bread {

	private Long id;
	private String breadName;
	private Long price;
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
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Bread [id=" + id + ", breadName=" + breadName + ", price=" + price + "]";
	}
	
	
	
}
