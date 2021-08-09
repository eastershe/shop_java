package com.kevin.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//建立資料庫 box
//建立表格box
//建立2-3筆郵便箱資料 id, name, length, width, height, price

//box(database) -> box(table)
//-> 1, Box #1, 10, 10, 10, 10, 100
//-> 2, Box #2, 15, 10, 10, 10, 150
//-> 3, Box #3, 15, 15, 10, 10, 200

public class BoxExam {
    public static void main(String[] args) {

        List<BoxFormDB> boxFormDBList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        //connect to database(localhost)
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection connection =
                    DriverManager.getConnection(
                            "jdbc:mariadb://localhost:3306/box?", "jack", "abc333");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from box");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int width = resultSet.getInt("width");
                int length = resultSet.getInt("length");
                int height = resultSet.getInt("height");
                int price = resultSet.getInt("price");
                boxFormDBList.add(new BoxFormDB(id,name,length,width,height,price));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //select * from box
        System.out.println("郵便箱尺寸及價目表如下:");
        System.out.println("編號\t名稱\t\t長x寬x高\t\t價格");
        for (BoxFormDB boxFormDB : boxFormDBList) {
            System.out.println(boxFormDB);
        }

        //Please enter your object length:
        System.out.print("\nPlease enter your object length:");
        int length = scanner.nextInt();

        //Please enter your object width:
        System.out.print("Please enter your object width:");
        int width = scanner.nextInt();

        //Please enter your object height:
        System.out.print("Please enter your object height:");
        int height = scanner.nextInt();

        //box name, price or no box for you

        Boolean matched = false;

        for (BoxFormDB boxFormDB : boxFormDBList) {
            if (boxFormDB.validate(length,width,height)){
                System.out.println("請選擇" + boxFormDB.name + ",價格為: " + boxFormDB.price + "元");
                matched = true;
                break;
            }
        }

        if (!matched){
            System.out.println("抱歉，沒有您適合的箱子");
        }
    }
}
