package dao;

import entity.Item;
import entity.Souvenirs;

import java.sql.*;

public class DAO implements IDAO {

    static final String DB_URL = "jdbc:mysql://localhost/souvenirs?serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "Pa$$w0rD17";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    Connection conn = null;
    Statement stmt = null;
    public DAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
    }

    @Override
    public Souvenirs getAll(){
        Souvenirs souvenirs = new Souvenirs();
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT *  FROM producer";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int producerId = rs.getInt("producer_id");
                String name = rs.getString("name");
                String country = rs.getString("country");

                souvenirs.addProducer(producerId, name, country);
            }

            sql = "SELECT *  FROM item";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                int itemId = rs.getInt("item_id");
                String title = rs.getString("title");
                int requisite = rs.getInt("requisite");
                Date date = rs.getDate("dateOfIssue");
                int price = rs.getInt("price");
                int prodId = rs.getInt("prod_id");
                souvenirs.getProducer(prodId).addItem(new Item(itemId, title,requisite,date,price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return souvenirs;
    }




}
