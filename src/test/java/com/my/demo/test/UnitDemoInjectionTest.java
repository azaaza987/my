package com.my.demo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.testClasses.configProperty.ConfigProperty;
import com.testClasses.springmvc.dao.impl.IClaimDao;
import com.testClasses.springmvc.entity.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
//@Transactional
public class UnitDemoInjectionTest {
	
	private static final Logger logger=Logger.getLogger(UnitDemoInjectionTest.class);
	
	
	@Resource(name = "propertyBean")
    private ConfigProperty configProperty;
	
	@Test
    public void test() {							// Used to load the property value files from .property file
        System.out.println(configProperty.getDriverClassName());
        System.out.println(configProperty.getJdbc_url());
    }
	
	
	@Test
	public void testDBConnection() throws SQLException  {
		String url = configProperty.getJdbc_url();
		String name = configProperty.getJdbc_username();
		String pwd = configProperty.getJdbc_password();
		String driverclass = configProperty.getDriverClassName();
		Connection conn = null;
		try {
			Class.forName(driverclass);
			conn = DriverManager.getConnection(url, name, pwd);
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(conn);	
		
	}
	
}
