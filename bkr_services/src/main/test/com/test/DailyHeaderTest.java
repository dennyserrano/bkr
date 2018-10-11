package com.test;

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
	
	@Autowired MasterBreadListRepository mbr;
	
	@Autowired DailyHeaderService dhs;
	
	@Test
	public void t1()
	{
		
		MasterBreadList mbl1=new MasterBreadListBuilder().create(null, "b1", 1L);
		mbr.save(mbl1);
		Template t=new TemplateBuilder()
		.create("t1")
		.addDetail(new TemplateDetailsId(1, mbl1.getId()), mbl1)
		.build();
		
		ts.save(t);
		
		TemplateDetail td= new ArrayList<TemplateDetail>(t.getTemplateDetails()).get(0);
		
		
		
		
		DailyHeader dh=new DailyHeaderBuilder()
		.create(new Date())
		.detailBuilder()
		.add(td, 1, 2, 3, 4, 5, 6)
		.build()
		.build();
		
		dhs.save(dh);
		
	}
	
}
