package se.patrikbergman.java.casting;

public class AnimalUtil {

    /** Up cast test **/
    static Animal getAnimalThatIsADog() {
        return new Dog("Brutus");
    }

    /** Up cast and set **/
    static void upCastToDogAndSetBreed(Animal animal, String breed) {
        if(animal instanceof Dog) {
            ((Dog) animal).setBreed(breed);
        }
    }
}
