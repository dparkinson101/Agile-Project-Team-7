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
 * @author Douglas
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

    /**
     * Test of convertObjectToEncodedBase64 method, of class Security.
     */
    public void testConvertObjectToEncodedBase64() {
        System.out.println("convertObjectToEncodedBase64");
        Object instance_2 = null;
        String sessionVar = "";
        Security instance = new Security();
        String expResult = "";
        String result = instance.convertObjectToEncodedBase64(instance_2, sessionVar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertEncodedBase64ToObject method, of class Security.
     */
    public void testConvertEncodedBase64ToObject() {
        System.out.println("convertEncodedBase64ToObject");
        String base64 = "";
        String sessionVar = "";
        Security instance = new Security();
        Object expResult = null;
        Object result = instance.convertEncodedBase64ToObject(base64, sessionVar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertObjectToByteArray method, of class Security.
     */
    public void testConvertObjectToByteArray() {
        System.out.println("convertObjectToByteArray");
        Object instance_2 = null;
        Security instance = new Security();
        byte[] expResult = null;
        byte[] result = instance.convertObjectToByteArray(instance_2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertByteArrayToObject method, of class Security.
     */
    public void testConvertByteArrayToObject() {
        System.out.println("convertByteArrayToObject");
        byte[] bytes = null;
        Security instance = new Security();
        Object expResult = null;
        Object result = instance.convertByteArrayToObject(bytes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of xorByteArrays method, of class Security.
     */
    public void testXorByteArrays() {
        System.out.println("xorByteArrays");
        byte[] a = null;
        byte[] b = null;
        Security instance = new Security();
        byte[] expResult = null;
        byte[] result = instance.xorByteArrays(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
