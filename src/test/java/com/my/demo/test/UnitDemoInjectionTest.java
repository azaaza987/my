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
//@ContextConfiguration(locations={"classpath:spring.xml", "classpath:spring-hibernate.xml"})
@ContextConfiguration(locations={"classpath:spring.xml"})
//@Transactional
public class UnitDemoInjectionTest {
	
	private static final Logger logger=Logger.getLogger(UnitDemoInjectionTest.class);
	
	@Autowired
	private IClaimDao claimDao;
	
	@Autowired
	private IClaimDao helloDao_;
	
	
	@Autowired
	private IClaimDao notexistDao;
	
	@Test
	public void testNull(){			// General Null Test
		String testStr = "US";
		assertNotNull(testStr);
	}
	
	@Test
	public void testInitDao(){		

		assertNotNull(claimDao);					// Test if the claimDao be initialied by spring container or not 
		
		Client temp = claimDao.getClientById(1);
		assertEquals(1000, temp.getClientId());		// Mock Test calling DataBase and check the value
	}

	@Test
	public void testHelloDao(){		
		assertNotNull(helloDao_);					// Test if the helloDao be initialied by spring container or not 
		
	}

	@Test
	public void testNotexistDao(){		
		assertNotNull(notexistDao);					// Test if the helloDao be initialied by spring container or not 
		
	}
	
	@Resource(name = "propertyBean")
    private ConfigProperty configProperty;
	
	@Test
    public void test() {							// Used to load the property value files from .property file
        System.out.println(configProperty.getDriverClassName());
        System.out.println(configProperty.getJdbc_url());
    }
	
	
	@Test
	public void closeAll() throws SQLException  {
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
