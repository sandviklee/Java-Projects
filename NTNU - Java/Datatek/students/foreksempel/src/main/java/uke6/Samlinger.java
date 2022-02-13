package uke6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

// Vise at flere klasser implementerer behovene som Collection fyller.
public class Samlinger {
    
    public static void main(String[] args) {
        Collection<String> c1 = new ArrayList<>();
        c1.add("Hei");
        c1.add("på");
        c1.add("oss!");
        System.out.println(String.join(" ", c1));

        Collection<String> c2 = new HashSet<>(); // Implementerer Collection, men beholder ikke rekkefølge 
        c2.add("Hei");
        c2.add("på");
        c2.add("oss!");
        System.out.println(String.join(" ", c2));
        System.out.println(c2.toString()); // Hvilken toString er dette? Jo, Object. Vi har jo ikke laget noen egen.

    }   
    
}
