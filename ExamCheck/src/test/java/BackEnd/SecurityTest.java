/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author dougl
 */
public class SecurityTest extends TestCase {
    
    public SecurityTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(SecurityTest.class);
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getNewSalt method, of class Security.
     */
    public void testGetNewSalt() {
        System.out.println("getNewSalt");
        Security instance = new Security();
        byte[] expResult = null;
        byte[] result = instance.getNewSalt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSaltedHash method, of class Security.
     */
    public void testGetSaltedHash() throws Exception {
        System.out.println("getSaltedHash");
        String password = "";
        byte[] salt = null;
        Security instance = new Security();
        byte[] expResult = null;
        byte[] result = instance.getSaltedHash(password, salt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
