package com.franco.models;

public class RunningBalance {
    int productId;
    String ProductName;
    int quantity;
    int RB;

    public RunningBalance() {
    }

    public RunningBalance(int productId, String productName, int quantity, int RB) {
        this.productId = productId;
        ProductName = productName;
        this.quantity = quantity;
        this.RB = RB;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRB() {
        return RB;
    }

    public void setRB(int RB) {
        this.RB = RB;
    }

    @Override
    public String toString() {

        return String.valueOf(productId);
    }
}
