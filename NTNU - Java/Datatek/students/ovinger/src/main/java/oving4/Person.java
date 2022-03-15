package oving4;

import java.util.ArrayList;

public class Person {
    private char gender;
    private String name;
    private Person mum = null;
    private Person dad = null;
    private ArrayList<Person> children = new ArrayList<>();

    public Person(String name, char gender) {
        if (name != null) {
            this.name = name;
        } else throw new IllegalArgumentException("Not Viable name");

        if (gender == 'F' || gender == 'M') {
            this.gender = gender;
        } else throw new IllegalArgumentException("Not Viable gender");
    }

    public String getName() {
        return this.name;
    }

    public char getGender() {
        return this.gender;
    }

    public Person getMother() {
        return this.mum;
    }

    public Person getFather() {
        return this.dad;
    }

    public int getChildCount() {
        return children.size();
    }

    public Person getChild(int n) {
        try {
            return children.get(n);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Child number not available.");
        }
    }

    public void addChild(Person p) {
        if (this.getGender() == 'F') {
            if ((this != p.mum) && (p.mum != null)) {
                p.mum.children.remove(p);
            } 
            p.mum = this;
            this.children.add(p);
        
        } else {
            if ((this != p.dad) && (p.dad != null)) {
                p.dad.children.remove(p);
            } 
            p.dad = this;
            this.children.add(p);
        }
    }   

    public void removeChild(Person p) {
        if (this.getGender() == 'F') {
            this.children.remove(p);
            p.mum = null;
        } else {
            this.children.remove(p);
            p.dad = null;
        }
    }

    public void setMother(Person p) {
        if (p == null) {
            this.mum.children.remove(this);
            this.mum = p;
        }
        else if (p.getGender() == 'F') {
            if (p == this) {
                throw new IllegalArgumentException("Cannot be her own Mother");
            }
            if ((p != this.mum) && (this.mum != null)) {
                this.mum.children.remove(this);
            }
            this.mum = p;
            this.mum.children.add(this);
        } else throw new IllegalArgumentException("A male cannot be a mother.");
    }

    public void setFather(Person p) {
        if (p == null) {
            this.dad.children.remove(this);
            this.dad = p;
        }
        else if (p.getGender() == 'M') {
            if (p == this) {
                throw new IllegalArgumentException("Cannot be his own Father.");
            }
            if ((p != this.dad) && (this.dad != null)) {
                this.dad.children.remove(this);
            }
            this.dad = p;
            this.dad.children.add(this);
        } else throw new IllegalArgumentException("A female cannot be a father.");
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Person simon = new Person("Simon", 'M');
        Person frida = new Person("Frida", 'F');
        Person bjorn = new Person("Bjørn", 'M');
        Person sverre = new Person("Sverre", 'M');
    }
    

}
