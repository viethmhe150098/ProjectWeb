/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Category;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOCategory;
import model.DAOProduct;
import model.DBConnect;

/**
 *
 * @author Viet
 */
public class ControllerProduct extends HttpServlet {

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
            DAOProduct dao = new DAOProduct(dbconn);
            DAOCategory daoCate = new DAOCategory(dbconn);

            String service = request.getParameter("service");
            if (service == null) {
                service = "displayAll";
            }
            if (service.equals("displayAll")) {
                ArrayList<Category> cate = daoCate.getAllCategory();
                request.setAttribute("listCate", cate);
                String indexPage = request.getParameter("index");
                if (indexPage == null) {
                    indexPage = "1";
                }
                int index = Integer.parseInt(indexPage);

                ArrayList<Product> list = dao.paggingPro(index);
                request.setAttribute("listPro", list);
                int endPage = dao.getNumberPage();

                request.setAttribute("endPage", endPage);
                request.getRequestDispatcher("Product.jsp").forward(request, response);
            }
            if (service.equals("shop")) {
                ArrayList<Category> cate = daoCate.getAllCategory();
                request.setAttribute("listCate", cate);
                String indexPage = request.getParameter("index");
                if (indexPage == null) {
                    indexPage = "1";
                }
                int index = Integer.parseInt(indexPage);

                ArrayList<Product> list = dao.paggingPro(index);
                request.setAttribute("listPro", list);
                int endPage = dao.getNumberPage();

                request.setAttribute("endPage", endPage);
                request.getRequestDispatcher("shop.jsp").forward(request, response);
            }
            if (service.equals("update")) {
                String pid = request.getParameter("pid");
                Product pro = dao.searchPro(pid);
                request.setAttribute("pro", pro);
                ArrayList<Category> listCate = daoCate.getAllCategory();
                request.setAttribute("listCate", listCate);
                request.getRequestDispatcher("preUpdatePro.jsp").forward(request, response);
            }
            if (service.equals("updated")) {
                String pid = request.getParameter("pid");
                String pname = request.getParameter("pname");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                double price = Double.parseDouble(request.getParameter("price"));
                String image = request.getParameter("image");
                String des = request.getParameter("description");
                int status = Integer.parseInt(request.getParameter("status"));
                int cateid = Integer.parseInt(request.getParameter("cate"));
                if (image.equals("")) {
                    image = dao.searchPro(pid).getImage();
                }
                Product pro = new Product(pid, pname, price, quantity, des, image, cateid, status);
                dao.updateProduct(pro);
                response.sendRedirect("ControllerProduct");

            }
            if (service.equals("preAdd")) {
                ArrayList<Category> listCate = daoCate.getAllCategory();
                request.setAttribute("listCate", listCate);
                request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
            }
            if (service.equals("add")) {
                String pid = request.getParameter("pid");
                String pname = request.getParameter("pname");
                Double price = Double.parseDouble(request.getParameter("price"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                String description = request.getParameter("description");
                String image = request.getParameter("image");
                int cateid = Integer.parseInt(request.getParameter("cate"));
                int status = Integer.parseInt(request.getParameter("status"));
                String sql = "Select * from Product where pid ='" + pid + "'";
                ResultSet rs = dbconn.getData(sql);
                if (rs.next()) {
                    response.sendRedirect("Error.jsp");
                    return;
                }
                Product pro = new Product(pid, pname, price, quantity, description, image, cateid, status);
                dao.addProduct(pro);
                response.sendRedirect("ControllerProduct");
            }
            if (service.equals("delete")) {
                String id = request.getParameter("pid");
                dao.deleteProduct(id);
                if (!dao.searchinBD(id)) {
                    request.setAttribute("mess", "This product in bill can not delete");
                    request.setAttribute("id", id);
                    ArrayList<Category> cate = daoCate.getAllCategory();
                    request.setAttribute("listCate", cate);
                    String indexPage = request.getParameter("index");
                    if (indexPage == null) {
                        indexPage = "1";
                    }
                    int index = Integer.parseInt(indexPage);

                    ArrayList<Product> list = dao.paggingPro(index);
                    request.setAttribute("listPro", list);
                    int endPage = dao.getNumberPage();

                    request.setAttribute("endPage", endPage);
                    request.getRequestDispatcher("Product.jsp").forward(request, response);
                }

//                response.sendRedirect("ControllerProduct?service=displayAll");
            }
            if (service.equals("searchbyCate")) {
                ArrayList<Category> listCate = daoCate.getAllCategory();
                request.setAttribute("listCate", listCate);
                int cateId = Integer.parseInt(request.getParameter("cateid"));
                ArrayList<Product> listPro = dao.searchbyCateID(cateId);
                request.setAttribute("listPro", listPro);
                request.getRequestDispatcher("CatePro.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
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
