/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.InputStream;
import java.sql.Blob;
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
     * Test of updateQuery method, of class Database.
     */
    @Test
     public void  test_number_examslinkedtopkextmod(){
      System.out.println("testing number of exams linked to external modderator");
        Database instance = new Database();
        instance.connect();
         
      String result = instance.number_examslinkedtopkextmod("1");
         
         
         
         assertTrue(!result.equals("0"));
     }
    
    
    
    
    
    
    
    
    /**
     * Test of checkLogin method, of class Database.
     */
    @Test
    public void testCheckLogin() {
        System.out.println("checkLogin");
        String username = "admin";
        String password = "1234";
        Database instance = new Database();
        String expResult = "";
        String result = instance.checkLogin(username, password);
assertTrue(result!=null);


    }

    /**
     * Test of getexamsetter method, of class Database.
     */
    @Test
    public void testGetexamsetter() {
       System.out.println("testing get exam setter");
        Database instance = new Database();
        instance.connect();
         
      String result = instance.getexamsetter("1");
         
         
         
         assertTrue(!result.equals("0"));
    }
}