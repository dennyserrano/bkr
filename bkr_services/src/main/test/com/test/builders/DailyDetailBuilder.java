package com.test.builders;

import java.util.HashSet;
import java.util.Set;

import org.bkr.models.DailyDetail;

public class DailyDetailBuilder {

	private Set<DailyDetail> details=new HashSet<>();
	
	
	
	public DailyDetailBuilder add(int beginningInv, int production, int endingInv, int tgafs, int sales, long amount)
	{
		details.add(new DailyDetail(beginningInv, production, endingInv, tgafs, sales, amount));
		return this;
	}
	
	public Set<DailyDetail> build()
	{
		return details;
	}
	
}
