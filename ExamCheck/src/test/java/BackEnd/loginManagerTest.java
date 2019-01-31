/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.mockito.ArgumentCaptor;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 *
 * @author Douglas
 */
public class loginManagerTest extends TestCase {

    public loginManagerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(loginManagerTest.class);
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
     * Test of processRequest method, of class loginManager.
     *
     * @throws java.lang.Exception
     */
    public void testProcessRequest() throws Exception {
        System.out.println("processRequest");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        given(request.getParameter("username")).willReturn("admin");
        given(request.getParameter("password")).willReturn("1234");
        given(request.getSession()).willReturn(mock(HttpSession.class));
        given(request.getSession().getId()).willReturn("sadjhasdkhasdkjas");

        loginManager instance = new loginManager();
        instance.processRequest(request, response);

        final ArgumentCaptor<Cookie> captor = ArgumentCaptor.forClass(Cookie.class);

        verify(response).addCookie(captor.capture());

        final List<Cookie> cookies = captor.getValue();

        for (Cookie c : cookies) {
            if (c.getName().equals("secretClass")) {
                assertNotNull(c.getValue());
            }
        }
    }

    /**
     * Test of doGet method, of class loginManager.
     */
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        given(request.getParameter("username")).willReturn("admin");
        given(request.getParameter("password")).willReturn("1234");
        given(request.getSession().getId()).willReturn("sadjhasdkhasdkjas");

        loginManager instance = new loginManager();
        instance.doGet(request, response);
        final ArgumentCaptor<Cookie> captor = ArgumentCaptor.forClass(Cookie.class);

        verify(response).addCookie(captor.capture());

        final Cookie cookie = captor.getValue();

        assertNotNull(cookie.getValue());
    }

    /**
     * Test of doPost method, of class loginManager.
     */
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        given(request.getParameter("username")).willReturn("admin");
        given(request.getParameter("password")).willReturn("1234");
        given(request.getSession().getId()).willReturn("sadjhasdkhasdkjas");

        loginManager instance = new loginManager();
        instance.doPost(request, response);
        final ArgumentCaptor<Cookie> captor = ArgumentCaptor.forClass(Cookie.class);

        verify(response).addCookie(captor.capture());

        final List<Cookie> cookies = (List<Cookie>) captor.getValue();

        for (Cookie c : cookies) {
            if (c.getName().equals("secretClass")) {
                assertNotNull(c.getValue());
            }
        }
    }

    /**
     * Test of getServletInfo method, of class loginManager.
     */
    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        loginManager instance = new loginManager();
        String expResult = "Used to verify login and distribute cookies.";
        String result = instance.getServletInfo();
        assertEquals(expResult, result);
    }

}
