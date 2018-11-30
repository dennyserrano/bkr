package org.bkr.models;
// Generated 09 26, 18 5:30:50 PM by Hibernate Tools 5.2.11.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DailyDetails generated by hbm2java
 */
@Entity
@Table(name = "daily_details")
public class DailyDetail implements java.io.Serializable {

	private Long id;
	private DailyHeader dailyHeader;
	private TemplateDetail templateDetail;
	private int beginningInv;
	private int production;
	private int endingInv;
	private int tgafs;
	private int sales;
	private BigDecimal amount;
	private String category;
	
	public DailyDetail() {
	}

	public DailyDetail(int beginningInv, int production, int endingInv, int tgafs, int sales, BigDecimal amount,String category) {
		this.beginningInv = beginningInv;
		this.production = production;
		this.endingInv = endingInv;
		this.tgafs = tgafs;
		this.sales = sales;
		this.amount = amount;
		this.category=category;
	}

	public DailyDetail(DailyHeader dailyHeader, TemplateDetail templateDetails, int beginningInv, int production,
			int endingInv, int tgafs, int sales, BigDecimal amount,String category) {
		this.dailyHeader = dailyHeader;
		this.templateDetail = templateDetails;
		this.beginningInv = beginningInv;
		this.production = production;
		this.endingInv = endingInv;
		this.tgafs = tgafs;
		this.sales = sales;
		this.amount = amount;
		this.category=category;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "daily_head_id")
	public DailyHeader getDailyHeader() {
		return this.dailyHeader;
	}

	public void setDailyHeader(DailyHeader dailyHeader) {
		this.dailyHeader = dailyHeader;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "template_detail_id")
	public TemplateDetail getTemplateDetail() {
		return this.templateDetail;
	}

	public void setTemplateDetail(TemplateDetail templateDetails) {
		this.templateDetail = templateDetails;
	}

	@Column(name = "beginning_inv", nullable = false)
	public int getBeginningInv() {
		return this.beginningInv;
	}

	public void setBeginningInv(int beginningInv) {
		this.beginningInv = beginningInv;
	}

	@Column(name = "production", nullable = false)
	public int getProduction() {
		return this.production;
	}

	public void setProduction(int production) {
		this.production = production;
	}

	@Column(name = "ending_inv", nullable = false)
	public int getEndingInv() {
		return this.endingInv;
	}

	public void setEndingInv(int endingInv) {
		this.endingInv = endingInv;
	}

	@Column(name = "tgafs", nullable = false)
	public int getTgafs() {
		return this.tgafs;
	}

	public void setTgafs(int tgafs) {
		this.tgafs = tgafs;
	}

	@Column(name = "sales", nullable = false)
	public int getSales() {
		return this.sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	@Column(name = "amount", nullable = false, precision = 10, scale = 2)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "category", length = 45)
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	
}
