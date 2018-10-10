package com.test.builders;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.bkr.models.DailyDetail;
import org.bkr.models.DailyHeader;

public class DailyHeaderBuilder {

	private DailyHeader dh;
	private InternalDailyDetailBuilder iddb;
	public DailyHeaderBuilder create(Date date)
	{
		dh= new DailyHeader(date);
		return this;
	}
	
	public InternalDailyDetailBuilder detailBuilder()
	{
		iddb= new InternalDailyDetailBuilder(this);
		return iddb;
	}
	
	
	public DailyHeader build()
	{
		dh.setDailyDetailses(iddb.getList());
		return dh;
	}
	
	public class InternalDailyDetailBuilder
	{
		private DailyDetailBuilder ddb=new DailyDetailBuilder();
		private DailyHeaderBuilder dhb=new DailyHeaderBuilder();
		private Set<DailyDetail> details=new HashSet<>();
		public InternalDailyDetailBuilder(DailyHeaderBuilder dhb)
		{
			this.dhb=dhb;
		}
		
		public InternalDailyDetailBuilder add(int beginningInv, int production, int endingInv, int tgafs, int sales, long amount)
		{
			ddb.add(beginningInv, production, endingInv, tgafs, sales, amount);
			return this;
		}
		
		public DailyHeaderBuilder build()
		{
			details.addAll(ddb.build());
			return dhb;
		}
		
		public Set<DailyDetail> getList()
		{
			return details;
		}
		
	}
	
}
