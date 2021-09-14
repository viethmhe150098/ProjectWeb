/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Category;
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
public class DAOCategory {

    Connection conn = null;
    DBConnect dbconn = null;

    public DAOCategory(DBConnect dbconn) {
        conn = dbconn.con;
        this.dbconn = dbconn;
    }

    public ArrayList getAllCategory() {
        ArrayList<Category> arr = new ArrayList<Category>();
        String sql = "select * from Category";
        ResultSet rs = dbconn.getData(sql);
        try {
            while (rs.next()) {
                Category cate = new Category(rs.getInt(1), rs.getString(3), rs.getInt(2));
                arr.add(cate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public Category searchCate(int id) {
        ResultSet rs = dbconn.getData("Select * from Category where cateid=" + id);
        try {
            while (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(3), rs.getInt(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int updateCategory(Category cate) {
        //preStatement update
        int n = 0;
        String Presql = "update Category set cateName=?,"
                + " status=? where cateID=?";

        try {
            PreparedStatement pre = conn.prepareStatement(Presql);
            pre.setString(1, cate.getCateName());
            pre.setInt(2, cate.getStatus());
            pre.setInt(3, cate.getCateid());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int addCategory(Category cate) {
        int n = 0;
        //preStatement insert
        String preSql = "insert into Category(cateName)"
                + "values(?)";
        try {
            PreparedStatement pre = conn.prepareStatement(preSql);
            pre.setString(1, cate.getCateName());
            
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int changeStatus(int cateID, int status) {
        int n = 0;
        String sql = "update Category set status=? where cateID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, status);
            pre.setInt(2, cateID);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteCategory(int cateID) {
        int n = 0;
        String sql = "delete from Category where cateID=?";
        String s1 = "select * from Product where cateID=" + cateID;
        try {
            ResultSet rs = dbconn.getData(s1);
            if (rs.next()) {
                //productID existed => change status
                changeStatus(cateID, 0);
            } else {
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setInt(1, cateID);
                n = pre.executeUpdate();
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public static void main(String[] args) {
        DBConnect dbconn = new DBConnect();
        DAOCategory dao = new DAOCategory(dbconn);
       dao.deleteCategory(8);
    }

}
