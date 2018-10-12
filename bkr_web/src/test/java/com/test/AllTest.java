package com.test;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.bkr.conf.Conf;
import org.bkr.models.DailyHeader;
import org.bkr.models.MasterBreadList;
import org.bkr.models.Template;
import org.bkr.models.TemplateDetail;
import org.bkr.models.TemplateDetailsId;
import org.bkr.services.interfaces.DailyHeaderService;
import org.bkr.services.interfaces.MasterBreadListService;
import org.bkr.services.interfaces.TemplateDetailService;
import org.bkr.services.interfaces.TemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.builders.DailyHeaderBuilder;
import com.test.builders.MasterBreadListBuilder;
import com.test.builders.TemplateBuilder;

@SpringBootTest(classes=Conf.class)
@RunWith(SpringRunner.class)
public class AllTest {

	@Autowired MasterBreadListService mbls;
	
	@Autowired TemplateService ts;
	
	@Autowired TemplateDetailService tds;
	
	@Autowired DailyHeaderService dhs;
	
	@Test
	public void t1()
	{
		MasterBreadList mbl1=new MasterBreadListBuilder().create(null, "b1", 1L);
		MasterBreadList mbl2=new MasterBreadListBuilder().create(null, "b2", 2L);
		mbls.save(mbl1);
		mbls.save(mbl2);
		
	}
	
	@Test
	public void t2()
	{
		MasterBreadList mbl1= mbls.findById(1L);
		MasterBreadList mbl2=mbls.findById(2L);
		
		Template t=new TemplateBuilder()
		.create("t1")
		.addDetail(new TemplateDetailsId(1, mbl1.getId()), mbl1)
		.addDetail(new TemplateDetailsId(1, mbl2.getId()), mbl2)
		.build();
		
		ts.save(t);
	}
	
	@Test
	public void t3()
	{
		List<TemplateDetail> l=tds.findByTemplateId(1L);
	
		DailyHeader dh=new DailyHeaderBuilder()
				.create(new Date())
				.detailBuilder()
				.add(l.get(0), 1, 2, 3, 4, 5, BigDecimal.valueOf(6.2),"AM")
				.add(l.get(1), 1, 2, 3, 4, 5,  BigDecimal.valueOf(6.5),"PM")
				.build()
				.build();
		
		dhs.save(dh);
	}
	
}
