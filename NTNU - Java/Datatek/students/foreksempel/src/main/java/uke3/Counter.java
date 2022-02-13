package uke3;

public class Counter {
    
    private int end;
    public int counter;

    public int getCounter() {
        return this.counter;
    }

    public boolean count() {
        if (counter < end ){
            counter++;
        }
        return ((counter == end) ? true:false);
    }

    public boolean count(int n) {
        if (counter + n <= end ){
            counter += n;
        // }        return ((counter == end) ? true:false);

        if (counter == end)
            return true;
        return false;
        
        
    }

    public Counter(int end) {
        this.end = end;
        this.counter = 1;
    }


    public static void main(String[] args) {
        Counter counter = new Counter(3);
        // System.out.println("getcounter: "+counter.getCounter());
        // System.out.println("count: "+counter.count());
        // System.out.println("getcounter: "+counter.getCounter());
        // System.out.println("count: "+counter.count());
        // System.out.println("getcounter: "+counter.getCounter());
        // System.out.println("count: "+counter.count());
        // System.out.println("getcounter: "+counter.getCounter());
        // System.out.println("count: "+counter.count()); 

        Counter counter2 = new Counter(3);
        System.out.println("getcounter: "+counter2.getCounter());
        System.out.println("count: "+counter2.count(1));
        System.out.println("getcounter: "+counter2.getCounter());
        System.out.println("count: "+counter2.count(100));
        System.out.println("getcounter: "+counter2.getCounter());
        System.out.println("count: "+counter2.count(1));
        System.out.println("getcounter: "+counter2.getCounter());
        System.out.println("count: "+counter2.count(1));
        counter2.counter = 1000;
        System.out.println("getcounter: "+counter2.getCounter());
        System.out.println("count: "+counter2.count(1));



    }
    
}
