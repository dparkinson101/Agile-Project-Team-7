/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author Douglas
 */
public class createAccountTest extends Mockito{
    
    public createAccountTest() {
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
     * Test of getServletInfo method, of class createAccount.
     */
    @Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        createAccount instance = new createAccount();
        String expResult = "Used to create a new user account.";
        String result = instance.getServletInfo();
        assertEquals(expResult, result);
    }

    /**
     * Test of processRequest method, of class createAccount.
     */
    @Test
    public void testProcessRequest() throws Exception {
        System.out.println("processRequest");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        
        when(request.getParameter("firstName")).thenReturn("Douglas");
        when(request.getParameter("lastName")).thenReturn("Parkinson");
        when(request.getParameter("email")).thenReturn("dparkinson@dundee.ac.uk");
        when(request.getParameter("password")).thenReturn("1234");
        
        createAccount instance = new createAccount();
        instance.processRequest(request, response);
        
        Database db = new Database();
        db.connect();
        
        ResultSet rs = db.executeQuery("select * from users where email = 'dparkinson@dundee.ac.uk'");
        assertTrue(rs.first());
        
    }

    /**
     * Test of doGet method, of class createAccount.
     */
    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        
        when(request.getParameter("firstName")).thenReturn("Douglas");
        when(request.getParameter("lastName")).thenReturn("Parkinson");
        when(request.getParameter("email")).thenReturn("dparkinson@dundee.ac.uk");
        when(request.getParameter("password")).thenReturn("1234");
        
        createAccount instance = new createAccount();
        instance.doGet(request, response);
    }

    /**
     * Test of doPost method, of class createAccount.
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        
        when(request.getParameter("firstName")).thenReturn("Douglas");
        when(request.getParameter("lastName")).thenReturn("Parkinson");
        when(request.getParameter("email")).thenReturn("dparkinson@dundee.ac.uk");
        when(request.getParameter("password")).thenReturn("1234");
        
        createAccount instance = new createAccount();
        instance.doPost(request, response);
    }
    
}
