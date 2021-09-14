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
public class Category {
    private int cateid;
    private String cateName;
    private int status;

    public Category() {
    }

    public Category(String cateName) {
        this.cateName = cateName;
    }
    
    public Category(String cateName, int status) {
        this.cateName = cateName;
        this.status = status;
    }

    public Category(int cateid, String cateName, int status) {
        this.cateid = cateid;
        this.cateName = cateName;
        this.status = status;
    }
    
    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
