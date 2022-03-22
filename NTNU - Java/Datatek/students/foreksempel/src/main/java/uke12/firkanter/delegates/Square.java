package uke12.firkanter.delegates;

public class Square implements IShape {
    
    float width;

    

    public Square(float width) {
        this.width = width;
    }

    @Override
    public float getArea() {
        return width*width;
    }

    @Override
    public void increaseWidthByOne() {
        width+=1;
    }
}
