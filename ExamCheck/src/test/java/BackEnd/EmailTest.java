/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import javax.mail.internet.MimeMessage;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Douglas
 */
public class EmailTest extends TestCase {
    
    public EmailTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(EmailTest.class);
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
     * Test of getService method, of class Email.
     */
    public void testGetService() throws Exception {
        System.out.println("getService");
        Email instance = new Email();
        Gmail expResult = null;
        Gmail result = instance.getService();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendEmail method, of class Email.
     */
    public void testSendEmail() {
        System.out.println("sendEmail");
        String to = "";
        String from = "";
        String subject = "";
        String body = "";
        Email instance = new Email();
        boolean expResult = true;
        boolean result = instance.sendEmail(to, from, subject, body);
        assertEquals(expResult, result);
    }

    /**
     * Test of createEmail method, of class Email.
     */
    public void testCreateEmail() throws Exception {
        System.out.println("createEmail");
        String to = "";
        String from = "";
        String subject = "";
        String bodyText = "";
        Email instance = new Email();
        MimeMessage expResult = null;
        MimeMessage result = instance.createEmail(to, from, subject, bodyText);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageWithEmail method, of class Email.
     */
    public void testCreateMessageWithEmail() throws Exception {
        System.out.println("createMessageWithEmail");
        MimeMessage emailContent = null;
        Email instance = new Email();
        Message expResult = null;
        Message result = instance.createMessageWithEmail(emailContent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMessage method, of class Email.
     */
    public void testSendMessage() throws Exception {
        System.out.println("sendMessage");
        Gmail service = null;
        String userId = "";
        MimeMessage emailContent = null;
        Email instance = new Email();
        Message expResult = null;
        Message result = instance.sendMessage(service, userId, emailContent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
