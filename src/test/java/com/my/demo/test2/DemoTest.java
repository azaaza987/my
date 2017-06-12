package com.my.demo.test2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DemoTest {
	
	Demo demo = new Demo();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		demo.clear();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMethod1() {
		demo.method1(10);
		assertEquals(110, demo.tempValue);
	}

	@Test
	public void testMethod2() {
		demo.method2(1);
		assertEquals(99, demo.tempValue);
	}

	@Test
	public void testMethod3() {
		demo.method3(5);
		assertEquals(20, demo.tempValue);
	}

}
