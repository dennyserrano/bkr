package com.test;

import java.util.Date;
import java.util.HashSet;

import org.bkr.conf.Conf;
import org.bkr.models.DailyDetail;
import org.bkr.models.DailyHeader;
import org.bkr.models.Template;
import org.bkr.models.TemplateDetail;
import org.bkr.repo.DailyHeaderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.builders.DailyHeaderBuilder;

@SpringBootTest(classes=Conf.class)
@RunWith(SpringRunner.class)
public class Hello {
	
	@Autowired
	private DailyHeaderRepository dhr;
	
	
	
	
	@Test
	public void t1()
	{
		DailyHeaderBuilder dhb=new DailyHeaderBuilder();
		DailyHeader dh=dhb.create(new Date())
		.detailBuilder()
		.add(1, 2, 3, 4, 5, 6)
		.add(1, 4, 6, 7, 8, 9)
		.build()
		.build();
		
		System.out.println();
	}
	
}
