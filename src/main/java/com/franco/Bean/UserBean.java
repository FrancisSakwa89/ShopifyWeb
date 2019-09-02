package com.franco.Bean;

import com.franco.db.MysqlConnect;
import com.franco.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBean implements BeanI<User> {

    @Override
    public boolean create(User user) throws SQLException {
        String sql = "INSERT INTO users(name,password) VALUES(?,?)";
        Connection conn = MysqlConnect.getDbCon().conn;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());

        return ps.executeUpdate() > 0;
    }

    @Override
    public User read(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE userId=" + id;
        ResultSet rs = MysqlConnect.getDbCon().executeQuery(sql);
        User user = new User("","");
        if (rs.next()) {
            user.setUsername(rs.getString("name"));
            user.setPassword(rs.getString("password"));
        }

        return user;

    }


    public User readByName(String name) throws SQLException {
        String sql = "SELECT * FROM users WHERE name='" + name+"'";
        ResultSet rs = MysqlConnect.getDbCon().executeQuery(sql);
        User user = new User("","");
        if (rs.next()) {
            user.setUsername(rs.getString("name"));
            user.setPassword(rs.getString("password"));
        }

        return user;

    }

    @Override
    public boolean update(User user) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        return false;
    }
}
