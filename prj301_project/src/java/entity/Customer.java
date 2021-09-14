/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Viet
 */
public class Customer {
    private int cid;
    private String email;
    private String cname;
    private String username;
    private String password;
    private int status;

    public Customer() {
    }

    public Customer(String email, String cname, String username, String password) {
        this.email = email;
        this.cname = cname;
        this.username = username;
        this.password = password;
    }

    public Customer(int cid, String email, String cname, String username, int status) {
        this.cid = cid;
        this.email = email;
        this.cname = cname;
        this.username = username;
        this.status = status;
    }


    
    public Customer(int cid, String email, String cname, String username, String password) {
        this.cid = cid;
        this.email = email;
        this.cname = cname;
        this.username = username;
        this.password = password;
    }

    public Customer(int cid, String cname, String username) {
        this.cid = cid;
        this.cname = cname;
        this.username = username;
    }
    
    
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}
