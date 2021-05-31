package entity;

import java.sql.*;



public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/souvenirs";
            Connection con = DriverManager.getConnection(url, "root", "Pa$$w0rD17");

            con.close();
        }
        catch(Exception e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}
