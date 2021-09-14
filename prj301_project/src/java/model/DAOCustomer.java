/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Viet
 */
public class DAOCustomer {

    Connection conn = null;
    DBConnect dbconn = null;

    public DAOCustomer(DBConnect dbconn) {
        conn = dbconn.con;
        this.dbconn = dbconn;
    }

    public int addCustomer(Customer cus) {
        int n = 0;
        //preStatement insert
        String preSql = "insert into Customer(cname, email, username, password)"
                + " values(?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(preSql);
            //? has index start 1
            //pre.setDataType(index of ?, value);
            //DataType data id of ?
            pre.setString(1, cus.getCname());
            pre.setString(2, cus.getEmail());
            pre.setString(3, cus.getUsername());
            pre.setString(4, cus.getPassword());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Customer login(String user, String pass) {
        ResultSet rs = dbconn.getData("select * from Customer where username='" + user + "' and password='" + pass + "'");
        try {
            while (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean dupUser(String user) {
        ResultSet rs = dbconn.getData("select * from Customer where username = '" + user + "'");
        try {
            while (rs.next()) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean dupEmail(String email) {
        ResultSet rs = dbconn.getData("select * from Customer where email = '" + email + "'");
        try {
            while (rs.next()) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public int updateCustomer(Customer cus) {
        //preStatement update
        int n = 0;
        String Presql = "update Customer set cname=?, username=? where cid=?";

        try {
            PreparedStatement pre = conn.prepareStatement(Presql);
            pre.setString(1, cus.getCname());
            pre.setString(2, cus.getUsername());
            pre.setInt(3, cus.getCid());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public void changePass(String user, String npass, String opass) {
        try {
            PreparedStatement pre = conn.prepareStatement("update Customer set password = ? where username = ? and password = ?");
            pre.setString(1, npass);
            pre.setString(2, user);
            pre.setString(3, opass);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Customer takeInfo(int id) {
        ResultSet rs = dbconn.getData("Select * from Customer where cid=" + id);
        try {
            while (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> arr = new ArrayList<Customer>();
        String sql = "select * from Customer";
        ResultSet rs = dbconn.getData(sql);
        try {
            while (rs.next()) {
                Customer cus = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(6));
                arr.add(cus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public void Customer() {

    }

    public static void main(String[] args) {
//        DBConnect dbconn = new DBConnect();
//        DAOCustomer dao = new DAOCustomer(dbconn);
//        Customer cus = dao.takeInfo("viet");
//        System.out.println(cus.getEmail());
    }
}
