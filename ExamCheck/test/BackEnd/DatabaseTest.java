/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

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
        System.out.println("connect");
        Database instance = new Database();
        Connection result = instance.connect();
        assertNotNull(result);
    }

    /**
     * Test of statement method, of class Database.
     */
    @Test
    public void testStatement() {
        System.out.println("statement");
        String query = "SELECT * FROM entity_1;";
        Database instance = new Database();
        instance.connect();
        ResultSet result = instance.statement(query);
        assertNotNull(result);
    }
    
}
