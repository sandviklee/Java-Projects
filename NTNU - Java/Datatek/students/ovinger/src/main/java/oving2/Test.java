package oving2;

import java.util.ArrayList;
import java.util.List;

import javafx.css.converter.StringConverter;

// public class Test {
//     public static void main(String args[])
//     {
//         String str = "Simon Sandvik Lee";
//         String[] arrOfStr = str.split(" ");
 
//         System.out.println(arrOfStr[0]);
//     }
// }


// public class Test {
//     private int tall;

//     public void setTall(int tall) {
//         this.tall = tall;
//     }

//     public String getTall() {
//         return String.valueOf(tall);
//     }

    
//     @Override
//     public String toString() {
//         return getTall();
//     }

//     public static void main(String[] args) {
//         Test c1 = new Test();
//         c1.setTall(10);
//         System.out.println(c1);
        
        

//     }
// }

public class Test {
    private String navn;
    private Test ektefelle;

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return this.navn;
    }

    public void setEktefelle(Test ektefelle) {
        this.ektefelle = ektefelle;
    }

    public Test getEktefelle() {
        return this.ektefelle;
    }

    public static void main(String[] args) {
        Test Person1 = new Test();
        Test Person2 = new Test();

        Person1.setNavn()
    }


}