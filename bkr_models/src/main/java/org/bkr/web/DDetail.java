package org.bkr.web;

import java.math.BigDecimal;

public class DDetail {

	private Long id;
	private long templateId;
	private int beginningInv;
	private int production;
	private int endingInv;
	private int tgafs;
	private int sales;
	private BigDecimal amount;
	private String category;
	
	private DHeader header;
	private Bread bread;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getBeginningInv() {
		return beginningInv;
	}
	public void setBeginningInv(int beginningInv) {
		this.beginningInv = beginningInv;
	}
	public int getProduction() {
		return production;
	}
	public void setProduction(int production) {
		this.production = production;
	}
	public int getEndingInv() {
		return endingInv;
	}
	public void setEndingInv(int endingInv) {
		this.endingInv = endingInv;
	}
	public int getTgafs() {
		return tgafs;
	}
	public void setTgafs(int tgafs) {
		this.tgafs = tgafs;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public DHeader getHeader() {
		return header;
	}
	public void setHeader(DHeader header) {
		this.header = header;
	}
	public Bread getBread() {
		return bread;
	}
	public void setBread(Bread bread) {
		this.bread = bread;
	}
	public long getTemplateId() {
		return templateId;
	}
	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}
	@Override
	public String toString() {
		return "DDetail [id=" + id + ", templateId=" + templateId  + ", beginningInv=" + beginningInv + ", production=" + production + ", endingInv=" + endingInv
				+ ", tgafs=" + tgafs + ", sales=" + sales + ", amount=" + amount + ", category=" + category
				+ ", header=" + header + ", " + bread.toString() + "]";
	}
	
	
	
}
