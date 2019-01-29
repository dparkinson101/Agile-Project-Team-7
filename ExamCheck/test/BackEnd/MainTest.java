/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.sql.Connection;
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
public class MainTest {
    
    public MainTest() {
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
     * Test of loginHandle method, of class Main.
     */
    @Test
    public void testLoginHandle() {
        System.out.println("loginHandle");
        String username = "admin";
        String password = "1234";
        Main instance = new Main();
        boolean expResult = true;
        boolean result = instance.loginHandle(username, password);
        assertEquals(expResult, result);
        
        //fail("The site cannot login with correct details.");
    }
}
