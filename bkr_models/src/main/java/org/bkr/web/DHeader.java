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
	
	private List<TDetail> details=new ArrayList<>();

	public DHeader(Long id, Date date, BigDecimal total, BigDecimal expenses, BigDecimal grandTotal,
			BigDecimal remittance, BigDecimal difference, List<TDetail> details) {
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
	
}
