/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOCustomer;
import model.DBConnect;

/**
 *
 * @author Viet
 */
@WebServlet(name = "ControllerSignUp", urlPatterns = {"/ControllerSignUp"})
public class ControllerSignUp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            DBConnect dbconn = new DBConnect();
            DAOCustomer dao = new DAOCustomer(dbconn);
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            if (!dao.dupUser(user)) {
                request.setAttribute("messUser", "This username already exist");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            if (!dao.dupEmail(email)) {
                request.setAttribute("messEmail", "This email is registed");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            if (pass.length() < 8) {
                request.setAttribute("messPass", "Password must longer than 8 characters");
            }
            if (dao.dupEmail(email) && dao.dupUser(user) && pass.length() >= 8) {
                Customer cus = new Customer(email, name, user, pass);
                dao.addCustomer(cus);
                String usern = request.getParameter("user");
                String passn = request.getParameter("pass");
                dao.login(user, pass);
                HttpSession session = request.getSession();
                Customer cus1 = dao.takeInfo(cus.getCid());
                session.setAttribute("cus", cus);

                response.sendRedirect("HomeControll");
                
            }
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
