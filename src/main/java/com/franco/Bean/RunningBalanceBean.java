package com.franco.Bean;

import com.franco.db.MysqlConnect;
import com.franco.models.RunningBalance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RunningBalanceBean implements BeanI <RunningBalance> {
    @Override
    public boolean create(RunningBalance runningBalance) throws SQLException {
        String sql = "INSERT INTO runningBalance(int productId, String productName, int quantity, int RB) VALUES(?,?,?,?)";
        Connection conn = MysqlConnect.getDbCon().conn;
        PreparedStatement prp = conn.prepareStatement(sql);

        prp.setInt(1,runningBalance.getProductId());
        prp.setString(2, runningBalance.getProductName());
        prp.setInt(3, runningBalance.getQuantity());
        prp.setInt(4, runningBalance.getRB());

        prp.executeUpdate();

        return prp.executeUpdate() > 0;
    }

    @Override
    public RunningBalance read(int id) throws SQLException {
        String sql ="SELECT * FROM runningBalance WHERE ProductId="+id;
        ResultSet rs = MysqlConnect.getDbCon().executeQuery(sql);
        RunningBalance runningBalance = new RunningBalance();
        if (rs.next()){
            runningBalance.setProductId(rs.getInt("productId"));
            runningBalance.setProductName(rs.getString("productName"));
            runningBalance.setQuantity(rs.getInt("quantity"));
            runningBalance.setRB(rs.getInt("RB"));
        }

        return runningBalance;
    }

    @Override
    public boolean update(RunningBalance runningBalance) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(RunningBalance runningBalance) throws SQLException {
        return false;
    }
}
