package org.bkr.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DHeader {

	private Long id;
	private Date date;
	private BigDecimal total;
	private BigDecimal expenses;
	private BigDecimal grandTotal;
	private BigDecimal remittance;
	private BigDecimal difference;
	
	private List<DDetail> details=new ArrayList<>();

	
	
	public DHeader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DHeader(Long id, Date date, BigDecimal total, BigDecimal expenses, BigDecimal grandTotal,
			BigDecimal remittance, BigDecimal difference, List<DDetail> details) {
		super();
		this.id = id;
		this.date = date;
		this.total = total;
		this.expenses = expenses;
		this.grandTotal = grandTotal;
		this.remittance = remittance;
		this.difference = difference;
		this.details = details;
	}

	public DHeader(Long id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getExpenses() {
		return expenses;
	}

	public void setExpenses(BigDecimal expenses) {
		this.expenses = expenses;
	}

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

	public BigDecimal getRemittance() {
		return remittance;
	}

	public void setRemittance(BigDecimal remittance) {
		this.remittance = remittance;
	}

	public BigDecimal getDifference() {
		return difference;
	}

	public void setDifference(BigDecimal difference) {
		this.difference = difference;
	}

	public List<DDetail> getDetails() {
		return details;
	}

	public void setDetails(List<DDetail> details) {
		this.details = details;
	}
	
	
	
}
