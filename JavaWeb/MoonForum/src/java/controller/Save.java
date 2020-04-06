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
public class Save extends BaseAuthen {

    protected void saveDisplay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = getUser();
        ArrayList<Status> status = new StatusDAO().getSavedStatus(u);
        request.setAttribute("status", status);
        request.getRequestDispatcher("save.jsp").forward(request, response);
    }
    
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        saveDisplay(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int statusid = Integer.parseInt(request.getParameter("statusid"));
        int userid = getUser().getId();
        StatusDAO sdao = new StatusDAO();
        ArrayList<Status> list = sdao.getSavedStatus(getUser());
        boolean saved = false;
        for (Status status : list) {
            if(status.getId() == statusid){
                saved = true;
                break;
            }
        }
        if(saved){
            new StatusDAO().unsaveStatus(statusid, userid);
        } else {
            new StatusDAO().saveStatus(statusid, userid);
        }
        response.sendRedirect("save");
    }

    
}
