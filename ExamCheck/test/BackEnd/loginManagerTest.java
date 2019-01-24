/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.jmock.integration.junit4.JUnit4Mockery;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Douglas
 */
public class loginManagerTest extends org.jmock.integration.junit4.JUnit4Mockery{
    
    public loginManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of processRequest method, of class loginManager.
     */
    @Test
    public void testProcessRequest() throws Exception {
        System.out.println("loginManager processRequest");
        
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("1234");
        
        loginManager instance = new loginManager();
        
        instance.processRequest(request, response);

        Cookie[] cookies = request.getCookies();
        
        String value = cookies[0].getValue();
        assertEquals(value, "true");
        
    }

    /**
     * Test of doGet method, of class loginManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testDoGet() throws Exception {
        System.out.println("loginManager doGet");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("1234");
        
        loginManager instance = new loginManager();
        
        instance.doGet(request, response);

        Cookie[] cookies = request.getCookies();
        
        String value = cookies[0].getValue();
        assertEquals(value, "true");
    }

    /**
     * Test of doPost method, of class loginManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println("loginManager doPost");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("1234");
        
        loginManager instance = new loginManager();
        
        instance.doPost(request, response);

        Cookie[] cookies = request.getCookies();
        
        String value = cookies[0].getValue();
        assertEquals(value, "true");
    }

    /**
     * Test of getServletInfo method, of class loginManager.
     */
    @Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        loginManager instance = new loginManager();
        String expResult = "Lets a user login and returns cookie credentials for them.";
        String result = instance.getServletInfo();
        assertEquals(expResult, result);
    }
    
}
