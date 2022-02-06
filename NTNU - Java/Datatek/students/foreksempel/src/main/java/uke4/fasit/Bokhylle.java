package uke4.fasit;

import java.util.ArrayList;
import java.util.List;


/**
 * Klassen Bokhylle skal kunne lagre flere bøker.
 * Den er ikke tenkt å gjøre masse fine saker, kun minimum for å vise at
 * en kan legge til bøker i en samling av type Collection og skrive ut
 * status for hver av dem. 
 */

public class Bokhylle {

    // Vi vil lagre flere bøker!
    List<Bok> samling;

    // List<Bok> samling = new ArrayList<>();

    public Bokhylle() {
        samling = new ArrayList<>();
        // Vi kunne ha initiert den der vi definerte samling, se utkommentert kode over. 
    }

    public void addBok(Bok bok) {
        samling.add(bok);
    }

    public void skrivStatus() {
        for (Bok bok : samling) {
            System.out.println(bok);
        }
    }

    Bok hentBok(int plass){
        if (plass < samling.size()) {
            return samling.get(plass);
        }
        System.out.println("For få bøker. Du får den første.");
        return samling.get(0);
    }
    
    public static void main(String[] args) {
        Bokhylle bokhylle = new Bokhylle();
        Bok en = new Bok("Don Quijote", 354);
        bokhylle.addBok(en);
        Bok to = new Bok("Das Kapital", 701);
        bokhylle.addBok(to);
        en.lest(33);
        to.lest(432); // Sett inn et 'breakpoint' her, kjør debug, og utforsk bokhylle!
        bokhylle.skrivStatus();
        Bok hentet = bokhylle.hentBok(1);
        System.out.println(hentet);
        hentet.lest(3);
        System.out.println(hentet);
    }    

    	/* Dette må du installere PlantUML for å kunne lese. Bruker på forelesning.
@startuml

class Bokhylle {
  __ private data __
  - Collection<Bok> samling
  .. Konstruktører ..
  + Bokhylle()
  .. Metoder ..
  + lest(Bok bok)
  + skrivStatus()
}

@enduml

	*/

}
