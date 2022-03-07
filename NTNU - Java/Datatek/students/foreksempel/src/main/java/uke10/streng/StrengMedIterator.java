package uke10.streng;

import java.util.Iterator;

// Denne klassen er som kombinasjonen av Streng og StrengIterator.
public class StrengMedIterator implements Iterator<Character>{

    String streng;
    int pointer;

    public void setStreng(String streng) {
        this.streng = streng;
    }

    @Override
    public boolean hasNext() {
        return pointer < streng.length();
    }

    @Override
    public Character next() {
        char tmp = streng.charAt(pointer);
        pointer++;
        return tmp;
    }


    public static void main(String[] args) {
        StrengMedIterator foo = new StrengMedIterator();
        foo.setStreng("Hei på meg");

        while (foo.hasNext()) {
            char c = foo.next();
            System.out.println(c);
        }
    }
    
}
