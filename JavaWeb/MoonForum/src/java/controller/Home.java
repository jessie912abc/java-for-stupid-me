/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StatusDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Status;
import model.User;

/**
 *
 * @author Jessie
 */
public class Home extends BaseAuthen {

    protected void homeDisplay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = getUser();
        ArrayList<Status> status = new StatusDAO().getHomeStatusByUserid(u);
        request.setAttribute("user", u);
        request.setAttribute("status", status);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
    
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        homeDisplay(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        createStatus(content);
        homeDisplay(request, response);
    }

    
}
