package uke6.gift;

public class Person {
    
    String name;
    Person spouse;

    public Person(String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    public Person getSpouse() {
        return this.spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
        // Men jeg må vel også sette spouse sin spouse til this?
        // Det vil derimot kreve mye logikk.
        // Her har jeg laget et enkelt forsøk. Hva er feil?
        // try {
        //     Thread.sleep(100);
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // System.out.println("Satt "+this.getName()+" sin make til "+spouse.getName());
        // spouse.setSpouse(this);
    }
    
    public boolean isMarriedTo(Person person) {
        if (this.spouse == null) return false;
        return this.spouse.equals(person);
    }

    public static void main(String[] args) {
        Person person = new Person("Arnt");
        Person person2 = new Person("Bernt");
        System.out.println("Gift: "+person.isMarriedTo(person2));

        // Gifte
        person.setSpouse(person2);
        System.out.println("Arnt gift med Bernt: "+person.isMarriedTo(person2));
        System.out.println("Bernt gift med Arnt: "+person2.isMarriedTo(person));
        
        // koble motsatt
        System.out.println("\nGifter motsatt vei:");
        person2.setSpouse(person);
        System.out.println("Arnt gift med Bernt: "+person.isMarriedTo(person2));
        System.out.println("Bernt gift med Arnt: "+person2.isMarriedTo(person));

        System.out.println("\n...men egentlig burde jo logikken gjøres automatisk?");
    }
    


}
