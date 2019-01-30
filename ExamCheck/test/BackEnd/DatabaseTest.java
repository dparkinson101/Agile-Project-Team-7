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
     * Test of number_examslinkedtopk method, of class Database.
     */
    @Test
    public void testNumber_examslinkedtopk() {
        System.out.println("number_examslinkedtopk");
        String pk = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.number_examslinkedtopk(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of info_examslinkedtopk method, of class Database.
     */
    @Test
    public void testInfo_examslinkedtopk() {
        System.out.println("info_examslinkedtopk");
        String pk = "";
        Database instance = new Database();
        ResultSet expResult = null;
        ResultSet result = instance.info_examslinkedtopk(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of number_examslinkedtopkintmod method, of class Database.
     */
    @Test
    public void testNumber_examslinkedtopkintmod() {
        System.out.println("number_examslinkedtopkintmod");
        String pk = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.number_examslinkedtopkintmod(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of info_examslinkedtopkintmod method, of class Database.
     */
    @Test
    public void testInfo_examslinkedtopkintmod() {
        System.out.println("info_examslinkedtopkintmod");
        String pk = "";
        Database instance = new Database();
        ResultSet expResult = null;
        ResultSet result = instance.info_examslinkedtopkintmod(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of number_examslinkedtopkextmod method, of class Database.
     */
    @Test
    public void testNumber_examslinkedtopkextmod() {
        System.out.println("number_examslinkedtopkextmod");
        String pk = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.number_examslinkedtopkextmod(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of info_examslinkedtopkextmod method, of class Database.
     */
    @Test
    public void testInfo_examslinkedtopkextmod() {
        System.out.println("info_examslinkedtopkextmod");
        String pk = "";
        Database instance = new Database();
        ResultSet expResult = null;
        ResultSet result = instance.info_examslinkedtopkextmod(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of number_examslinkedtopkvetcommit method, of class Database.
     */
    @Test
    public void testNumber_examslinkedtopkvetcommit() {
        System.out.println("number_examslinkedtopkvetcommit");
        String pk = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.number_examslinkedtopkvetcommit(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of info_examslinkedtopkvetcommit method, of class Database.
     */
    @Test
    public void testInfo_examslinkedtopkvetcommit() {
        System.out.println("info_examslinkedtopkvetcommit");
        String pk = "";
        Database instance = new Database();
        ResultSet expResult = null;
        ResultSet result = instance.info_examslinkedtopkvetcommit(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of number_of_new_examsextmod method, of class Database.
     */
    @Test
    public void testNumber_of_new_examsextmod() {
        System.out.println("number_of_new_examsextmod");
        String pk = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.number_of_new_examsextmod(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addcomment method, of class Database.
     */
    @Test
    public void testAddcomment() {
        System.out.println("addcomment");
        String comments = "";
        String pk = "";
        String date = "";
        Database instance = new Database();
        instance.addcomment(comments, pk, date, 1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of blobin method, of class Database.
     */
    @Test
    public void testBlobin() {
        System.out.println("blobin");
        InputStream inputStream = null;
        String Modulecode = "";
        String level = "";
        String pk = "";
        String title = "";
        String online = "";
        String resit = "";
        String exam_setter_lect_pk = "";
        String examPK = "";
        String docType = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.blobin(inputStream, Modulecode, level, pk, title, online, resit, exam_setter_lect_pk, examPK, docType);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class Database.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        Database instance = new Database();
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of movetoexamvettingcommite method, of class Database.
     */
    @Test
    public void testMovetoexamvettingcommite() {
        System.out.println("movetoexamvettingcommite");
        String pk = "";
        Database instance = new Database();
        instance.movetoexamvettingcommite(pk);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of movetoexamvetexternalmodderator method, of class Database.
     */
    @Test
    public void testMovetoexamvetexternalmodderator() {
        System.out.println("movetoexamvetexternalmodderator");
        String pk = "";
        Database instance = new Database();
        instance.movetoexamvetexternalmodderator(pk);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finish_exam method, of class Database.
     */
    @Test
    public void testFinish_exam() {
        System.out.println("finish_exam");
        String pk = "";
        Database instance = new Database();
        instance.finish_exam(pk);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateblob method, of class Database.
     */
    @Test
    public void testUpdateblob() {
        System.out.println("updateblob");
        InputStream inputStream = null;
        String docType = "";
        String pk = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.updateblob(inputStream, docType, pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gettotalnumberofexams method, of class Database.
     */
    @Test
    public void testGettotalnumberofexams() {
        System.out.println("gettotalnumberofexams");
        Database instance = new Database();
        int expResult = 0;
        int result = instance.gettotalnumberofexams();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getallexams method, of class Database.
     */
    @Test
    public void testGetallexams() {
        System.out.println("getallexams");
        Database instance = new Database();
        ResultSet expResult = null;
        ResultSet result = instance.getallexams();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }



    
}