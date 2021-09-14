/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Category;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOCategory;
import model.DBConnect;

/**
 *
 * @author Viet
 */
public class ControllerCategory extends HttpServlet {

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
            DAOCategory daoCate = new DAOCategory(dbconn);
            String service = request.getParameter("service");
            if(service == null){
                service ="displayAll";
            }
            if(service.equals("displayAll")){
                ArrayList<Category> listCate = daoCate.getAllCategory();
                request.setAttribute("listCate", listCate);
                request.getRequestDispatcher("Category.jsp").forward(request, response);
            }
            if(service.equals("update")){
                int id = Integer.parseInt(request.getParameter("id"));
                Category cate = daoCate.searchCate(id);
                request.setAttribute("cate", cate);
                request.getRequestDispatcher("preUpdateCate.jsp").forward(request, response);
            }
            if(service.equals("updated")){
                int id = Integer.parseInt(request.getParameter("cateID"));
                String cateName = request.getParameter("cateName");
                int status = Integer.parseInt(request.getParameter("status"));
                Category cate = new Category(id, cateName, status);
                daoCate.updateCategory(cate);
                response.sendRedirect("ControllerCategory");
            }
            if(service.equals("preAdd")){
                response.sendRedirect("AddCate.jsp");
            }
            if(service.equals("add")){
                String name = request.getParameter("cateName");
                Category cate = new Category(name);
                daoCate.addCategory(cate);
                response.sendRedirect("ControllerCategory");
            }
            if(service.equals("delete")){
                int id = Integer.parseInt(request.getParameter("id"));
                daoCate.deleteCategory(id);
                response.sendRedirect("ControllerCategory");
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
