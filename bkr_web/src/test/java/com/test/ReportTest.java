package com.test;

import java.util.Arrays;

import org.bkr.conf.Conf;
import org.bkr.conf.JpaConf;
import org.bkr.models.DailyHeader;
import org.bkr.services.repo.ReportRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes= {Conf.class,JpaConf.class})
@RunWith(SpringRunner.class)
public class ReportTest {

	
	@Autowired
	private ReportRepository rr;
	
//	@Test
//	public void t1()
//	{
//		for(Integer l:rr.allYear())
//			System.out.println(l);
//	}
	
	@Test
	public void t2()
	{
		
		for(DailyHeader i:rr.headerByYear(2018))
			System.out.println(i);
	}
	
//	@Test
//	public void t3()
//	{
//		for(DailyHeader dh:rr.m(2018,12))
//		{
//			System.out.println(dh);
//		}
//	}
	
}
