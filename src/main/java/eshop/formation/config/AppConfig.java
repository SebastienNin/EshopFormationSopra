package eshop.formation.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import jakarta.persistence.EntityManagerFactory;

public class AppConfig {

		@Autowired
		private Environment env;
		
		
		@Bean
		public BasicDataSource dataSource() {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(env.getProperty("sql.driver"));
			dataSource.setUrl(env.getProperty("sql.url"));
			dataSource.setUsername(env.getProperty("sql.login"));
			dataSource.setPassword(env.getProperty("sql.password"));
			dataSource.setMaxTotal(Integer.parseInt(env.getProperty("sql.total")));
			return dataSource;
		}

		@Bean
		public LocalContainerEntityManagerFactoryBean entityManagerFactory(BasicDataSource dataSource) {
			LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
			JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
			emf.setDataSource(dataSource);
			emf.setPackagesToScan("quest.model");
			emf.setJpaVendorAdapter(vendorAdapter);
			emf.setJpaProperties(this.hibernateProperties());
			return emf;
		}

		private Properties hibernateProperties() {
			Properties properties = new Properties();
			properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.mode"));
			properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
			properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.showsql"));
			properties.setProperty("hibernate.format_sql", "false");
			return properties;
		}

		@Bean
		public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
			JpaTransactionManager transactionManager = new JpaTransactionManager();
			transactionManager.setEntityManagerFactory(emf);
			return transactionManager;
		}

		@Bean
		public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
			return new PersistenceExceptionTranslationPostProcessor();
		}

	}


