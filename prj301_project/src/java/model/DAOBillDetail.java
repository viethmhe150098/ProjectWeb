/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.BillDetail;
import entity.Order;
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
public class DAOBillDetail {

    Connection conn = null;
    DBConnect dbconn = null;

    public DAOBillDetail(DBConnect dbconn) {
        conn = dbconn.con;
        this.dbconn = dbconn;
    }

    public int addBillDetail(BillDetail billDetail) {
        int n = 0;
        //preStatement insert
        String preSql = "insert into BillDetail(pid, oID, quantity, price, total) "
                + "values (?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(preSql);
            pre.setString(1, billDetail.getPid());
            pre.setString(2, billDetail.getOid());
            pre.setInt(3, billDetail.getQuantity());
            pre.setDouble(4, billDetail.getPrice());
            pre.setDouble(5, billDetail.getTotal());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBillDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public ArrayList<Order> getBd(String oid) {
        ArrayList<Order> list = new ArrayList<>();
        ResultSet rs = dbconn.getData("select * from BillDetail where oID ='" + oid + "'");
        try {
            while (rs.next()) {
                list.add(new Order(rs.getString(1), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBillDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ResultSet getDetail(String oid) {
        ResultSet rs = dbconn.getData("select b.oID,b.cID,c.username,b.cname,b.caddress,b.cphone,\n"
                + "bd.pID,p.pname,p.price,bd.quantity,bd.total,b.dateCreate\n"
                + "from ((Bill as b inner join BillDetail as bd on b.oID = bd.oID)\n"
                + "INNER JOIN Customer AS c on b.cID = c.cID) inner join Product as p on bd.pID = p.pID\n"
                + "where b.oID='" + oid + "'");
        return rs;
    }
    
}
