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
	private BigDecimal amRemittance;
	private BigDecimal pmRemittance;
	private BigDecimal amExpenses;
	private BigDecimal pmExpenses;
	
	private List<DDetail> amList=new ArrayList<>();
	private List<DDetail> pmList=new ArrayList<>();
	
	
	public DHeader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DHeader(Long id, Date date, BigDecimal total, BigDecimal expenses, BigDecimal grandTotal,
			BigDecimal remittance, BigDecimal difference) {
		super();
		this.id = id;
		this.date = date;
		this.total = total;
		this.expenses = expenses;
		this.grandTotal = grandTotal;
		this.remittance = remittance;
		this.difference = difference;
		this.amRemittance=BigDecimal.ZERO;
		this.amExpenses=BigDecimal.ZERO;
		this.pmExpenses=BigDecimal.ZERO;
		this.pmRemittance=BigDecimal.ZERO;
	}

	public DHeader(Long id, Date date) {
		super();
		this.id = id;
		this.date = date;
		
		this.setDifference(BigDecimal.ZERO);
		this.setExpenses(BigDecimal.ZERO);
		this.setGrandTotal(BigDecimal.ZERO);
		this.setRemittance(BigDecimal.ZERO);
		this.setTotal(BigDecimal.ZERO);
		this.amRemittance=BigDecimal.ZERO;
		this.amExpenses=BigDecimal.ZERO;
		this.pmExpenses=BigDecimal.ZERO;
		this.pmRemittance=BigDecimal.ZERO;
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

	

	public List<DDetail> getAmList() {
		return amList;
	}

	public void setAmList(List<DDetail> amList) {
		this.amList = amList;
	}

	public List<DDetail> getPmList() {
		return pmList;
	}

	public void setPmList(List<DDetail> pmList) {
		this.pmList = pmList;
	}

	public BigDecimal getAmRemittance() {
		return amRemittance;
	}

	public void setAmRemittance(BigDecimal amRemittance) {
		this.amRemittance = amRemittance;
	}

	public BigDecimal getPmRemittance() {
		return pmRemittance;
	}

	public void setPmRemittance(BigDecimal pmRemittance) {
		this.pmRemittance = pmRemittance;
	}

	public BigDecimal getAmExpenses() {
		return amExpenses;
	}

	public void setAmExpenses(BigDecimal amExpenses) {
		this.amExpenses = amExpenses;
	}

	public BigDecimal getPmExpenses() {
		return pmExpenses;
	}

	public void setPmExpenses(BigDecimal pmExpenses) {
		this.pmExpenses = pmExpenses;
	}
	
	
	
}
