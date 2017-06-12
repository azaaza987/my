package com.my.demo.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring.xml", "classpath:spring-hibernate.xml"})
//@Transactional
@RunWith(JUnit4ClassRunner.class)
public class UnitDemoTest {
	private static final Logger logger=Logger.getLogger(UnitDemoTest.class);
	
	
	@Test
	public void testGreater(){
		boolean ret = 100>80?true:false;
		assertTrue(ret);
	}
	
	
	@Test
	public void testNull(){
		String testStr = "US";
		assertNotNull(testStr);
	}
	
}
