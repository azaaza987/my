package com.my.demo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.assertEquals;

import com.my.web.controller.MyController;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:dispatcher-servlet.xml"})

@WebAppConfiguration
public class  MockMyController {

    private MockHttpServletRequest request;  
    private MockHttpServletResponse response;   
      
    @Autowired  
    private MyController loginController ;  
      
    @Before    
    public void setUp(){    
        request = new MockHttpServletRequest();      
        request.setCharacterEncoding("UTF-8");      
        response = new MockHttpServletResponse();      
    }         

    @Test  
    public void testLogin() {   
        try {  
        	request.setParameter("userName", "admin");
        	request.setParameter("password", "2");
            assertEquals("sucess", loginController.hello("Admin", "Admin")) ;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}