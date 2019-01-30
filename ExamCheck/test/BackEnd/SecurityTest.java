/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dougl
 */
public class SecurityTest {
    
    public SecurityTest() {
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
     * Test of getNewSalt method, of class Security.
     */
    @Test
    public void testGetNewSalt() {
        System.out.println("getNewSalt");
        Security instance = new Security();
        byte[] expResult = null;
        byte[] result = instance.getNewSalt();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSaltedHash method, of class Security.
     */
    @Test
    public void testGetSaltedHash() throws Exception {
        System.out.println("getSaltedHash");
        String password = "";
        byte[] salt = null;
        Security instance = new Security();
        byte[] expResult = null;
        byte[] result = instance.getSaltedHash(password, salt);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
