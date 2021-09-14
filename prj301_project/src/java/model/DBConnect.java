/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Viet
 */
public class DBConnect {

    Connection con = null;

    public DBConnect(String URL, String username, String pass) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(URL, username, pass);
            System.out.println("connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DBConnect() {
        this("jdbc:sqlserver://localhost:1433;databaseName=prj301_Viet", "sa", "123456");
    }

    public ResultSet getData(String sql) {
        ResultSet rs = null;
        try {
            Statement state = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public static void main(String[] args) {
        new DBConnect();
    }
}
