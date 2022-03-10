package uke10.iteratorer;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomEvenNumber implements Iterator<Integer>{

    int counter;
    Random rand = new Random(); 


    @Override
    public boolean hasNext() {
        if (counter > 99) return false;
        return true;
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException("Bare 100 tall");

        counter ++;
        return rand.nextInt(100/2) * 2 + 1;
    }

    public static void main(String[] args) {
        Iterator<Integer> it = new RandomEvenNumber();

        for (int i = 0; i < 101; i++) {
            System.out.println(i+":"+it.next());
        }

        // Lager en ny en, siden den forrige ble brukt opp. Er jo bare 100 tall per gang!
        // it = new RandomEvenNumber();
        // while (it.hasNext())
        //     System.out.println(it.next());
    }
}