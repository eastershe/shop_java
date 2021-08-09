package com.kevin;

import java.util.List;

public class Tester {
    public static void main(String[] args) {

        //利用類別內的方法印出分類
         System.out.println("分類清單");
//        List<Category> categories = Category.getDummyCategories();
        List<Category> categories = Category.getCategories();
        for (Category category : categories) {
            System.out.println(category.name);
        }

        //利用類別內的方法印出測試產品
         System.out.println("\n測試產品清單");
        List<Product> products = Product.getTestProduct();
        for (Product product : products) {
            System.out.println("產品名稱:" + product.name + "\t分類:" + product.category.name);
        }

        //利用Reader讀取檔案的產品
        System.out.println("\n讀取data.txt後的產品清單");
        List<Product> productList = Product.getProductList();
        for (Product product : productList) {
            if (product instanceof SalesProduct){
                System.out.print("*");
            }
            System.out.println(product);
        }

        //使用list清單分類
        Product computer = new Product("電腦", categories.get(0));
        //使用catrgory常數定義分類
        Product phone = new Product("手機", Category.CATEGORY_COMPUTER);
        Product pen = new Product("筆", Category.CATEGORY_LIFE);

        //使用建構子new物件
        Product toothbrush = new Product(1,"牙刷",150);
        toothbrush.publish();
        //先new物件，再定義屬性
        Product mouse = new Product();
        mouse.id = 2;
        mouse.name = "滑鼠";
        mouse.price = 150;

        //OrderItem類別繼承Product
        OrderItem item = new OrderItem(mouse, 3);
        OrderItem item2 = new OrderItem(toothbrush);

    }
}
