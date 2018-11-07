package com.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.bkr.conf.Conf;
import org.bkr.models.DailyDetail;
import org.bkr.models.DailyHeader;
import org.bkr.models.MasterBreadList;
import org.bkr.models.Template;
import org.bkr.models.TemplateDetail;
import org.bkr.services.factories.DHeaderFactory;
import org.bkr.services.factories.DailyHeaderFactory;
import org.bkr.services.factories.TemplateFactory;
import org.bkr.services.factories.exc.DependencyException;
import org.bkr.services.repo.DailyDetailRepository;
import org.bkr.services.service.interfaces.DailyHeaderService;
import org.bkr.services.service.interfaces.TemplateService;
import org.bkr.services.utilities.DailyHeaderHelper;
import org.bkr.web.DDetail;
import org.bkr.web.DHeader;
import org.bkr.web.TDetail;
import org.bkr.web.THeader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.builders.DailyHeaderBuilder;
import com.test.builders.MasterBreadListBuilder;
import com.test.builders.TemplateBuilder;

import junit.framework.Assert;

@SpringBootTest(classes=Conf.class)
@RunWith(MockitoJUnitRunner.class)
public class FactoryTest {

	
	@Mock DailyHeader dailyHeader;
	@Mock MasterBreadList bread1;
	@Mock MasterBreadList bread2;
	@Mock TemplateDetail td1;
	@Mock TemplateDetail td2;
	@Mock Template template;
	
	
	
	@Before()
	public void breadBefore()
	{
		bread1=new MasterBreadList(1L,"Pandesal", new BigDecimal(2));
		bread2=new MasterBreadList(2L,"Monay", new BigDecimal(2));
		
		td1=new TemplateDetail(bread1,template);
		td2=new TemplateDetail(bread2, template);
		
		template =new Template();
		template.setTemplateDetails(new HashSet<>());
		template.getTemplateDetails().add(td1);
		template.getTemplateDetails().add(td2);
		
		
		dailyHeader=new DailyHeader(new Date());
		dailyHeader.setDifference(new BigDecimal(5));
		dailyHeader.setExpenses(new BigDecimal(6));
		dailyHeader.setGrandTotal(new BigDecimal(7));
		dailyHeader.setRemittance(new BigDecimal(8));
		dailyHeader.setTotal(new BigDecimal(9));
		dailyHeader.setDailyDetailses(new HashSet<>());
		dailyHeader.setAmExpenses(new BigDecimal(50));
		dailyHeader.setPmExpenses(new BigDecimal(30));
		dailyHeader.setAmRemittance(new BigDecimal(1000));
		dailyHeader.setPmRemittance(new BigDecimal(2000));
		
		DailyDetail dd1=new DailyDetail(1, 2, 3, 4, 5, new BigDecimal(6), "AM");
		dd1.setTemplateDetail(td1);
		DailyDetail dd2=new DailyDetail(1, 2, 3, 4, 5, new BigDecimal(6), "PM");
		dd2.setTemplateDetail(td1);
		DailyDetail dd3=new DailyDetail(7, 8, 9, 10, 11, new BigDecimal(12), "AM");
		dd3.setTemplateDetail(td2);
		DailyDetail dd4=new DailyDetail(7, 8, 9, 10, 11, new BigDecimal(12), "PM");
		dd4.setTemplateDetail(td2);
		
		dd1.setDailyHeader(dailyHeader);
		dd2.setDailyHeader(dailyHeader);
		dd3.setDailyHeader(dailyHeader);
		dd4.setDailyHeader(dailyHeader);
		
		dailyHeader.setDailyDetailses(new HashSet<>());
		dailyHeader.getDailyDetailses().add(dd1);
		dailyHeader.getDailyDetailses().add(dd2);
		dailyHeader.getDailyDetailses().add(dd3);
		dailyHeader.getDailyDetailses().add(dd4);
		
		
	}
	
	
	
	@Test
	public void dheaderTestConversion()
	{
		DHeader dh=DHeaderFactory.generate(dailyHeader);
		assertEquals(new BigDecimal(5),dh.getDifference());
		assertEquals(new BigDecimal(6),dh.getExpenses() );
		assertEquals(new BigDecimal(7), dh.getGrandTotal());
		assertEquals(new BigDecimal(8),dh.getRemittance() );
		assertEquals(new BigDecimal(9), dh.getTotal());
		assertEquals(4,dh.getAmList().size()+dh.getPmList().size());
		
	}
	
	@Test
	public void ddetailTestConversion()
	{
		DHeader dh=DHeaderFactory.generate(dailyHeader);
		ArrayList<DDetail> al=new ArrayList<>();
		for(DDetail d:dh.getAmList())		
		{
			if(d.getTemplateDetail().getBreadName().equals(bread1.getBreadName()))
				al.add(d);
		}
		
		for(DDetail d:dh.getPmList())
		{
			if(d.getTemplateDetail().getBreadName().equals(bread1.getBreadName()))
				al.add(d);
		}
		DDetail d1= al.get(0);
		assertEquals(1, d1.getBeginningInv());
		assertEquals(2, d1.getProduction());
		assertEquals(3, d1.getEndingInv());
		
		String cat=al.get(0).getCategory()+al.get(1).getCategory();
		
		assertTrue(cat.equals("AMPM") || cat.equals("PMAM"));
		
	}
	
	@Test
	public void dailyHeaderConversion() throws DependencyException
	{
		DHeader dheader=DHeaderFactory.generate(dailyHeader);
		DailyHeader dh=DailyHeaderFactory.generate(dheader);
		assertEquals(new BigDecimal(5),dh.getDifference());
		assertEquals(new BigDecimal(6),dh.getExpenses() );
		assertEquals(new BigDecimal(7), dh.getGrandTotal());
		assertEquals(new BigDecimal(8),dh.getRemittance() );
		assertEquals(new BigDecimal(9), dh.getTotal());
		assertEquals(4,dh.getDailyDetailses().size());
		
	}
	
	@Test
	public void dailyDetailConversion() throws DependencyException
	{
		DHeader dheader=DHeaderFactory.generate(dailyHeader);
		DailyHeader dh=DailyHeaderFactory.generate(dheader);
		ArrayList<DailyDetail> al=new ArrayList<>();
		
		for(DailyDetail d:dh.getDailyDetailses())		
		{
			if(d.getTemplateDetail().getMasterBreadList().getId()==bread1.getId())
				al.add(d);
		}
		
		DailyDetail d1=al.get(0);
		assertEquals(1, d1.getBeginningInv());
		assertEquals(2, d1.getProduction());
		assertEquals(3, d1.getEndingInv());
		
		String cat=al.get(0).getCategory()+al.get(1).getCategory();
		
		assertTrue(cat.equals("AMPM") || cat.equals("PMAM"));
	}
	
	@Test
	public void dailyHeaderComputeTest()
	{
		DailyHeader d=DailyHeaderHelper.align(dailyHeader);
		assertEquals(3000, d.getRemittance().intValue());
		assertEquals(80, d.getExpenses().intValue());
		assertEquals(36, d.getTotal().intValue());
		assertEquals(-44, d.getGrandTotal().intValue());
		assertEquals(3044, d.getDifference().intValue());
	}
	
}
