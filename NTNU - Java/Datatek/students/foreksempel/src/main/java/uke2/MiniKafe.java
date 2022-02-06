package uke2;

public class MiniKafe {
    
    Person person;
    KaffeMater kaffeMater;

    public MiniKafe() {
        this.kaffeMater = new KaffeMater();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void serverPerson() {
        if (this.person != null){
            this.kaffeMater.serverKaffe(this.person);
        }

    }
    
    public static void main(String[] args) {
        MiniKafe mk = new MiniKafe();
        mk.serverPerson();
        Person person = new Person("Ada");
        mk.setPerson(person);
        mk.serverPerson();
        Person person2 = new Person("Børge");
        mk.setPerson(person2);
        mk.serverPerson();

    }
    
}
