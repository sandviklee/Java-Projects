package uke2;

public class KaffeMater {

    public void serverKaffe(Person person) {
        while (person.nokKaffe() == false) {
            System.out.println("KaffeMater mater "+person.getNavn());
            person.drikkKaffe();
        }
    }

    public KaffeMater() {
        System.out.println("Vi lager en KM!");
    }

    public static void main(String[] args) {
        KaffeMater kaffeMater = new KaffeMater();

        Person person = new Person("Bernt");
        System.out.println("Nok kaffe: "+person.nokKaffe());
        kaffeMater.serverKaffe(person);
        System.out.println("Nok kaffe: "+person.nokKaffe());

    }
    
    
}
