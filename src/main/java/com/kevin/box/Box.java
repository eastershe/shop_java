package com.kevin.box;
// Box1 10,10,10
// Box2 15,10,10
// ...
// if 12,10,10 -> which box?
public class Box {
    int length;
    int height;
    int width;
    String name;

    public Box(int length, int height, int width) {
        this.length = length;
        this.height = height;
        this.width = width;
    }

    public boolean validate(int length, int width, int height){
        // TODO: order by size

        return length <= this.length && width <= this.width && height <= this.height;
    }
}
