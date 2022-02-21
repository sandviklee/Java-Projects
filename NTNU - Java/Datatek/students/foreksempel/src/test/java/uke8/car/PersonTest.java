package uke8.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonTest {
    

    @Test
    public void defaultConstructorValues() {
        Person person = new Person();
        assertEquals("Wanda", person.getName());
        assertEquals(33, person.getAge());
    }

    @Test
    public void constructorDefaultAge() {
        Person person = new Person("Jens");
        assertEquals("Jens", person.getName());
        assertEquals(33, person.getAge());
    }

    @Test
    public void constructorAllNew() {
        Person person = new Person("Jens",23);
        assertEquals("Jens", person.getName());
        assertEquals(23, person.getAge());
    }

    
}
