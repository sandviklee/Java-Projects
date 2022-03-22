package uke12.firkanter;

public class Rectangle {
    
    int width, height;

    int getArea() {
        return width*height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    void increaseWidthByOne() {
        this.setWidth(this.getWidth()+1);
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.setHeight(5);
        r.setWidth(5);
        System.out.println(r.getArea());
        r.increaseWidthByOne();
        System.out.println(r.getArea());
    }
}
