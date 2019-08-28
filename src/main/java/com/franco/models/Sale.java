package com.franco.models;

import com.franco.Bean.ProductBean;

import java.sql.SQLException;
import java.util.Date;

public class Sale {
    int saleId;
    Date datetime;
    int productId;
    int quantity;
    String customerName;
    int sellingPrice;
    int runningBalance;
    double totalAmount;


//    public Sale(Date datetime, int productId, int quantity, int sellingPrice, String customerName) {
//    }

    public Sale(Date datetime, int productId, int quantity, String customerName, int sellingPrice,int runningBalance,double totalAmount) {
        this.datetime = datetime;
        this.productId = productId;
        this.quantity = quantity;
        this.customerName = customerName;
        this.sellingPrice = sellingPrice;
        this.runningBalance = runningBalance;
        this.totalAmount = totalAmount;
    }

    public Sale() {
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getRunningBalance() {
        return runningBalance;
    }

    public int setRunningBalance(int runningBalance) {
        this.runningBalance = runningBalance;
        return  runningBalance;
    }

    @Override
    public String toString() {
        try {
            Product product = new ProductBean().read(productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Sale sale = new Sale();
        return "Sale id: "+sale.getSaleId()+" Date: "+datetime+" product: "+productId+ " selling Price: "+sellingPrice+ " quantity: "+quantity+" totalAmount: "+totalAmount+ "customerName: "+customerName;

    }
}
