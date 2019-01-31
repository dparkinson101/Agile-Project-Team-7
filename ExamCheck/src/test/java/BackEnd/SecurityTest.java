/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.util.Arrays;
import java.util.Base64;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Douglas
 */
public class SecurityTest extends TestCase {
    
    Base64.Decoder dec = Base64.getDecoder();
    Base64.Encoder enc = Base64.getEncoder();
    
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
        byte[] result = instance.getNewSalt();
        assertNotNull(result);
    }

    /**
     * Test of getSaltedHash method, of class Security.
     * @throws java.lang.Exception
     */
    public void testGetSaltedHash() throws Exception {
        System.out.println("getSaltedHash");
        String password = "1234";
        byte[] salt = dec.decode("4TUX4Gesfs2CVAp8aWGwEg==");
        Security instance = new Security();
        byte[] expResult = dec.decode("yxufPl0mlXaEB3oBuX1wTw==");
        byte[] result = instance.getSaltedHash(password, salt);
        assertTrue(Arrays.equals(expResult, result));
    }

    /**
     * Test of convertObjectToEncodedBase64 method, of class Security.
     */
    public void testConvertObjectToEncodedBase64() {
        System.out.println("convertObjectToEncodedBase64");
        Permissions instance_2 = new Permissions();
        
        instance_2.admin = true;
        instance_2.login = true;
        
        String sessionVar = "sadjhasdkhasdkjas";
        Security instance = new Security();
        String expResult = "34xkbxsTc3cpCQIYIQUOTyMWEwkDGxIaCwUbG+rdvKbCxSVjZGIyYXYFDwUIHT5rYAQLEgw3DxwVFhYxaHEWHAoHNxYHIgsHBQgHEA4NO3N1DhIVFgEPBQYlDhcBGQkVHBYxanAaHRUBGAYAHykEDAQBBR8FEylzZAgFDwgdPmtuDhUCAgkEP3NnERkNEyMvH2hzPw4KHABcHwAKDUcyBxYCBgZIHBtrYXNzYWVqHGFz";
        String result = instance.convertObjectToEncodedBase64(instance_2, sessionVar);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertEncodedBase64ToObject method, of class Security.
     */
    public void testConvertEncodedBase64ToObject() {
        System.out.println("convertEncodedBase64ToObject");
        String base64 = "34xkbxsTc3cpCQIYIQUOTyMWEwkDGxIaCwUbG+rdvKbCxSVjZGIyYXYFDwUIHT5rYAQLEgw3DxwVFhYxaHEWHAoHNxYHIgsHBQgHEA4NO3N1DhIVFgEPBQYlDhcBGQkVHBYxanAaHRUBGAYAHykEDAQBBR8FEylzZAgFDwgdPmtuDhUCAgkEP3NnERkNEyMvH2hzPw4KHABcHwAKDUcyBxYCBgZIHBtrYXNzYWVqHGFz";
        String sessionVar = "sadjhasdkhasdkjas";
        Security instance = new Security();
        Permissions result = (Permissions) instance.convertEncodedBase64ToObject(base64, sessionVar);
        assertTrue(result.admin);
    }

    /**
     * Test of convertObjectToByteArray method, of class Security.
     */
    public void testConvertObjectToByteArray() {
        System.out.println("convertObjectToByteArray");
        Permissions instance_2 = new Permissions();
        
        instance_2.admin = true;
        instance_2.login = true;
        
        Security instance = new Security();
        byte[] expResult = dec.decode("rO0ABXNyABNCYWNrRW5kLlBlcm1pc3Npb25zepm518yjtlYCAAhaAAVhZG1pbloACmV4YW1TZXR0ZXJaABBleGFtVmV0Q29tbWl0dGVlWgARZXh0ZXJuYWxNb2RlcmF0b3JaABFpbnRlcm5hbE1vZGVyYXRvcloABWxvZ2luWgAGb2ZmaWNlTAAGdXNlclBLdAASTGphdmEvbGFuZy9TdHJpbmc7eHABAAAAAAEAdAAA");
        byte[] result = instance.convertObjectToByteArray(instance_2);
        assertTrue(Arrays.equals(expResult, result));
    }

    /**
     * Test of convertByteArrayToObject method, of class Security.
     */
    public void testConvertByteArrayToObject() {
        System.out.println("convertByteArrayToObject");
        byte[] bytes = dec.decode("rO0ABXNyABNCYWNrRW5kLlBlcm1pc3Npb25zepm518yjtlYCAAhaAAVhZG1pbloACmV4YW1TZXR0ZXJaABBleGFtVmV0Q29tbWl0dGVlWgARZXh0ZXJuYWxNb2RlcmF0b3JaABFpbnRlcm5hbE1vZGVyYXRvcloABWxvZ2luWgAGb2ZmaWNlTAAGdXNlclBLdAASTGphdmEvbGFuZy9TdHJpbmc7eHABAAAAAAEAdAAA");
        Security instance = new Security();
        Permissions result = (Permissions) instance.convertByteArrayToObject(bytes);
        assertTrue(result.admin);
    }

    /**
     * Test of xorByteArrays method, of class Security.
     */
    public void testXorByteArrays() {
        System.out.println("xorByteArrays");
        byte[] a = new byte[] {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0};
        byte[] b = new byte[] {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0};
        Security instance = new Security();
        byte[] expResult = new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] result = instance.xorByteArrays(a, b);
        assertTrue(Arrays.equals(expResult, result));
    }
}
