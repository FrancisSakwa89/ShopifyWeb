package com.franco.Bean;

import com.franco.db.MysqlConnect;
import com.franco.models.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class SaleBean implements BeanI <Sale>{
    Scanner scan = new Scanner(System.in);
    @Override
    public boolean create(Sale sale) throws SQLException {

//        String sql = "INSERT INTO sale(date,productId,quantity,sellingPrice,runningBalance,customerName,totalAmount) VALUES(?,?,?,?,?,?,?)";
//        Connection conn = MysqlConnect.getDbCon().conn;
//        Recievings recievings = new RecieveBean().read(sale.getProductId());
////        recievings = new RecieveBean().read(sale.getProductId());
//        try {
//            try {
//                if (recievings.getQuantity() > 0) {
//                    recievings = new RecieveBean().read(sale.getProductId());
//                    if (recievings.getQuantity() >= sale.getQuantity()) {
//                        conn = MysqlConnect.getDbCon().conn;
//                        PreparedStatement prp = conn.prepareStatement(sql);
//                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//                        String dateString = df.format(sale.getDatetime());
//                        prp.setDate(1, Date.valueOf(dateString));
//                        prp.setInt(2, sale.getProductId());
//                        prp.setInt(3, sale.getQuantity());
//                        prp.setInt(4, sale.getSellingPrice());
//                        prp.setInt(5, sale.getRunningBalance());
//                        prp.setString(6, sale.getCustomerName());
//                        recievings.setRunningBalance(recievings.getQuantity() - sale.getQuantity());
//
//                        if (prp.executeUpdate() > 0 && new RecieveBean().update(recievings)) {
//                            return true;
//
//                        } else {
//                            System.out.println("some ");
//                        }
//
//
//                    } else {
//                        System.out.println("not enough");
//                    }
//
//                } else {
//                    System.out.println("not received");
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//
//        } catch (Exception e) {
//            System.out.println("You got some sql error...");
//
//            e.printStackTrace();
//        }
//
//        return false;


        String sql = "INSERT INTO sale(date,productId,quantity,sellingPrice,runningBalance,customerName,totalAmount) VALUES(?,?,?,?,?,?,?)";
        Connection conn = MysqlConnect.getDbCon().conn;
        Recievings recievings = new RecieveBean().read(sale.getProductId());
        PreparedStatement prp = conn.prepareStatement(sql);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = df.format(sale.getDatetime());
        prp.setDate(1, Date.valueOf(dateString));
        prp.setInt(2, sale.getProductId());
        prp.setInt(3, sale.getQuantity());
        prp.setInt(4, sale.getSellingPrice());
        prp.setInt(5, sale.getRunningBalance());
        prp.setString(6, sale.getCustomerName());
        prp.setDouble(7,sale.getTotalAmount());

        return prp.executeUpdate() > 0;

    }

    @Override
    public Sale read(int id) throws SQLException {
        String sql = "SELECT * FROM sale WHERE saleId="+id;
        ResultSet rs = MysqlConnect.getDbCon().executeQuery(sql);
        Sale sale = new Sale();
        if (rs.next()){
            sale.setSaleId(rs.getInt("saleId"));
            sale.setDatetime(rs.getDate("date"));
            sale.setProductId(rs.getInt("productId"));
            sale.setQuantity(rs.getInt("quantity"));
            sale.setSellingPrice(rs.getInt("sellingPrice"));
            sale.setTotalAmount(rs.getDouble("totalAmount"));
            sale.setRunningBalance(rs.getInt("runningBalance"));
            sale.setCustomerName(rs.getString("customerName"));

        }

        return sale;
    }

    @Override
    public boolean update(Sale sale) throws SQLException {
        String sql = "UPDATE sale SET date=?,productId=?,quantity=?,sellingPrice=?,customerName=?,totalAmount=? WHERE saleId="+sale.getSaleId();

        Connection conn = MysqlConnect.getDbCon().conn;
        PreparedStatement prp = conn.prepareStatement(sql);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = df.format(sale.getDatetime());
        prp.setDate(1, Date.valueOf(dateString));
        prp.setInt(2, sale.getProductId());
        prp.setInt(3, sale.getQuantity());
        prp.setInt(4, sale.getSellingPrice());
        prp.setDouble(5,sale.getTotalAmount());
        prp.setString(6,sale.getCustomerName());


        return prp.executeUpdate() > 0;
    }

    @Override
    public boolean delete(Sale sale) throws SQLException {
        String sql = "DELETE FROM sale WHERE saleId="+sale.getSaleId();
        Connection conn = MysqlConnect.getDbCon().conn;

        PreparedStatement prp = conn.prepareStatement(sql);

        return prp.executeUpdate() > 0;
    }

    public ArrayList<Sale> readAll() throws SQLException {
        String sql = "SELECT * FROM sale";
        ResultSet rs = MysqlConnect.getDbCon().executeQuery(sql);
        ArrayList<Sale> sales=new ArrayList<>();
        while(rs.next()){
            Sale sale = new Sale();
            sale.setSaleId(rs.getInt("saleId"));
            sale.setDatetime(rs.getDate("date"));
            sale.setProductId(rs.getInt("productId"));
            sale.setQuantity(rs.getInt("quantity"));
            sale.setSellingPrice(rs.getInt("sellingPrice"));
            sale.setTotalAmount(rs.getDouble("totalAmount"));
            sale.setCustomerName(rs.getString("customerName"));
            sales.add(sale);

        }

        return sales;

    }

public ArrayList<Sale> getTotalAmount(int id) throws SQLException {
    String sql = "SELECT totalAmount FROM sale where productId="+id;
    ResultSet rs = MysqlConnect.getDbCon().executeQuery(sql);
    ArrayList<Sale> sales=new ArrayList<>();
    while(rs.next()){
        Sale sale = new Sale();
        sale.setTotalAmount(rs.getDouble("totalAmount"));
        sale.setCustomerName(rs.getString("customerName"));
        sales.add(sale);

    }
    return sales;

}
    public static boolean commit(){
        MysqlConnect.getDbCon().commit();
        return true;
    }
    public static boolean rollBack(){
        MysqlConnect.getDbCon().rollBack();
        return false;
    }



}
