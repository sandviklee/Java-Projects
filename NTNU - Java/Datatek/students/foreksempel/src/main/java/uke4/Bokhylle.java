package uke4;

import java.util.ArrayList;
import java.util.List;

public class Bokhylle {
    
    List<Bok> samling = new ArrayList<>();

    public void nyBok(Bok bok) {
        samling.add(bok);
    }

    public static void main(String[] args) {
        Bokhylle bokhylle = new Bokhylle();
        Bok bok1 = new Bok("Dad and me - a life story", 12);
        bokhylle.nyBok(bok1);
        
    }
    
    


}
