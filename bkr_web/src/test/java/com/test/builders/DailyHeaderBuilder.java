package com.test.builders;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.bkr.models.DailyDetail;
import org.bkr.models.DailyHeader;
import org.bkr.models.TemplateDetail;

public class DailyHeaderBuilder {

	private DailyHeader dh;
	private InternalDailyDetailBuilder iddb;
	public DailyHeaderBuilder create(Date date)
	{
		dh= new DailyHeader(date);
		dh.setDifference(BigDecimal.ZERO);
		dh.setExpenses(BigDecimal.ZERO);
		dh.setGrandTotal(BigDecimal.ZERO);
		dh.setRemittance(BigDecimal.ZERO);
		dh.setTotal(BigDecimal.ZERO);
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
		
		public InternalDailyDetailBuilder add(int beginningInv, int production, int endingInv, int tgafs, int sales, BigDecimal amount,String category)
		{
			DailyDetail detail=new DailyDetail(beginningInv, production, endingInv, tgafs, sales, amount,category);
			details.add(detail);
			return this;
		}
		
		public InternalDailyDetailBuilder add(TemplateDetail td,int beginningInv, int production, int endingInv, int tgafs, int sales, BigDecimal amount,String category)
		{
			DailyDetail detail=new DailyDetail(dh,td,beginningInv, production, endingInv, tgafs, sales, amount,category);
			details.add(detail);
			return this;
		}
		
		public DailyHeaderBuilder build()
		{
			return dhb;
		}
		
		protected Set<DailyDetail> getList()
		{
			return details;
		}
		
	}
	
}
