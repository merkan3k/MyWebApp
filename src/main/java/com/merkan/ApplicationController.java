package com.merkan;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by volodymyr on 30.12.16.
 */

public class ApplicationController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        PrintWriter writer = httpServletResponse.getWriter();
        httpServletResponse.setContentType("text/html");

        String login = httpServletRequest.getParameter("login");
        String password = httpServletRequest.getParameter("pass");

        writer.println("login: " + login + ", Password: " + password);
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.getWriter().write("This is the answer");
    }
}
