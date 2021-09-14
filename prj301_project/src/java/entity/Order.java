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
public class Order {
    private String pid;
    private String pname;
    private String image;
    private double price;
    private int amount;

    public Order() {
    }

    public Order(String pid, String pname, String image, double price, int amount) {
        this.pid = pid;
        this.pname = pname;
        this.image = image;
        this.price = price;
        this.amount = amount;
    }

    public Order(String pid, int amount) {
        this.pid = pid;
        this.amount = amount;
    }
    
    public Order(String pid, String pname, double price, int amount) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.amount = amount;
    }
    
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
