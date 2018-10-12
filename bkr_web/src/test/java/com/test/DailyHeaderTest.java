package com.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.bkr.conf.Conf;
import org.bkr.models.DailyHeader;
import org.bkr.models.MasterBreadList;
import org.bkr.models.Template;
import org.bkr.models.TemplateDetail;
import org.bkr.models.TemplateDetailsId;
import org.bkr.repo.DailyDetailRepository;
import org.bkr.repo.MasterBreadListRepository;
import org.bkr.services.interfaces.DailyHeaderService;
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
public class DailyHeaderTest {

	@Autowired DailyDetailRepository ddr;
	
	@Autowired TemplateService ts;
	
	
	@Autowired DailyHeaderService dhs;
	
	@Test
	public void t1()
	{
		System.out.println("hello");
//		Template t=new TemplateBuilder()
//		.create("t1")
//		.addDetail(new TemplateDetailsId(1, mbl1.getId()), mbl1)
//		.addDetail(new TemplateDetailsId(1, mbl2.getId()), mbl2)
//		.build();
//		
//		ts.save(t);
//		
//		TemplateDetail td1= new ArrayList<TemplateDetail>(t.getTemplateDetails()).get(0);
//		TemplateDetail td2= new ArrayList<TemplateDetail>(t.getTemplateDetails()).get(1);
//		
//		
//		DailyHeader dh=new DailyHeaderBuilder()
//		.create(new Date())
//		.detailBuilder()
//		.add(td1, 1, 2, 3, 4, 5, BigDecimal.valueOf(6.2),"AM")
//		.add(td2, 1, 2, 3, 4, 5,  BigDecimal.valueOf(6.5),"PM")
//		.build()
//		.build();
//		
//		dhs.save(dh);
		
	}
	
}
