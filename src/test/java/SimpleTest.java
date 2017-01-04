import net.sourceforge.jwebunit.exception.TestingEngineResponseException;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by volodymyr on 03.01.17.
 */
public class SimpleTest {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = new WebTester();
        tester.setBaseUrl("http://localhost:8080/home");
    }

    @Test
    public void successTest() {
        tester.beginAt("index.jsp"); //Open the browser on http://localhost:8080/test/home.xhtml

        tester.setTextField("login", "admin");
        tester.setTextField("pass", "admin");
        tester.submit();
        tester.assertTitleEquals("Congratulation! You were successfully logged!");
    }

    @Test
    public void testInvalidGotoPage() {
        tester.beginAt("12.html");
        TestingEngineResponseException e = assertException(TestingEngineResponseException.class, "error page", new Object[]{"/error.jsp"});
        assertEquals(404, e.getHttpStatusCode());
    }
}
