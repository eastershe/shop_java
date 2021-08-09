package com.kevin.db;

import java.sql.*;

public class ShopTester {
    public static void main(String[] args) {

        try {
            //1.讀取驅動程式 JDBC Driver
            Class.forName("org.mariadb.jdbc.Driver");
            //2.連線資料庫, URL String
            Connection connection =
                    DriverManager.getConnection(
                            "jdbc:mariadb://localhost:3306/shop", "jack","abc333");

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from category");
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                System.out.println(id);
                String name = resultSet.getString(2);
                System.out.println(name);
                int version = resultSet.getInt("version");
                System.out.println(version);
            }
            resultSet.close();
            stmt.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
