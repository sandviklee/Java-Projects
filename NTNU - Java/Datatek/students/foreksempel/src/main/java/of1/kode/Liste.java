package of1.kode;

import java.util.ArrayList;
import java.util.List;

// Eksempel på bruk av ArrayList og arrays
public class Liste {
    public static void main(String[] args) {

        int[] heltallsArray = { 1, 2, 3 };
        String[] stringArray = { "Hei", "På", "Dei" };

        for (int i = 0; i < stringArray.length; i = i + 1) {
            System.out.println(stringArray[i]);
        }

        for (String string : stringArray) {
            System.out.println(string);
        }

        ArrayList<Integer> liste1 = new ArrayList<>(); // Tom liste

        System.out.println(liste1);
        liste1.add(1);
        liste1.add(2);

        System.out.println(liste1);

        ArrayList<Integer> liste2 = new ArrayList<>(List.of(1, 2, 3, 4)); // En liste med elementer i fra start

        System.out.println(liste1.contains(3));
        System.out.println(liste2.contains(3));

        liste1.remove(1);
        System.out.println(liste1);
        System.out.println(liste2.get(3)); // hente element på index 3

    }

}
