package stateandbehavior;

public class Rectangle {

    // Can also be solved by storing a point (x, y), height and width
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

    public int getWidth() {
        return this.maxX - this.minX;
    }

    public int getHeight() {
        return this.maxY - this.minY;
    }

    public int getMinX() {
        return this.minX;
    }

    public int getMinY() {
        return this.minY;
    }

    public int getMaxX() {
        return this.maxX;
    }

    public int getMaxY() {
        return this.maxY;
    }

    public boolean isEmpty() {
        // Any rectangle that has a width or height of 0 is empty
        return this.getWidth() == 0 || this.getHeight() == 0;
    }

    public boolean contains(int x, int y) {
        // Make sure that the given x is in the range minX -> maxX and y in range minY
        // -> maxY (Inclusive)
        return !this.isEmpty()
                && x >= this.getMinX()
                && y >= this.getMinY()
                && x <= this.getMaxX()
                && y <= this.getMaxY();
    }

    public boolean contains(Rectangle other) {
        // This rectangle must contain both min and max points for the other rectangle
        // if this rectangle contains
        // the entire other rectangle
        return this.contains(other.getMinX(), other.getMinY())
                && this.contains(other.getMaxX(), other.getMaxY());
    }

    public boolean add(int x, int y) {
        // If (x, y) is already in this rectangle we don't need to do anything
        if (this.contains(x, y)) {
            return false;
        }

        boolean changed = false;
        if (this.maxX < x) {
            this.maxX = x;
            changed = true;
        } else if (this.minX > x) {
            this.minX = x;
            changed = true;
        }

        if (this.maxY < y) {
            this.maxY = y;
            changed = true;
        } else if (this.minY > y) {
            this.minY = y;
            changed = true;
        }

        return changed;
    }

    public boolean add(Rectangle other) {
        if (other.isEmpty()) {
            return false;
        }

        return this.add(other.getMinX(), other.getMinY()) || this.add(other.getMaxX(), other.getMaxY());

        /*
         * Can also be written as
         * boolean changed1 = add(other.getMinX(), other.getMinY());
         * boolean changed2 = add(other.getMaxX(), other.getMaxY());
         * return changed1 || changed2;
         */
    }

    public Rectangle union(Rectangle rect) {
        int minX = Math.min(this.getMinX(), rect.getMinX());
        int minY = Math.min(this.getMinY(), rect.getMinY());
        int maxX = Math.max(this.getMaxX(), rect.getMaxX());
        int maxY = Math.max(this.getMaxY(), rect.getMaxY());
        return new Rectangle(minX, minY, maxX, maxY);
    }

    public Rectangle intersection(Rectangle rect) {
        int minX = Math.max(getMinX(), rect.getMinX());
        int minY = Math.max(getMinY(), rect.getMinY());
        int maxX = Math.min(getMaxX(), rect.getMaxX());
        int maxY = Math.min(getMaxY(), rect.getMaxY());

        Rectangle intersection;
        if (minX < maxX && minY < maxY) {
            intersection = new Rectangle(minX, minY, maxX, maxY);
        } else {
            intersection = null;
        }

        return intersection;
    }

    public boolean intersects(Rectangle rect) {
        return this.intersection(rect) != null;
    }

    @Override
    public String toString() {
        return String.format("[Rectangle %s-%s,%s-%s %sx%s]", getMinX(), getMaxX(), getMinY(), getMaxY(), getWidth(),
                getHeight());
    }
}
