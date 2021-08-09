package com.kevin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Category {

    final static Category CATEGORY_LIFE = new Category(1,"生活用品");
    final static Category CATEGORY_COMPUTER = new Category(1, "電腦零組件");

    int id;
    String name;
    int version = 1;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static List<Category> getDummyCategories(){
        List<Category> list = new ArrayList<>();
        list.add(new Category(1,"生活用品"));
        list.add(new Category(1,"電腦零件組"));
        return list;
    }

    public static List<Category> getCategories(){
        //從mariaDB中導入分類資料
        List<Category> list = new ArrayList<>();
        try {
            //1.建立通道 driver
            Class.forName("org.mariadb.jdbc.Driver");
            //2.連到資料庫
            Connection connection =
                    DriverManager.getConnection(
                            "jdbc:mariadb://localhost:3306/shop?","jack","abc333");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from category");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int version = resultSet.getInt("version");
                list.add(new Category(id,name));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
