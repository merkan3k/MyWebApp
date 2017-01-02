//
//import com.merkan.Servlet.ApplicationController;
//import org.apache.commons.io.FileUtils;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import static org.junit.Assert.assertTrue;
//
///**
// * Created by vova on 02.01.2017.
// */
//public class ServletTest extends Mockito {
//
//    @Test
//    public void servletTest() {
//        HttpServletResponse response = mock(HttpServletResponse.class);
//        HttpServletRequest request = mock(HttpServletRequest.class);
//
//        when(request.getParameter("login")).thenReturn("admin");
//        when(request.getParameter("pass")).thenReturn("12345");
//
//        try(PrintWriter writer = new PrintWriter("testfile.txt")) {
//
//            when(response.getWriter()).thenReturn(writer);
//
//            new ApplicationController().doPost(request, response);
//
//            verify(request, atLeast(1)).getParameter("admin");
//            writer.flush();
//            assertTrue(FileUtils.readFileToString(new File("testfile.txt"), "UTF-8").
//                    contains("User with such login is already registered."));
//
//        } catch (IOException ex) {
//            System.err.println("Exception during the session");
//        } catch (ServletException ex) {
//            System.err.println("Servlet exception");
//        }
//
//    }
//
//}
