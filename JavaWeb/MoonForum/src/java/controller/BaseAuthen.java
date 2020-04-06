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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Jessie
 */

public abstract class BaseAuthen extends HttpServlet {

    private User u = null;

    private boolean isAuthenticated(HttpServletRequest request){
        HttpSession session = request.getSession();
        u = (User) session.getAttribute("user");
        if(u != null ){//logged in
            
        }else{//not yet log in
            String username = null;
            String password = null;
            Cookie[] cookies = request.getCookies();
            if(cookies == null) { //no cookie to check
                return  false;
            }else{ //check the cookie
                for (Cookie cooky : cookies) {
                    if(cooky.getName().equals("usernameCookie")){
                        username = cooky.getValue();
                    } else if(cooky.getName().equals("passwordCookie")){
                        password = cooky.getValue();
                    }
                    if(username != null & password != null){
                        break;
                    }
                }
                if(username != null & password != null){//found username and password
                    User u = new UserDAO().authenticateUser(username, password);
                    if(u == null){ //username and password is not up to date
                        return false;
                    } else{ //correct authentication
                        return true;
                    }
                } else{ //not found username and password
                    return false;
                }
            }
        }
        return true;
    }

    public User getUser() {
        return u;
    }
    public void createStatus(String content){
        StatusDAO sdao = new StatusDAO();
        sdao.createNewStatus(content, u);
    }

    protected void renewUser(HttpServletRequest request, User newUser){
        HttpSession session = request.getSession();
        session.setAttribute("user", newUser);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(isAuthenticated(request)){
            processGet(request, response);
        }else{
            response.sendRedirect("login");
        }
    }

    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException ;
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(isAuthenticated(request)){
            processPost(request, response);
        } else{
            response.sendRedirect("login");
        }
    }

    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException ;
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
