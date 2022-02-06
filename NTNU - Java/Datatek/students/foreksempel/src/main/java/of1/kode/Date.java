package of1.kode;

import java.util.ArrayList;
import java.util.List;

public class Date {

    // Hjelpefunksjon som sier om et år er skuddår eller ikke
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 400 == 0 || year % 100 != 0));
    }

    private ArrayList<Integer> longMonths = new ArrayList<>(List.of(1, 3, 5, 7, 8, 10, 12)); // Months of 31 days
    private ArrayList<Integer> shortMonths = new ArrayList<>(List.of(4, 6, 9, 11)); // Months of 30 days (notice that
                                                                                    // February is missing)

    /*
     * Oppgave a)
     * Date-klassen skal ha mulighet for å lese og endre informasjon om dag, måned
     * og år
     */

    /*
     * Oppgave b)
     * Implementér metoder for å endre datoen til neste og forrige dag.
     */

    public static void main(String[] args) {

    }
}
