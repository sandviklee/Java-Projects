package stateandbehavior;

public class Rectangle {
    int minX;
    int minY;
    int maxX;
    int maxY;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.minX = Math.min(x1, x2);
        this.minY = Math.min(y1, y2);
        this.maxX = Math.max(x1, x2);
        this.maxY = Math.max(y1, y2);
    }

    public int getMinX() {
        return minX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getWidth() {
        return getMaxX() - getMinX();
    }

    public int getHeight() {
        return getMaxY() - getMinY();
    }

    public boolean isEmpty() {
        return (getWidth() == 0 || getHeight() == 0);
    } 

    public boolean contains(int x, int y) {        
        return !isEmpty() && (getMaxX() >= x && getMinX() <= x) && (getMaxY() >= y && getMinX() <= y);
    } 

    public boolean contains(Rectangle rect) {
        return (contains(rect.minX, rect.minY) && (contains(rect.maxX, rect.maxY))); 
    }

    public boolean add(int x, int y) {
        // If x or y is larger than the current rect, the current rect enlarges with new x and y. 
        if ((getMaxX() < x || getMaxY() < y) || (getMinX() > x || getMinY() > y)) {
            minX = Math.min(getMinX(), x);
            minY = Math.min(getMinY(), y);
            maxX = Math.max(getMaxX(), x);
            maxY = Math.max(getMaxY(), y);
            return true;
        }
        else return false;
    }

    public boolean add(Rectangle rect) {
        if ((rect.getMaxX() < maxX || rect.getMaxY() < maxY) || (rect.getMinX() > minX || rect.getMinY() > minY)) {
            minX = Math.min(rect.getMinX(), minX);
            minY = Math.min(rect.getMinY(), minY);
            maxX = Math.max(rect.getMaxX(), maxX);
            maxY = Math.max(rect.getMaxY(), maxY);
            return true;
        }
        else return false;
    }

    public Rectangle union(Rectangle rect) {
        Rectangle newRect = new Rectangle(minX, minY, maxX, maxY);
        newRect.add(rect);
        return newRect;
    }

    public static void main(String[] args) {
        Rectangle rec = new Rectangle(0, 0, 7, 7);
        Rectangle rec2 = new Rectangle(1, 5, 3, 7);
        rec.contains(rec2);
        System.out.println(rec.getMinX());
        System.out.println(rec.contains(rec2));
        // rec.add(6, 5);
        // System.out.println(rec.getMaxX());
    }

    

}
