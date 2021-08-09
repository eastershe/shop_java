package com.kevin.box;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoxTester {
    public static void main(String[] args) {
        int length = 12;
        int width = 10;
        int height = 12;

//        List<Box> boxes = new ArrayList<>();
//        boxes.add(new Box1());
//        boxes.add(new Box2());
        List<Box> boxes = Arrays.asList(
                new Box1(),
                new Box2(),
                new Box3()
        );
        boolean matched = false;

        for (Box box : boxes) {
            if (box.validate(length,width,height)){
                System.out.println("Please choose " + box.name);
                matched = true;
                break;
            }
        }

        if (!matched){
            System.out.println("No box for your object.");
        }

    }
}
