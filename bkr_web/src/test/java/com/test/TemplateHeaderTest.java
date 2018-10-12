package com.test;

import java.util.Date;
import java.util.HashSet;

import org.bkr.conf.Conf;
import org.bkr.models.DailyDetail;
import org.bkr.models.DailyHeader;
import org.bkr.models.MasterBreadList;
import org.bkr.models.Template;
import org.bkr.models.TemplateDetail;
import org.bkr.models.TemplateDetailsId;
import org.bkr.repo.DailyDetailRepository;
import org.bkr.repo.DailyHeaderRepository;
import org.bkr.repo.MasterBreadListRepository;
import org.bkr.repo.TemplateDetailRepository;
import org.bkr.repo.TemplateRepository;
import org.bkr.services.interfaces.MasterBreadListService;
import org.bkr.services.interfaces.TemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.builders.DailyHeaderBuilder;
import com.test.builders.MasterBreadListBuilder;
import com.test.builders.TemplateBuilder;

@SpringBootTest(classes=Conf.class)
@RunWith(SpringRunner.class)
public class TemplateHeaderTest {
	
	@Autowired MasterBreadListService mbls;
	
	@Autowired TemplateService ts;
	
	@Autowired TemplateDetailRepository tdr;
	
	@Test
	public void t1()
	{
		MasterBreadList mbl1= mbls.findById(1L);
		MasterBreadList mbl2=mbls.findById(2L);
		
		Template t=new TemplateBuilder()
		.create("t1")
		.addDetail(new TemplateDetailsId(1, mbl1.getId()), mbl1)
		.addDetail(new TemplateDetailsId(1, mbl2.getId()), mbl2)
		.build();
		
		ts.save(t);
		
		
		System.out.println(tdr.findIdByTemplateId(1).size());
		
	}
	
	
}
