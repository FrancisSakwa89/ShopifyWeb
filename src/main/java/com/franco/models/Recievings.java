package com.franco.models;

import java.util.Date;

public class Recievings{
    int batchNo;
    Date date;
    int id;
    int quantity;
    double buyingPrice;
    double sellingPrice;
    String supplier;
    int runningBalance;

    public Recievings() {
    }


    public Recievings(int batchNo, Date date, int id, int quantity, double buyingPrice, double sellingPrice, String supplier, int runningBalance) {
        this.batchNo = batchNo;
        this.date = date;
        this.id = id;
        this.quantity = quantity;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.supplier = supplier;
        this.runningBalance = runningBalance;
    }

    public int getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(int batchNo) {
        this.batchNo = batchNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int setQuantity(int quantity) {
        this.quantity = quantity;
        return quantity;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public int getRunningBalance() {
        return runningBalance;
    }

    public void setRunningBalance(int runningBalance) {
        this.runningBalance = runningBalance;
    }

    @Override
    public String toString() {
        return supplier;
    }
}
