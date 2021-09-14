/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Bill;
import entity.BillDetail;
import entity.Order;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOBill;
import model.DAOBillDetail;
import model.DAOProduct;
import model.DBConnect;

/**
 *
 * @author Viet
 */
public class Checkout extends HttpServlet {

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
            DAOBill daoBill = new DAOBill(dbconn);
            String service = request.getParameter("service");
            if (service.equals("checkout")) {
                ArrayList<Bill> allBill = daoBill.getAllBill();
                double total = 0;
                int cid = Integer.parseInt(request.getParameter("cid"));
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                String phone = request.getParameter("phone");
                String oid = random();
                for (Bill bill : allBill) {
                    while (oid.equals(bill.getOid())) {
                        oid = random();
                    }
                }

                Cookie arr[] = request.getCookies();
                ArrayList<Order> list = new ArrayList<>();
                DAOBillDetail daobd = new DAOBillDetail(dbconn);
                for (Cookie o : arr) {
                    if (o.getName().equals("id")) {
                        String txt[] = o.getValue().split(",");
                        for (String s : txt) {
                            Product pro = dao.searchPro(s);
                            list.add(new Order(pro.getPid(), pro.getPname(), pro.getImage(), pro.getPrice(), 1));
                        }
                    }
                }
                for (int i = 0; i < list.size(); i++) {
                    int count = 1;
                    for (int j = i + 1; j < list.size(); j++) {
                        if (list.get(i).getPid().equals(list.get(j).getPid())) {
                            count++;
                            list.remove(j);
                            j--;
                            list.get(i).setAmount(count);
                        }
                    }
                }
                for (Order order : list) {
                    total += order.getAmount() * order.getPrice();
                }

                daoBill.addBill(new Bill(cid, oid, name, address, phone, 1, total));
                for (Order or : list) {
                    daobd.addBillDetail(new BillDetail(oid, or.getPid(), or.getAmount(), or.getPrice(), or.getPrice() * or.getAmount()));
                    dao.updateQuan(or.getAmount(), or.getPid());
                }
                for (Cookie o : arr) {
                    if (o.getName().equals("id")) {
                        o.setMaxAge(0);
                        response.addCookie(o);
                    }
                }
                response.sendRedirect("HomeControll");
            }
            if(service.equals("cancel")){
                String oid =  request.getParameter("oid");
                daoBill.upSta(oid, 4);
                DAOBillDetail daoBd = new DAOBillDetail(dbconn);
                ArrayList<Order> list = daoBd.getBd(oid);
                for (Order order : list) {
                    dao.updateQuan2(order.getAmount(), order.getPid());
                }
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

    public String random() {
        String original = "ABCDEFGHIJKLMNOPKQRTU120345567891011abcdefxhegklmnopfdsfdsoj";
        String capcha = "";
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            int index = rand.nextInt(original.length());
            capcha = capcha + original.charAt(index);
        }

        return capcha;
    }

}
