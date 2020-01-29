package com.distribuida.conf;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class DbProducer {

	@Inject
	@ConfigProperty(name = "conf/driverClass")
	private String driverClass;
	
	@Inject
	@ConfigProperty(name = "conf/url")
	private String url;
	
	@Inject
	@ConfigProperty(name = "conf/user")
	private String user;
	
	@Inject
	@ConfigProperty(name = "conf/pass")
	private String pass;	

	@ApplicationScoped
	@Produces
	public DataSource dataSource() {

		BasicDataSource ds = new BasicDataSource();

		ds.setDriverClassName(driverClass);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(pass);

		return ds;
	}

}
