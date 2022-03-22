package uke12.firkanter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Square extends Rectangle{

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height;
    }

    @Override
    public void setWidth(int width) {
        this.height = width;
        this.width = width;
    }

    public static void main(String[] args) {


        // Rectangle r = new Rectangle();
        Rectangle r = new Square();
        r.setHeight(5);
        r.setWidth(5);
        System.out.println(r.getArea());
        r.increaseWidthByOne();
        System.out.println(r.getArea());

        /**
         * Poenget med dette eksempelet er å se at arv ikke alltid er topp.
         * Et kvadrat er en undergruppe av et rektangel, så dermed burde en kunne
         * sette at Square arver Rectangel. Dette skaper derimot problemer hvis vi
         * har en metode IncreaseWidthByOne i Rectangle. Vi KAN ikke bare øke 
         * bredden med 1, siden dette bryter med hva et kvadrat er.
         * 
         * Liskovs substitusjonsprinsipp sier at hvis vi har en klasse Rectangle, og en
         * subklasse Square, så skal vi _alle_ steder der vi bruker Rectangle kunne sette
         * inn Square i stedet og få lik oppførsel. Som gjort øverst i main.
         * 
         * Les mer om prinsippet her:
         * https://en.wikipedia.org/wiki/Liskov_substitution_principle
         * 
         */
    }

}
