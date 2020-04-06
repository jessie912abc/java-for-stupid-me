/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StatusDAO;
import dao.UserDAO;
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
public class Profile extends BaseAuthen {

    protected void profileDisplay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDAO udao = new UserDAO();
        User u = udao.getUserByUserid(id);
        ArrayList<Status> status = new StatusDAO().getUserStatus(u);
        ArrayList<User> follower = udao.getFollower(u);
        ArrayList<User> following = udao.getFollowing(u);
        boolean blocked = false;
        ArrayList<User> block = udao.getBlockedUserByUserid(getUser().getId()); //get session user's block list
        for (User ub : block) {
            if (ub.getId() == id) {
                blocked = true;
            }
        }
        if (!blocked) {
            request.setAttribute("user", u);
            request.setAttribute("status", status);
            request.setAttribute("follower", follower);
            request.setAttribute("following", following);
            request.setAttribute("block", block);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } else{
            response.getWriter().println("You blocked this user");
        }

        
    }

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        profileDisplay(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        profileDisplay(request, response);
        String content = request.getParameter("content");
        createStatus(content);
        profileDisplay(request, response);
    }

}
