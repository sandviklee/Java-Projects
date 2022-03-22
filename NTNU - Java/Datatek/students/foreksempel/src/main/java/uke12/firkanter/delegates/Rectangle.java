package uke12.firkanter.delegates;

public class Rectangle implements IShape{

    float width, height;

    public Rectangle(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public float getArea() {
        return width*height;
    }

    @Override
    public void increaseWidthByOne() {  
        width+=1;
    }
    

}
