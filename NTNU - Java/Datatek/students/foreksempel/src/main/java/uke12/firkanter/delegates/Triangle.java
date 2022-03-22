package uke12.firkanter.delegates;

public class Triangle implements IShape{
    
    float width, height;

    public Triangle(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public float getArea() {
        return width*height/2;
    }

    @Override
    public void increaseWidthByOne() {  
        width+=1;
    }
}
