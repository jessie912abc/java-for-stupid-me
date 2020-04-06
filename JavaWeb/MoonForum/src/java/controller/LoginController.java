/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
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
public class LoginController extends HttpServlet {

    

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
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UserDAO udao = new UserDAO();
        User user = udao.authenticateUser(username, password);
        if (user == null) {
            String msg = "Username or password is invalid! Re-enter!";
            request.setAttribute("msg", msg);
            request.setAttribute("username", username);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            //add cookie
            Cookie usernameCookie = new Cookie("usernameCookie", username);
            Cookie passwordCookie = new Cookie("passwordCookie", password);
            usernameCookie.setMaxAge(3600 * 24);
            passwordCookie.setMaxAge(3600 * 24);
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
            //add session attribute
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            response.sendRedirect("home");
        }
    }

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
