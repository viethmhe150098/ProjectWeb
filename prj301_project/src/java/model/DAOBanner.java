/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Banner;
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
public class DAOBanner {

    Connection conn = null;
    DBConnect dbconn = null;

    public DAOBanner(DBConnect dbconn) {
        conn = dbconn.con;
        this.dbconn = dbconn;
    }

    public int addBanner(Banner ban) {
        int n = 0;
        String presql = "insert into Banner(bname, bimage) values(?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(presql);
            pre.setString(1, ban.getBname());
            pre.setString(2, ban.getBimages());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBanner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public ArrayList<Banner> getAllBanner() {
        ArrayList<Banner> list = new ArrayList<>();
        ResultSet rs = dbconn.getData("Select * from Banner");
        try {
            while (rs.next()) {
                list.add(new Banner(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBanner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Banner> get3Banner() {
        ArrayList<Banner> list = new ArrayList<>();
        ResultSet rs = dbconn.getData("Select top 3 * from Banner order by bid desc");
        try {
            while (rs.next()) {
                list.add(new Banner(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBanner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
