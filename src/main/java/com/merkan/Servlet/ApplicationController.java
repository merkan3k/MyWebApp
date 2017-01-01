package com.merkan.Servlet;


import com.merkan.Model.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by volodymyr on 30.12.16.
 */

public class ApplicationController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        UsersService.addUser("admin", "admin");
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        PrintWriter writer = httpServletResponse.getWriter();
        httpServletResponse.setContentType("text/html");

        String login = httpServletRequest.getParameter("login");
        String password = httpServletRequest.getParameter("pass");

        if (!login.isEmpty() && !password.isEmpty() && UsersService.isLoginPresent(login)) {
            if(UsersService.isUserExist(login, password)) {
                getServletContext().getRequestDispatcher("/result.jsp").forward(httpServletRequest, httpServletResponse);
            } else {
                writer.println("User with such login is already registered.");
                getServletContext().getRequestDispatcher("/").include(httpServletRequest, httpServletResponse);
            }
        } else {
            writer.println("No such user in the system");
            getServletContext().getRequestDispatcher("/").include(httpServletRequest, httpServletResponse);
        }
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.getWriter().write("The request was wrong");
    }
}
