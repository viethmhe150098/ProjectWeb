/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Admin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Viet
 */
public class DAOAdmin {

    Connection conn = null;
    DBConnect dbconn = null;

    public DAOAdmin(DBConnect dbconn) {
        conn = dbconn.con;
        this.dbconn = dbconn;
    }

    public Admin login(String user, String pass) {
        ResultSet rs = dbconn.getData("select * from Admin where username='" + user + "' and password='" + pass + "'");
        try {
            while (rs.next()) {
                return new Admin(rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Admin> getAllAdmin() {
        ArrayList<Admin> arr = new ArrayList<Admin>();
        String sql = "select * from Admin";
        ResultSet rs = dbconn.getData(sql);
        
        try {
            while (rs.next()) {
                Admin admin = new Admin(rs.getString(2), rs.getString(3));
                arr.add(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return arr;
    }
}
