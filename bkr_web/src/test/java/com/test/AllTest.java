package com.test;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.bkr.conf.Conf;
import org.bkr.conf.JpaConf;
import org.bkr.models.DailyHeader;
import org.bkr.models.MasterBreadList;
import org.bkr.models.Template;
import org.bkr.models.TemplateDetail;
import org.bkr.services.factories.DHeaderFactory;
import org.bkr.services.factories.DailyHeaderFactory;
import org.bkr.services.service.interfaces.DailyHeaderService;
import org.bkr.services.service.interfaces.MasterBreadListService;
import org.bkr.services.service.interfaces.TemplateDetailService;
import org.bkr.services.service.interfaces.TemplateService;
import org.bkr.web.DDetail;
import org.bkr.web.DHeader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.test.builders.DailyHeaderBuilder;
import com.test.builders.MasterBreadListBuilder;
import com.test.builders.TemplateBuilder;

@SpringBootTest(classes= {Conf.class,JpaConf.class})
@RunWith(SpringRunner.class)
public class AllTest {

	@Autowired MasterBreadListService mbls;
	
	@Autowired TemplateService ts;
	
	@Autowired TemplateDetailService tds;
	
	@Autowired DailyHeaderService dhs;
	
	@Test
	public void t1()
	{
		MasterBreadList mbl1=new MasterBreadListBuilder().create(null, "b1", new BigDecimal(1));
		MasterBreadList mbl2=new MasterBreadListBuilder().create(null, "b2", new BigDecimal(2));
		mbls.save(mbl1);
		mbls.save(mbl2);
		
	}
	
	@Test
	public void t2()
	{
		MasterBreadList mbl1= mbls.findById(1L);
		MasterBreadList mbl2=mbls.findById(2L);
		
//		Template t=new TemplateBuilder()
//		.create("t1")
//		.addDetail(new TemplateDetailsId(1, mbl1.getId()), mbl1)
//		.addDetail(new TemplateDetailsId(1, mbl2.getId()), mbl2)
//		.build();
		
//		ts.save(t);
		
		Template t=new Template();
		t.setName("t1");
		t.setTemplateDetails(new HashSet<>());
		t.getTemplateDetails().add(new TemplateDetail(mbl1.getId(), 1));
		t.getTemplateDetails().add(new TemplateDetail(mbl2.getId(), 1));
		ts.save(t);
		
		for(TemplateDetail td:t.getTemplateDetails())
			{
				assertNotNull(td.getPrice());
			}
		
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
	
//	@Test
//	public void t4()
//	{
//		
//		Template t=ts.fetchFullById(1L);
//		
//		DHeader d=DHeaderFactory.createNew(t);
//		for(DDetail detail:d.getAmList())
//			System.out.println(detail);
//	}
	
}
