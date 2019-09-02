package com.franco.Bean;

import com.franco.db.MysqlConnect;
import com.franco.models.Recievings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecieveBean implements BeanI<Recievings> {
    @Override
    public boolean create(Recievings recievings) throws SQLException {
        String sql ="INSERT INTO recieving(batchNo,id,quantity,buyingPrice,sellingPrice,supplier,runningBalance) VALUES(?,?,?,?,?,?,?)";
        Connection conn = MysqlConnect.getDbCon().conn;
        PreparedStatement prp = conn.prepareStatement(sql);

        prp.setInt(1, recievings.getBatchNo());
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        String dateString = df.format(recievings.getDate());
//        prp.setDate(2, Date.valueOf(dateString));
        prp.setInt(2, recievings.getId());
        prp.setInt(3,recievings.getQuantity());
        prp.setInt(4, (int) recievings.getBuyingPrice());
        prp.setInt(5, (int) recievings.getSellingPrice());
        prp.setString(6,recievings.getSupplier());
        prp.setInt(7,recievings.getRunningBalance());


        return prp.executeUpdate() > 0;
    }

    @Override
    public Recievings read(int id) throws SQLException {
        String sql ="SELECT * FROM recieving WHERE id="+id;
        ResultSet rs = MysqlConnect.getDbCon().executeQuery(sql);
        Recievings recievings = new Recievings();
        if (rs.next()){
            recievings.setBatchNo(rs.getInt("batchNo"));


            recievings.setId(rs.getInt("id"));
            recievings.setQuantity(rs.getInt("quantity"));
            recievings.setBuyingPrice(rs.getInt("buyingPrice"));
            recievings.setSellingPrice(rs.getInt("sellingPrice"));
            recievings.setSupplier(rs.getString("supplier"));
        }

        return recievings;
    }

    @Override
    public boolean update(Recievings recievings) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Recievings recievings) throws SQLException {
        return false;
    }
    public ArrayList<Recievings>  readAll() throws SQLException {
        String sql = "SELECT * FROM recieving";
        ResultSet rs = MysqlConnect.getDbCon().executeQuery(sql);
        ArrayList<Recievings> recieving=new ArrayList<>();
        while (rs.next()){
            Recievings recievings = new Recievings();
            recievings.setBatchNo(rs.getInt("batchNo"));
            recievings.setDate(rs.getDate("date"));

            recievings.setId(rs.getInt("id"));
            recievings.setQuantity(rs.getInt("quantity"));
            recievings.setBuyingPrice(rs.getInt("buyingPrice"));
            recievings.setSellingPrice(rs.getInt("sellingPrice"));
            recievings.setSupplier(rs.getString("supplier"));
            recieving.add(recievings);
        }

        return recieving;

    }
    public boolean isProductExists(int id) throws SQLException {
        String sql = "SELECT count(*) as 'count' FROM product where id="+id;
        ResultSet rs = MysqlConnect.getDbCon().executeQuery(sql);
        if (rs.next()){
            if (rs.getInt("count") > 0){
                return true;
            }
        }

        return  false;
    }

    public boolean isRecievingExists(int id) throws SQLException {
        String sql = "SELECT count(*) as 'count' FROM recieving where id="+id;
        ResultSet rs = MysqlConnect.getDbCon().executeQuery(sql);
        try {
            rs = MysqlConnect.getDbCon().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rs.next()){
            if (rs.getInt("count") > 0){
                return true;
            }
        }
        return false;
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
