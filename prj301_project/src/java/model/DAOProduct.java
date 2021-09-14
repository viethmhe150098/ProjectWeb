/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Product;
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
public class DAOProduct {

    Connection conn = null;
    DBConnect dbconn = null;

    public DAOProduct(DBConnect dbconn) {
        conn = dbconn.con;
        this.dbconn = dbconn;
    }

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> arr = new ArrayList<Product>();
        String sql = "select * from Product";
        ResultSet rs = dbconn.getData(sql);
        try {
            while (rs.next()) {
                Product pro = new Product(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
                arr.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public int addProduct(Product product) {
        int n = 0;
        //preStatement insert
        String preSql = "insert into Product(pid, pname, quantity, price, image,"
                + " description, status, cateID) "
                + "values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(preSql);
            pre.setString(1, product.getPid());
            pre.setString(2, product.getPname());
            pre.setInt(3, product.getQuantity());
            pre.setDouble(4, product.getPrice());
            pre.setString(5, product.getImage());
            pre.setString(6, product.getDes());
            pre.setInt(7, product.getStatus());
            pre.setInt(8, product.getCateID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int changeStatus(String pid, int status) {
        int n = 0;
        String sql = "update Product set status=? where pid=? ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, status);
            pre.setString(2, pid);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteProduct(String pid) {
        int n = 0;
        String sql = "delete from Product where pid=?";
        //Product ben 1 cua BillDetail
        //check foreign key
        String s1 = "select * from BillDetail where pid='" + pid + "'";
        try {
            //get data
            ResultSet rs = dbconn.getData(s1);
            if (rs.next()) {
                //productID existed => change status
                changeStatus(pid, 0);
            } else {
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setString(1, pid);
                n = pre.executeUpdate();
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Product searchPro(String pid) {
        DBConnect dbconn = new DBConnect();
        ResultSet rs = this.dbconn.getData("Select * from Product where pid='" + pid + "'");
        try {
            while (rs.next()) {
                return new Product(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int updateProduct(Product pro) {
        //statement update
        int n = 0;
        String sql = "update Product set pname='" + pro.getPname()
                + "',quantity=" + pro.getQuantity() + ","
                + "price=" + pro.getPrice() + ",image='" + pro.getImage()
                + "',description='" + pro.getDes() + "',"
                + "status=" + pro.getStatus() + ",cateID=" + pro.getCateID() + " "
                + "where pid='" + pro.getPid() + "'";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public void updateQuan(int quan, String pID) {
        String sql = "update Product set quantity=(select quantity from Product where pID ='" + pID + "')-" + quan + " where pID='" + pID + "'";
        Statement state;
        try {
            state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateQuan2(int quan, String pID) {
        String sql = "update Product set quantity=(select quantity from Product where pID ='" + pID + "')+" + quan + " where pID='" + pID + "'";
        Statement state;
        try {
            state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Product> selectLast() {
        ArrayList<Product> arr = new ArrayList<Product>();
        String sql = "select top 3 * from Product order by pID desc";
        ResultSet rs = dbconn.getData(sql);
        try {
            while (rs.next()) {
                Product pro = new Product(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
                arr.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public int getNumberPage() {
        String sql = "select count(*) from Product";
        ResultSet rs = dbconn.getData(sql);
        try {
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = total / 6;
                if (countPage % 6 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getTotal() {
        String sql = "select count(*) from Product";
        ResultSet rs = dbconn.getData(sql);
        try {
            while (rs.next()) {
                return Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<Product> paggingPro(int index) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select * from Product "
                + "order by pID "
                + "offset " + (index - 1) * 6 + " rows fetch next 6 rows only";
        ResultSet rs = dbconn.getData(sql);
        try {
            while (rs.next()) {
                list.add(new Product(rs.getString(1), rs.getString(2), rs.getDouble(3),
                        rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Product> searchbyCateID(int cateID) {
        ArrayList<Product> list = new ArrayList<>();
        ResultSet rs = dbconn.getData("select * from Product "
                + "where cateID= " + cateID);
        try {
            while (rs.next()) {
                list.add(new Product(rs.getString(1), rs.getString(2), rs.getDouble(3),
                        rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public boolean searchinBD(String pid){
        ResultSet rs = dbconn.getData("select * from BillDetail where pID='"+pid+"'");
        try {
            if(rs.next()){
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static void main(String[] args) {
        DBConnect dbconn = new DBConnect();
        DAOProduct dao = new DAOProduct(dbconn);

    }
}
