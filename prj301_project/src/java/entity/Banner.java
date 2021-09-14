/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import model.DAOBanner;
import model.DBConnect;

/**
 *
 * @author Viet
 */
public class Banner {
    private int bid;
    private String bname;
    private String bimages;

    public Banner() {
    }

    public Banner(int bid, String bname, String bimages) {
        this.bid = bid;
        this.bname = bname;
        this.bimages = bimages;
    }

    public Banner(String bname, String bimages) {
        this.bname = bname;
        this.bimages = bimages;
    }
    
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBimages() {
        return bimages;
    }

    public void setBimages(String bimages) {
        this.bimages = bimages;
    }

    @Override
    public String toString() {
        return "Banner{" + "bid=" + bid + ", bname=" + bname + ", bimages=" + bimages + '}';
    }

    public static void main(String[] args) {
        DBConnect dbconn = new DBConnect();
        DAOBanner dao = new DAOBanner(dbconn);
        ArrayList<Banner> list = dao.getAllBanner();
        for (Banner banner : list) {
            System.out.println(banner);
        }
    }
    
}
