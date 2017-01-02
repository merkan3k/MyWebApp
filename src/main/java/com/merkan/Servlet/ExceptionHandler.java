package com.merkan.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by vova on 02.01.2017.
 */
@WebServlet("/AppExceptionHandler")
public class ExceptionHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        processError(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        processError(httpServletRequest, httpServletResponse);
    }

    private void processError(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Exception/Error Details</title></head><body>");

    }
}
