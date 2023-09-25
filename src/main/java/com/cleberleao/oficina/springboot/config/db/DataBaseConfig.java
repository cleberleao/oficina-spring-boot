package com.cleberleao.oficina.springboot.config.db;


import com.cleberleao.oficina.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
/**
 * @author CleberLeão
 */
@Configuration
@EnableJpaRepositories(basePackageClasses = { UserRepository.class }, entityManagerFactoryRef = "userEntityManager")
public class DataBaseConfig {

	@Value("${db.datasource.jdbcurl}")
	private String jdbcurlLocal;
	
    @Value("${db.datasource.username}")
    private String usernameLocal;

    @Value("${db.datasource.password}")
    private String passwordLocal;
	
	@Bean
	@Primary
	public DataSource dataSource(){
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    dataSource.setUrl(jdbcurlLocal);
	    dataSource.setUsername(usernameLocal);
	    dataSource.setPassword( passwordLocal);
	    return dataSource;
	}
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean userEntityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("com.cleberleao.oficina.springboot.model")
				.build();
	}

}
