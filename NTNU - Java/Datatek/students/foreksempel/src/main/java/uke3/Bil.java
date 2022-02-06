package uke3;

/**
 * Denne klassen (og Eier) ble skrevet etter forelesning for å vise hvorfor 
 * en ikke bør venne seg til å bruke bil.regnr = "AA41383", men i stedet 
 * bil.setRegnr("AA41383"). Det kan nemlig hende at en ønsker å ha en kontroll
 * av det som kommer inn, og ikke bare ta alt for god fisk.
 * 
 */

public class Bil {

    private String regnr;
    private String type;

    public String getRegnr() {
        return regnr;
    }
    public void setRegnr(String regnr) {

        // Er lengden på strengen 7?
        if (regnr.length() == 7)
            this.regnr = regnr;

        // Nå kan en ikke sette registreringsnummer hvis de ikke er 7 tegn.
        // Det finnes selvfølgelig flere sjekker en må gjøre for å tillate
        // regnr, men dette er prinsippet.
        // Hvis ikke 87, gjør ikkeno. Vi skal senere se hvordan en kan
        // gjøre noe mer vettugt hvis noen forsøker å sette et objekt til en
        // tilstand som skal være umulig - eksempelvis å utløse unntak.  
    }

    public String getType() {
        return type;
    }

    // Dette er jo galskap, mann!
    // Man kan ikke gjøre om en Peugeot 5008 til en Toyota Rav4. Men her kan vi...
    public void setType(String type) {
        this.type = type; // this.type er type på bunnarket til objektet
                          // type er på arket til metoden setType.    
    }
    
    // I denne konstruktøren setter vi type med en gang.
    public Bil(String type) {
        this.type = type;
    }

    // Jeg viste at en kunne ha flere konstruktører. Og, hvis en definerer en,
    // da forsvinner den automatiske som ser omtrent slik ut:
    // Denne konstruktøren lager et bilobjekt der både type og regnr peker på null.
    public Bil() {
    }


    public static void main(String[] args) {
        Bil bil1 = new Bil();
        bil1.setRegnr("AA41383");
        bil1.setType("Folkevognbuss fra syttitallet.");
        System.out.println("Bil1 regnr: "+bil1.getRegnr());
        System.out.println("Bil1 type: "+bil1.getType());

        Bil bil2 = new Bil("Toyota Rav4");
        System.out.println("Bil2 type: "+bil2.getType());
        bil2.setRegnr("VH99999");
        System.out.println("Bil2 regnr: "+bil2.getRegnr());
        bil2.setRegnr("Et alt for langt bilnummer"); // For langt!
        System.out.println("Bil2 regnr: "+bil2.getRegnr()); // Fortsatt gammelt.
    }
    
}
