package com.my.demo.test3;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;



//@RunWith(JUnit4ClassRunner.class)
public class CalculatorTest {
	private static Calculator calculator = new Calculator();

	@Before
	public void setUp() throws Exception {
		calculator.clear();
	}

	@Test
	public void testAdd() {
		calculator.add(2);
		calculator.add(3);
		assertEquals(5, calculator.getResult());
		System.out.println(calculator.getResult());
	}

	@Test
	public void testSubstract() {
		calculator.add(10);
		calculator.substract(2);
		assertEquals(9, calculator.getResult());
	}

	@Ignore("Multiply() Not yet implemented")
	@Test
	public void testMultiply() {
		calculator.add(9);
		calculator.multiply(calculator.getResult());
		assertEquals(900, calculator.getResult());
	}

	@Test
	public void testDivide() {
		calculator.add(8);
		calculator.divide(2);
		assertEquals(4, calculator.getResult());
	}
	
	@Test
	public void testsquare() {
		calculator.square(5);
		assertEquals(25, calculator.getResult());
	}
	
	@Test(timeout = 5000)
	public void testsquareRoot(){
//		calculator.squareRoot(4);
//		assertEquals(2, calculator.getResult());
	}
	
	@Test(expected = ArithmeticException.class)
	public void divideByZero(){
		calculator.divide(0);
		System.out.println("Test auto check change and auto build !    ");
	}
}
