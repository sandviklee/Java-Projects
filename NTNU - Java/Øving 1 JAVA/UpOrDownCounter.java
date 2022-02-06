package stateandbehavior;

public class UpOrDownCounter {
    int start;
    int end;
    int counter;

    public UpOrDownCounter(int start, int end) {
        if (start == end) {
            throw new IllegalStateException("Cannot increment counter, when limit has been reached");
        }
        else {
            this.start = start;
            this.end = end;
            counter = start;
        }

    }

    public int getCounter() {
        return counter;
    }

    public boolean count() {
        if (start > end) {
            if (counter - 1 == end) {
                counter -= 1;
                return false;
            }
            else if (counter > end) {
                counter -= 1;
                return true;
            }
        }
        else if (start < end) {
            if (counter + 1 == end) {
                counter += 1;
                return false;
            }
            else if (counter < end) {
                counter += 1;
                return true;
            }
        }
        return false;
    }
        
    

    public static void main(String[] args) {
        UpOrDownCounter count = new UpOrDownCounter(1, 5);
        System.out.println(count.count());
        System.out.println(count.getCounter());
        System.out.println(count.count());
        System.out.println(count.getCounter());
        System.out.println(count.count());
        System.out.println(count.getCounter());
        System.out.println(count.count());
        System.out.println(count.getCounter());
        System.out.println(count.count());
        System.out.println(count.getCounter());
    }
}


