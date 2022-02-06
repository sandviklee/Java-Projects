package uke2.fasit;

// En kafé som har plass til én person.
// Vi har en KaffeMater, som serverer kaffe helt til kunden er fornøyd.
public class MiniKafé {
    
    Person person;
    KaffePusher km;
    
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    public void serverPerson() {
        if (this.person != null) // Hvis ingen er i kaféen kan ingen drikke!
            km.serverKaffe(this.person);
    }

    /**
     * Konstruktøren - det som bestemmer hvordan objekter av typen MiniKafé skal lages.
     * Vi har ikke noen kunder når vi starter, men vi har i alle fall en KaffePusher!
     */
    public MiniKafé() {
        this.km = new KaffePusher();
    }

    public static void main(String[] args) {
        System.out.println("Inni main i MiniKafé");
        MiniKafé mk = new MiniKafé();
        mk.serverPerson();
        mk.setPerson(new Person("Ada")); // Første kunde!
        mk.serverPerson();
        mk.setPerson(new Person("Per")); // Ny kunde!
        mk.serverPerson();
    }
    


}
