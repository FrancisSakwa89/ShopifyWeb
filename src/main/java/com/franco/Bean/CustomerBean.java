package com.franco.Bean;

import com.franco.db.MysqlConnect;
import com.franco.models.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBean implements BeanI<Customer> {

    @Override
    public boolean create(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer(name) VALUES(?)";
        Connection conn = MysqlConnect.getDbCon().conn;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, customer.getName());
//        ps.setInt(2, customer.getUserId());


        return ps.executeUpdate() > 0;

    }

    @Override
    public  Customer read(int id) throws SQLException {
        String sql = "SELECT * FROM customer WHERE UserId=" + id;
        ResultSet rs = MysqlConnect.getDbCon().executeQuery(sql);
         Customer customer = new Customer();
        if (rs.next()) {
            customer.setName(rs.getString("name"));
            customer.setUserId(rs.getInt("userId"));
        }

        return customer;

    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        String sql = "UPDATE customer SET name=? WHERE userId=" + customer.getUserId();
        Connection conn = MysqlConnect.getDbCon().conn;

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, customer.getName());
//        ps.setInt(2, customer.getUserId());

        return ps.executeUpdate() > 0;
    }


    @Override
    public boolean delete(Customer customer) throws SQLException {
        String sql = "DELETE FROM customer WHERE userId=" + customer.getUserId();
        Connection conn = MysqlConnect.getDbCon().conn;

        PreparedStatement prp = conn.prepareStatement(sql);

        return prp.executeUpdate() > 0;
    }


    public ArrayList<Customer> readAll() throws SQLException {
        String sql = "SELECT * FROM customer";
        ResultSet rs = MysqlConnect.getDbCon().executeQuery(sql);
        ArrayList<Customer> customers = new ArrayList<>();

        while (rs.next()) {
            Customer customer = new Customer();
            customer.setName(rs.getString("name"));
            customer.setUserId(rs.getInt("userId"));
            customers.add(customer);
        }
        return customers;

    }

    public static boolean isCustomerExists(int id) throws SQLException {
        String sql = "SELECT count(*) as 'count' FROM customer where userId="+id;
        ResultSet rs = MysqlConnect.getDbCon().executeQuery(sql);
        if (rs.next()){
            if (rs.getInt("count") > 0){
                return true;
            }
        }

        return  false;
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

