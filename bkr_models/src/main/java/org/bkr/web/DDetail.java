package org.bkr.web;

import java.math.BigDecimal;

public class DDetail {

	private Long id;
	private Long dailyHeaderId;
	
	private int beginningInv;
	private int production;
	private int endingInv;
	private int tgafs;
	private int sales;
	private BigDecimal amount;
	private String category;
	
	private TDetail templateDetail;
	
	public DDetail() {
		super();
		setAmount(BigDecimal.ZERO);
	}
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
	
	
	public Long getDailyHeaderId() {
		return dailyHeaderId;
	}
	public void setDailyHeaderId(Long dailyHeaderId) {
		this.dailyHeaderId = dailyHeaderId;
	}
	public TDetail getTemplateDetail() {
		return templateDetail;
	}
	public void setTemplateDetail(TDetail templateDetail) {
		this.templateDetail = templateDetail;
	}
	@Override
	public String toString() {
		return "DDetail [id=" + id +  ", beginningInv=" + beginningInv + ", production=" + production + ", endingInv=" + endingInv
				+ ", tgafs=" + tgafs + ", sales=" + sales + ", amount=" + amount + ", category=" + category
				+ "]";
	}
	
	
	
}
