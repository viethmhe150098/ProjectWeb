/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Bill;
import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOBill;
import model.DAOCustomer;
import model.DBConnect;
import org.jboss.weld.servlet.SessionHolder;

/**
 *
 * @author Viet
 */
@WebServlet(name = "ControllerCustomer", urlPatterns = {"/ControllerCustomer"})
public class ControllerCustomer extends HttpServlet {

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
            String service = request.getParameter("service");
            DBConnect dbconn = new DBConnect();
            DAOCustomer dao = new DAOCustomer(dbconn);
            DAOBill daoBill = new DAOBill(dbconn);
            if (service.equals("account")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Customer cus = dao.takeInfo(id);
                request.setAttribute("cus", cus);
                ArrayList<Bill> listBill = daoBill.getByCus(cus.getCid());
                request.setAttribute("listBill", listBill);
                request.getRequestDispatcher("Account.jsp").forward(request, response);
            }
            if (service.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                ResultSet rs = dbconn.getData("Select * from Customer where cid=" + id);
                while (rs.next()) {
                    Customer cus = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                    request.setAttribute("cus", cus);
                    request.getRequestDispatcher("update.jsp").forward(request, response);
                }
            }
            if (service.equals("updated")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String cname = request.getParameter("name");
                String username = request.getParameter("user");
                Customer cus = new Customer(id, cname, username);
                dao.updateCustomer(cus);

                response.sendRedirect("ControllerLogOut");
            }
            if (service.equals("displayAll")) {
                ArrayList<Customer> list = dao.getAllCustomer();
                request.setAttribute("listCus", list);
                request.getRequestDispatcher("Customer.jsp").forward(request, response);
            }
            if (service.equals("changePass")) {

                String user = request.getParameter("user");
                request.setAttribute("user", user);
                request.getRequestDispatcher("changePass.jsp").forward(request, response);

            }
            if (service.equals("changedPass")) {
                String user = request.getParameter("user");
                String opass = request.getParameter("opass");
                String npass = request.getParameter("npass");
                String cpass = request.getParameter("cpass");
                if (dao.login(user, opass) != null) {
                    if (npass.length() >= 8) {
                        if (npass.equals(cpass)) {
                            dao.changePass(user, npass, opass);
                            response.sendRedirect("ControllerLogOut");
                        } else {
                            request.setAttribute("mess3", "new password does not match");
                            request.setAttribute("user", user);
                            request.getRequestDispatcher("changePass.jsp").forward(request, response);
                        }
                    } else {
                        request.setAttribute("mess2", "new password does not long enough");
                        request.setAttribute("user", user);
                        request.getRequestDispatcher("changePass.jsp").forward(request, response);
                    }

                } else {
                    request.setAttribute("mess1", "Your password is incorrect");
                    request.setAttribute("user", user);
                    request.getRequestDispatcher("changePass.jsp").forward(request, response);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCustomer.class.getName()).log(Level.SEVERE, null, ex);
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
