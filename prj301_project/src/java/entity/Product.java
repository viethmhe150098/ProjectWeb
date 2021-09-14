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
public class Product {
    private String pid;
    private String pname;
    private double price;
    private int quantity;
    private String des;
    private String image;
    private int cateID;
    private int status;

    public Product() {
    }

    public Product(String pname, double price, int quantity, String des, String image, int cateID, int status) {
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
        this.des = des;
        this.image = image;
        this.cateID = cateID;
        this.status = status;
    }

    public Product(String pid, String pname, double price, int quantity, String des, String image, int cateID, int status) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
        this.des = des;
        this.image = image;
        this.cateID = cateID;
        this.status = status;
    }
    
    public Product(String pname, double price, int quantity, String des, String image, int cateID) {
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
        this.des = des;
        this.image = image;
        this.cateID = cateID;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" + "pid=" + pid + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity + ", des=" + des + ", image=" + image + ", cateID=" + cateID + ", status=" + status + '}';
    }
    
}
