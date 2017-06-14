package com.my.demo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.testClasses.springmvc.dao.impl.IClaimDao;
import com.testClasses.springmvc.entity.Client;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class UnitDemo2Test {
	
	
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
	
//	@Before  
//	 public void init() {  
//	      ApplicationContext ctx = new FileSystemXmlApplicationContext( "classpath:dispatcher-servlet.xml");  
//	      UserService baseDao = (UserService) ctx.getBean("uesrSerBean");  
//	      assertNotNull(baseDao);  
//	 }  
	
}
