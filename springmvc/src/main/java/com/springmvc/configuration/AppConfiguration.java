package com.springmvc.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
	
	@Bean
	public SessionFactory createSessionFactory() {
		return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
	}

}
