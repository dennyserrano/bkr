package org.bkr.web;

import java.math.BigDecimal;


public class TDetail {

	private Long id;
	private long templateId;
	private long masterBreadId;
	private String breadName;
	private BigDecimal price;
	private int order;
	
	private THeader head;

	public long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}

	public long getMasterBreadId() {
		return masterBreadId;
	}

	public void setMasterBreadId(long masterBreadId) {
		this.masterBreadId = masterBreadId;
	}

	public THeader getHead() {
		return head;
	}

	public void setHead(THeader head) {
		this.head = head;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	
	
}
