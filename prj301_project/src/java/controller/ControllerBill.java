/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Bill;
import entity.Customer;
import entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOBill;
import model.DAOBillDetail;
import model.DAOProduct;
import model.DBConnect;

/**
 *
 * @author Viet
 */
public class ControllerBill extends HttpServlet {

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
            DAOBillDetail dao = new DAOBillDetail(dbconn);
            DAOBill daob = new DAOBill(dbconn);
            String service = request.getParameter("service");
            if (service == null) {
                service = "getAll";
            }
            if (service.equals("viewDetail")) {
                String oid = request.getParameter("oid");
                ResultSet rs = dao.getDetail(oid);

                String dateCreate = null;
                String username = null;
                String receiver = null;
                String address = null;
                String phone = null;
                ArrayList<Order> list = new ArrayList<>();
                while (rs.next()) {
                    dateCreate = rs.getString(12);
                    username = rs.getString(3);
                    receiver = rs.getString(4);
                    address = rs.getString(5);
                    phone = rs.getString(6);
                    list.add(new Order(rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getInt(10)));
                }
                String s[] = dateCreate.split("\\s");
                request.setAttribute("dateCreate", s[0]);
                request.setAttribute("username", username);
                request.setAttribute("receiver", receiver);
                request.setAttribute("address", address);
                request.setAttribute("phone", phone);
                request.setAttribute("list", list);
                request.setAttribute("oid", oid);
                request.getRequestDispatcher("CusBillDetail.jsp").forward(request, response);
            }
            if(service.equals("adViewDe")){
                String oid = request.getParameter("id");
                ResultSet rs = dao.getDetail(oid);

                String dateCreate = null;
                String username = null;
                String receiver = null;
                String address = null;
                String phone = null;
                ArrayList<Order> list = new ArrayList<>();
                while (rs.next()) {
                    dateCreate = rs.getString(12);
                    username = rs.getString(3);
                    receiver = rs.getString(4);
                    address = rs.getString(5);
                    phone = rs.getString(6);
                    list.add(new Order(rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getInt(10)));
                }
                String s[] = dateCreate.split("\\s");
                request.setAttribute("dateCreate", s[0]);
                request.setAttribute("username", username);
                request.setAttribute("receiver", receiver);
                request.setAttribute("address", address);
                request.setAttribute("phone", phone);
                request.setAttribute("listO", list);
                request.setAttribute("oid", oid);
                request.getRequestDispatcher("adViewbd.jsp").forward(request, response);
            }
            if (service.equals("getAll")) {
                ArrayList<Bill> list = daob.getAllBill();
                request.setAttribute("listb", list);
                request.getRequestDispatcher("Bill.jsp").forward(request, response);
            }
            if (service.equals("upSta")) {
                int status = Integer.parseInt(request.getParameter("status"));
                String oid = request.getParameter("oid");
                daob.upSta(oid, status);
                if (status == 4) {
                    
                    daob.upSta(oid, 4);
                    DAOProduct daoP = new DAOProduct(dbconn);
                    DAOBillDetail daoBd = new DAOBillDetail(dbconn);
                    ArrayList<Order> list = daoBd.getBd(oid);
                    for (Order order : list) {
                        daoP.updateQuan2(order.getAmount(), order.getPid());
                    }
                }
                response.sendRedirect("ControllerBill");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBill.class.getName()).log(Level.SEVERE, null, ex);
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
