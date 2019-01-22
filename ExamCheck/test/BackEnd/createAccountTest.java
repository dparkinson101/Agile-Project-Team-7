/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Douglas
 */
public class createAccountTest {
    
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
     * Test of processRequest method, of class createAccount.
     */
    @Test
    public void testProcessRequest() throws Exception {
        System.out.println("processRequest");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        createAccount instance = new createAccount();
        instance.processRequest(request, response);
    }

    /**
     * Test of doGet method, of class createAccount.
     */
    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        createAccount instance = new createAccount();
        instance.doGet(request, response);
    }

    /**
     * Test of doPost method, of class createAccount.
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        createAccount instance = new createAccount();
        instance.doPost(request, response);
    }

    /**
     * Test of getServletInfo method, of class createAccount.
     */
    @Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        createAccount instance = new createAccount();
        String expResult = "";
        String result = instance.getServletInfo();
        assertEquals(expResult, result);
    }
    
}
