/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Bill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Viet
 */
public class DAOBill {

    Connection conn = null;
    DBConnect dbconn = null;

    public DAOBill(DBConnect dbconn) {
        conn = dbconn.con;
        this.dbconn = dbconn;
    }

    public int addBill(Bill bil) {
        int n = 0;
        //preStatement insert
        String preSql = "insert into Bill(oID, cname, cphone, cAddress, total, cid)"
                + " values(?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(preSql);
            pre.setString(1, bil.getOid());
            pre.setString(2, bil.getCname());
            pre.setString(3, bil.getCphone());
            pre.setString(4, bil.getCaddress());
            pre.setDouble(5, bil.getTotal());
            pre.setInt(6, bil.getCid());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public ArrayList<Bill> getAllBill() {
        ArrayList<Bill> arr = new ArrayList<Bill>();
        String sql = "select * from Bill";
        ResultSet rs = dbconn.getData(sql);
        try {
            while (rs.next()) {
                Bill bill = new Bill(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(8), rs.getInt(7));
                arr.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Bill> getByCus(int id) {
        ArrayList<Bill> arr = new ArrayList<Bill>();
        String sql = "select * from Bill where cid=" + id;
        ResultSet rs = dbconn.getData(sql);
        try {
            while (rs.next()) {
                String[] date = rs.getString(6).split("\\s");
                Bill bill = new Bill(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), date[0], rs.getInt(8), rs.getInt(7));
                arr.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public void upSta(String oid, int sta) {
        String sql = "update Bill\n"
                + "set status=? \n"
                + "where oID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, sta);
            pre.setString(2, oid);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void main(String[] args) {
        DBConnect dbconn = new DBConnect();
        DAOBill dao = new DAOBill(dbconn);
        ArrayList<Bill> list = dao.getAllBill();
        for (Bill bill : list) {
            System.out.println(bill);
        }
    }
}
