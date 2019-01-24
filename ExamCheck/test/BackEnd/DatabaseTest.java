/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
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
public class DatabaseTest {
    
    public DatabaseTest() {
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
     * Test of connect method, of class Database.
     */
    @Test
    public void testConnect() {
        System.out.println("testConnect");
        Database instance = new Database();
        Connection result = instance.connect();
        assertNotNull(result);
    }

    /**
     * Test of executeQuery method, of class Database.
     */
    @Test
    public void testExecuteQuery() {
        System.out.println("testExecuteQuery");
        String query = "SELECT * FROM entity_1;";
        Database instance = new Database();
        instance.connect();
        ResultSet result = instance.executeQuery(query);
        assertNotNull(result);
    }
    
    /**
     * Test of updateQuery method, of class Database.
     */
    @Test
    public void testUpdateQuery() {
        System.out.println("updateQuery");
        String query = "INSERT INTO testuser (username, password, firstName, lastName) VALUES ('test@dundee.ac.uk', '1234', 'John', 'Smith');";
        Database instance = new Database();
        instance.connect();
        boolean result = instance.updateQuery(query);
        assertTrue(result);
    }

    /**
     * Test of blob method, of class Database.
     */
     public void testBlobuploadanddownload() {
      
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
    }
    
    
     
    
    
    @Test
    public void testBlobin() {
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    /**
     * Test of downloadblob method, of class Database.
     */
    @Test
    public void testblobout() {
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    /**
     * Test of test method, of class Database.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Database instance = new Database();
        String expResult = "";
        String result = instance.test();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkLogin method, of class Database.
     */
    @Test
    public void testCheckLogin() {
        System.out.println("checkLogin");
        String username = "";
        String password = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.checkLogin(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getexamsetter method, of class Database.
     */
    @Test
    public void testGetexamsetter() {
        System.out.println("getexamsetter");
        String pk = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.getexamsetter(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getinternalmod method, of class Database.
     */
    @Test
    public void testGetinternalmod() {
        System.out.println("getinternalmod");
        String pk = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.getinternalmod(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getexamvetcommit method, of class Database.
     */
    @Test
    public void testGetexamvetcommit() {
        System.out.println("getexamvetcommit");
        String pk = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.getexamvetcommit(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getexternal method, of class Database.
     */
    @Test
    public void testGetexternal() {
        System.out.println("getexternal");
        String pk = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.getexternal(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getoffice method, of class Database.
     */
    @Test
    public void testGetoffice() {
        System.out.println("getoffice");
        String pk = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.getoffice(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of number_of_completed_exams method, of class Database.
     */
    @Test
    public void testNumber_of_completed_exams() {
        System.out.println("number_of_completed_exams");
        String pk = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.number_of_completed_exams(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of number_of_in_progress_exams method, of class Database.
     */
    @Test
    public void testNumber_of_in_progress_exams() {
        System.out.println("number_of_in_progress_exams");
        String pk = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.number_of_in_progress_exams(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of number_of_new_exams method, of class Database.
     */
    @Test
    public void testNumber_of_new_exams() {
        System.out.println("number_of_new_exams");
        String pk = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.number_of_new_exams(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeStage method, of class Database.
     */
    @Test
    public void testChangeStage() {
        System.out.println("changeStage");
        String pk = "";
        Database instance = new Database();
        boolean expResult = false;
        boolean result = instance.changeStage(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of blobout method, of class Database.
     */
    @Test
    public void testBlobout() {
        System.out.println("blobout");
        String exampk = "";
        String path = "";
        String name = "";
        Database instance = new Database();
        File expResult = null;
        File result = instance.blobout(exampk, path, name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
