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
public class MainTest {
    
    public Main main;
    
    public MainTest() {
    }
    
    @Before
    public void setUp() {
        main = new Main();
    }
    
    @After
    public void tearDown() {
        main = null;
    }

    @Test
    public void testLogin() {
        boolean test = main.loginHandle("admin", "1234");
        assertTrue(test);
        if(test == false){
            fail("The loginHandle() method is not letting the user login with correct details");
        }
    }
    
}
