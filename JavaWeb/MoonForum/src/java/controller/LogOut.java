/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jessie
 */
public class LogOut extends BaseAuthen {

    protected void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("user", null);
        Cookie usernameCookie = new Cookie("usernameCookie", "");
        Cookie passwordCookie = new Cookie("passwordCookie", "");
        usernameCookie.setMaxAge(-1); //delete cookie
        passwordCookie.setMaxAge(-1); //delete cookie
        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);
        response.sendRedirect("/forum");
    }
    
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logOut(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logOut(request, response);
    }

    
}
