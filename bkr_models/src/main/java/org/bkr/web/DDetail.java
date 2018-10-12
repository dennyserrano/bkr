package org.bkr.web;

import java.math.BigDecimal;

public class DDetail {

	private Long id;
	private long dailyHeaderId;
	private long templateDetailId;
	private int beginningInv;
	private int production;
	private int endingInv;
	private int tgafs;
	private int sales;
	private BigDecimal amount;
	private String category;
	
	private DHeader header;
	private Bread bread;
}
