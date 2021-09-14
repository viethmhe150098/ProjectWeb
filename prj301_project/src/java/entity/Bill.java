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
public class Bill {
    private int cid;
    private String oid;
    private String cname;
    private String caddress;
    private String cphone;
    private String dateCreate;
    private int status;
    private double total;

    public Bill() {
    }

    public Bill(int cid, String oid, String cname, String caddress, String cphone, String dateCreate, int status, double total) {
        this.cid = cid;
        this.oid = oid;
        this.cname = cname;
        this.caddress = caddress;
        this.cphone = cphone;
        this.dateCreate = dateCreate;
        this.status = status;
        this.total = total;
    }

    public Bill(int cid, String oid, String cname, String caddress, String cphone, int status, double total) {
        this.cid = cid;
        this.oid = oid;
        this.cname = cname;
        this.caddress = caddress;
        this.cphone = cphone;
        this.status = status;
        this.total = total;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Bill{" + "cid=" + cid + ", oid=" + oid + ", cname=" + cname + ", caddress=" + caddress + ", cphone=" + cphone + ", dateCreate=" + dateCreate + ", status=" + status + ", total=" + total + '}';
    }
    
}
