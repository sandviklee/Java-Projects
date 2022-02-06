package uke3.fasit;

public class Counter {
    
    int end;
    int counter;

    public Counter(int end) {
        this.end = end;
        counter = 1;
    }

    public int getCounter() {
        return counter;
    }

    public boolean count() {
        if (counter < end) {
            counter++;
        }
        return ((counter == end) ? true:false);
    }

    /**
     * 
     * @param inc Hvor mye vi skal øke Counter med
     * @return true hvis vi fikk gå opp til eller var på end, false ellers
     */
    public boolean count(int inc) {
        if (counter + inc <= end) {
            counter+=inc;
        }
        return counter >= end ? true:false;
    }

    public static void main(String[] args) {
        Counter counter = new Counter(3);
        System.out.println("getcounter: "+counter.getCounter());
        System.out.println("count: "+counter.count());
        System.out.println("getcounter: "+counter.getCounter());
        System.out.println("count: "+counter.count());
        System.out.println("getcounter: "+counter.getCounter());
        System.out.println("count: "+counter.count());
        System.out.println("getcounter: "+counter.getCounter());
        System.out.println("count: "+counter.count()); 
        
        System.out.println("Gå opp med mer enn 1...");
        counter = new Counter(4);
        System.out.println("getcounter: "+counter.getCounter());
        System.out.println("count 2: "+counter.count(2)); // Fremdeles ikke på 
        System.out.println("getcounter: "+counter.getCounter());
        System.out.println("count 100: "+counter.count(100)); // Ikke lov, så fremdeles ikke på end 
        System.out.println("getcounter: "+counter.getCounter());
        System.out.println("count: "+counter.count()); // Øker til end, så true 
        System.out.println("getcounter: "+counter.getCounter()); // 4 som er end.


    }
}
