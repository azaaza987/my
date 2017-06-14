package com.my.demo.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.my.web.entity.User;
import com.my.web.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:dispatcher-servlet.xml"})

public class UnitTestBeanInjection {
	
	private static final Logger logger=Logger.getLogger(UnitDemoInjectionTest.class);
	
	
	// if no bean config in XMl, then you better declare the resource class with  @Repository annotation 
    @Autowired
    private UserService userserviceBean0;  
    
    // if do not want to use AutoWire, then you can use Resource annotation to find instance default by name
    @Resource
    private UserService userserviceBean; 
    
    
//    @Autowired
//    private UserService uesrSerBean;  		// need to add bean ID config in the XML file for autowire injection
    
    
    @Test  
    public void test() {  
    	assertNotNull(userserviceBean);
    }  
    
    @Test  
    public void testAddUser() { 
    	assertNotNull(userserviceBean);
    	
    	User u = new User();
    	u.setName("JUnit");
    	userserviceBean.addUser(u);
    	System.out.println(userserviceBean.getUserList().size());
    	assertNotNull(userserviceBean.showUser("JUnit"));
    	System.out.println(userserviceBean.showUser("JUnit").getName());
    }  
    
    @Test  
    public void testShowUser() { 
    	User u = new User();
    	u = userserviceBean0.showUser("Tom");
    	assertNotNull(u);
    	System.out.println(u.getEmail());
    	
    }  
	
}
