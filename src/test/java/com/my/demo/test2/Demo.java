package com.my.demo.test2;

public class Demo {  
	  
	static int tempValue = 100;
	
    public void method1(int n) {			// Add
    	tempValue = tempValue + n;
        System.out.println("method1: tempValue =" + tempValue);  
    }  
  
    public void method2(int n) {  			// Sub
    	tempValue = tempValue - n;
    	System.out.println("method2: tempValue =" + tempValue);  
    }  
  
    public void method3(int n) {			// Divid
    	tempValue = tempValue / n;
    	System.out.println("method3: tempValue =" + tempValue);  
    }  
    
    public void clear() { // 将结果清零
//    	tempValue = 100;
	}
  
}  