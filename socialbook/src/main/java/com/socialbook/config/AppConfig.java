package com.socialbook.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.context.annotation.Bean;
import org.hibernate.SessionFactory;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.socialbook")
public class AppConfig implements WebMvcConfigurer {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource d = new DriverManagerDataSource();
		d.setDriverClassName("com.mysql.cj.jdbc.Driver");
		d.setUrl(
				"jdbc:mysql://localhost:3306/socialbook?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC");
		d.setUsername("root");
		d.setPassword("rajesh");
		return d;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) {
		LocalSessionFactoryBean f = new LocalSessionFactoryBean();
		f.setDataSource(ds);
		f.setPackagesToScan("com.socialbook.model");
		Properties p = new Properties();
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		p.setProperty("hibernate.show_sql", "true");
		p.setProperty("hibernate.format_sql", "true");
		f.setHibernateProperties(p);
		return f;
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sf) {
		return new HibernateTransactionManager(sf);
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver r = new InternalResourceViewResolver();
		r.setPrefix("/WEB-INF/views/");
		r.setSuffix(".jsp");
		return r;
	}
}
