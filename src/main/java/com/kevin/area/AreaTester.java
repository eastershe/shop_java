package com.kevin.area;

import java.util.ArrayList;
import java.util.List;

public class AreaTester {
    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(50,50));
        shapes.add(new Triangle(50,50));

        //直接實作介面物件
        float r = 10f;
        Shape circle = new Shape() {
            @Override
            public float getArea() {
                return 10*10*3.14f;
            }
        };
        shapes.add(circle);

        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
        }
    }
}
