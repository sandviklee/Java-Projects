package uke4.fasit;

public class UsePerson {
    
    public static void main(String[] args) {

        // Person1 lagrer navnet som for- og etternavn, men vi kan skrive ut
        // hele navnet på en gang.
        Person1 p1 = new Person1("Jens Olav", "Olsen Dysvik");
        System.out.println(p1.getFullName());
        System.out.println(p1.getGivenName());

        // Person2 lagrer kun 'hele navnet' men vi kan hente ut for- og 
        // etternavn.
        Person2 p2 = new Person2("Jens Olav Olsen Dysvik");
        System.out.println(p2.getGivenName()+" "+p2.getFamilyName());
        System.out.println(p2.getGivenName());
    }
    
}
