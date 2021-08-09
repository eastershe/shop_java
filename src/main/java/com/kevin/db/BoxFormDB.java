package com.kevin.db;

public class BoxFormDB {
    int id;
    String name;
    int length;
    int width;
    int height;
    int price;

    public BoxFormDB(int id, String name, int length, int width, int height, int price) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.price = price;
    }

    public boolean validate(int length, int width, int height){
        return length<=this.length && width<=this.width && height<= this.height;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + length + "x" + width + "x" + height + "\t" + price + "元";
    }
}
