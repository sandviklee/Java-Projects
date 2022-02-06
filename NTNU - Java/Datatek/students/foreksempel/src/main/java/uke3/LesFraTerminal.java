package uke3;

import java.util.Scanner;  // Import the Scanner class

/**
 * Denne klassen er laget for å vise dere kjapt hvordan en kan få input fra
 * brukeren. Det er ikke nødvendig å sette seg ned og forstå ting, men tenkte
 * uansett at dere sikkert lurte.
 * Husk at dere må endre slik at programmet kjøres fra terminal, og ikke i
 * debugvinduet. Åpne settings.json-filen i prosjektet og endre 
 * "internalConsole" til "integratedTerminal" for java.debug.settings.console.
 */
public class LesFraTerminal {

      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Hva heter du: ");
    
        String navn = scanner.nextLine();  // Read user input
        scanner.close(); // Man bør stenge strømmer når man ikke bruker det, som prinsipp

        String sub;
        // Man kunne skrevet det på den korte måten:
        if (navn.contains("e")) {
            sub = "";
        }
        else {
            sub = "ikke";
        }
        // Man kunne skrevet det på en kort måte (nå gjør vi det to ganger)
        sub = navn.contains("e") ? "":" ikke"; // En kort variant av if

        System.out.println("Navnet "+navn+" er " + navn.length()+
        " tegn og inneholder"+sub+" en e.");  // Output user input
      }

}
