/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Jessie
 */
public class Setting extends BaseAuthen{

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", getUser());
        request.getRequestDispatcher("setting.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String displayName = request.getParameter("displayName");
            Date dob = Date.valueOf(request.getParameter("dob"));
            boolean gender = (Integer.parseInt(request.getParameter("gender")) == 1) ? true : false;
            String bio = request.getParameter("bio");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            UserDAO uDAO = new UserDAO();
            System.out.println(getUser().getId());
            User newUser = new User(username, password, getUser().getId(), displayName, dob, gender, bio);
            uDAO.updateUser(newUser);
            renewUser(request, newUser);
            response.sendRedirect("setting");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
}
