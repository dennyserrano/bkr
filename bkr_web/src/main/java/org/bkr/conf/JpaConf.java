package org.bkr.conf;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories(basePackages="org.bkr.services.repo")
@Configuration
public class JpaConf {

	
		private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	    private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
	    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
	
	    @Autowired DataSourceProperties dp;
	    
	    @Autowired Environment e;
	    
		@Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
	      
			LocalContainerEntityManagerFactoryBean entityManagerFactoryBean=new LocalContainerEntityManagerFactoryBean();
			entityManagerFactoryBean.setDataSource(dataSource());
			entityManagerFactoryBean.setPackagesToScan("org.bkr.models");
			entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
			Properties jpaProterties = new Properties();
		     jpaProterties.put(PROPERTY_NAME_HIBERNATE_DIALECT, e.getProperty("spring.jpa.properties.hibernate.dialect"));
		     
		     String ddlAuto=e.getProperty("spring.jpa.hibernate.ddl-auto");
		     
		     if(ddlAuto!=null || !ddlAuto.isEmpty())
		    	 jpaProterties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, ddlAuto);
		     jpaProterties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, "org.hibernate.cfg.ImprovedNamingStrategy");
		     jpaProterties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, Boolean.valueOf(e.getProperty("spring.jpa.show-sql")));
			
			entityManagerFactoryBean.setJpaProperties(jpaProterties);
			return entityManagerFactoryBean;
	    }
	
		@Bean
		public DataSource dataSource()
		{
			
			System.out.println("***************");
			System.out.println("DB URL:"+dp.getUrl());
			System.out.println("***************");
			
			return DataSourceBuilder.create()
					.driverClassName(dp.getDriverClassName())
					.username(dp.getUsername())
					.password(dp.getPassword())
					.url(dp.getUrl())
					.build();
		}
		
		 @Bean
		  public PlatformTransactionManager transactionManager() {
		      JpaTransactionManager txManager = new JpaTransactionManager();
		      txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		      return txManager;
		  }
		
}
