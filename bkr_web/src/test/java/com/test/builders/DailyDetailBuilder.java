package com.test.builders;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.bkr.models.DailyDetail;

public class DailyDetailBuilder {

	private Set<DailyDetail> details=new HashSet<>();
	
	
	
	public DailyDetailBuilder create(int beginningInv, int production, int endingInv, int tgafs, int sales, BigDecimal amount,String category)
	{
		details.add(new DailyDetail(beginningInv, production, endingInv, tgafs, sales, amount,category));
		return this;
	}
	
	public Set<DailyDetail> build()
	{
		return details;
	}
	
}
