/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Viet
 */
public class Admin {
    private int adID;
    private String user;
    private String pass;

    public Admin() {
    }

    public Admin(int adID, String user, String pass) {
        this.adID = adID;
        this.user = user;
        this.pass = pass;
    }

    public int getAdID() {
        return adID;
    }

    public void setAdID(int adID) {
        this.adID = adID;
    }
    
    public Admin(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
