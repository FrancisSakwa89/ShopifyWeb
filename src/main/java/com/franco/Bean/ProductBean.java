package com.franco.Bean;

import com.franco.db.MysqlConnect;
import com.franco.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductBean implements BeanI<Product> {


    @Override
    public boolean create(Product product) throws SQLException {
        String sql = "INSERT INTO product(name,description) VALUES(?,?)";
        Connection conn = MysqlConnect.getDbCon().conn;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, product.getName());
        ps.setString(2, product.getDescription());


        return ps.executeUpdate() > 0;
    }

    @Override
    public Product read(int id) throws SQLException {
        String sql = "SELECT * FROM product WHERE id=" + id;
        ResultSet rs = MysqlConnect.getDbCon().executeQuery(sql);
        Product product = new Product();
        if (rs.next()) {
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setDescription(rs.getString("description"));
        }

        return product;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        String sql = "UPDATE product SET name=?,description=? WHERE id=" + product.getId();
        Connection conn = MysqlConnect.getDbCon().conn;

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, product.getName());
        ps.setString(2, product.getDescription());

        return ps.executeUpdate() > 0;
    }


    @Override
    public boolean delete(Product product) throws SQLException {
        String sql = "DELETE FROM product WHERE id=" + product.getId();
        Connection conn = MysqlConnect.getDbCon().conn;

        PreparedStatement prp = conn.prepareStatement(sql);

        return prp.executeUpdate() > 0;
    }

    public ArrayList<Product> readAll() throws SQLException {
        String sql = "SELECT * FROM product";
        ResultSet rs = MysqlConnect.getDbCon().executeQuery(sql);
        ArrayList<Product> products = new ArrayList<>();

        while (rs.next()) {
            Product product = new Product();

            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setDescription(rs.getString("description"));
            products.add(product);
        }
        return products;
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
