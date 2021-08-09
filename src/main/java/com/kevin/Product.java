package com.kevin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Product {
    //屬性
    int id;
    String name;
    int price = 1;
    Category category;
//    float discount = 1.0f;
    static final Product TEST_MOUSE = new Product("滑鼠", Category.CATEGORY_COMPUTER);
    static final Product TEST_PEN = new Product("鉛筆", Category.CATEGORY_LIFE);

    //建構子
    public Product() {
        super();
    }

    public Product(String name, Category category){
        this.name = name;
        this.category = category;
    }

    public Product(int id, Category category, String name, int price){
        this(id, name, price);
        this.category = category;
    }

    public Product(int id, String name, int price) {
        this(name, price);
        this.id = id;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static List<Product> getProductList() {
        List<Category> categories = Category.getCategories();
        List<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("data.txt");
            BufferedReader in = new BufferedReader(fileReader);
            String line = in.readLine();
            while (line != null){
//                System.out.println(line);
                //將讀到的資料放入list中
                Product product;
                String[] tokens = line.split(",");
                //collect data for product
                int id = Integer.parseInt(tokens[0]);
                //TODO: possible bug for index
                Category category = categories.get(Integer.parseInt(tokens[1])-1);
                String name = tokens[2];
                int price = Integer.parseInt(tokens[3]);
                //product object
                if (tokens.length > 4){
                    float discount = Float.parseFloat(tokens[4]);
                    product = new SalesProduct(id,category,name,price,discount);
                }else{
                    product = new Product(id,category,name,price);
                }
                //add to products list
                products.add(product);
                line = in.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    //方法
    void publish(){

    }


    public int getPrice(){
//        if (discount != 1.0f){
//            return (int)(price*discount);
//        }else return price;
        return price;
    }

    @Override
    public String toString() {
//        if (discount < 1.0f){
//            return id + "\t" + name + "\t" + (int)(price*discount);
//        }else{
//            return id + "\t" + name + "\t" + price;
//        }
        return id + "\t" + name + "\t" + getPrice();
    }

    //不用生出物件就能呼叫方法
    static public List<Product> getTestProduct(){
        List<Product> list = new ArrayList<>();
        list.add(Product.TEST_MOUSE);
        list.add(Product.TEST_PEN);
        return list;
    }
}
