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
        Gmail result = instance.getService();
        assertNotNull(result);
    }

    /**
     * Test of sendEmail method, of class Email.
     */
    public void testSendEmail() {
        System.out.println("sendEmail");
        String to = "dundeeuniversityexamtool@gmail.com";
        String from = "dundeeuniversityexamtool@gmail.com";
        String subject = "Test";
        String body = "This is a testing email";
        Email instance = new Email();
        boolean expResult = true;
        boolean result = instance.sendEmail(to, from, subject, body);
        assertEquals(expResult, result);
    }

    /**
     * Test of createMessageWithEmail method, of class Email.
     */
    public void testCreateMessageWithEmail() throws Exception {
        System.out.println("createMessageWithEmail");
        Email instance = new Email();
        MimeMessage emailContent = instance.createEmail("dundeeuniversityexamtool@gmail.com", "dundeeuniversityexamtool@gmail.com", "testing", "this is a testing");
        Message result = instance.createMessageWithEmail(emailContent);
        assertNotNull(result);
    }

    /**
     * Test of sendMessage method, of class Email.
     */
    public void testSendMessage() throws Exception {
        System.out.println("sendMessage");
        String userId = "me";
        Email instance = new Email();
        MimeMessage emailContent = instance.createEmail("dundeeuniversityexamtool@gmail.com", "dundeeuniversityexamtool@gmail.com", "testing", "this is a testing");
        Gmail service = instance.getService();
        Message result = instance.sendMessage(service, userId, emailContent);
        assertNotNull(result);
    }
}
