/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Jessie
 */
public class BlockList extends BaseAuthen {

    public void displayBlockList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = getUser();
        UserDAO udao = new UserDAO();
        ArrayList<User> blocklist = udao.getBlockedUserByUserid(u.getId());
        request.setAttribute("block", blocklist);
        request.getRequestDispatcher("blocklist.jsp").forward(request, response);
    }
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        displayBlockList(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        displayBlockList(request, response);
    }

    

}
