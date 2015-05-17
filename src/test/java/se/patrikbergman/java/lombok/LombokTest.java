package se.patrikbergman.java.lombok;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static se.patrikbergman.java.lombok.Person.PersonBuilder;
public class LombokTest {

    @Test
    public void builder() {
        PersonBuilder personBuilder = Person.builder();
        personBuilder.age(45);
        personBuilder.name("Patrik");
        Person patrik = personBuilder.build();
        System.out.println(patrik);
    }

    @Test
    public void allArgsWithBuilder() {
        Person person = Person.of("Patrik", 45);
        System.out.println(person);
    }

    @Test
    public void data() {
        Animal animal = Animal.of("Fox", 5);
        assertEquals("Fox", animal.getName());
        assertEquals(5, animal.getAge());
        System.out.println(animal);
    }
}
