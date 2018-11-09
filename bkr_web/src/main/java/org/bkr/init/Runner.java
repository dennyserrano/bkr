package org.bkr.init;

import org.bkr.conf.Conf;
import org.bkr.conf.SecurityConf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner {
	
	public static void main(String[] args) {
		SpringApplication.run(new Class[] {
				Conf.class,
//				SecurityConf.class
				},args);
	}
}
