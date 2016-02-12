package se.patrikbergman.java.casting;

class Dog extends Animal {

    String breed;

    Dog(String name) {
        super(name);
    }

    void bark() {
        System.out.printf("Dog %s is barking", this.getName());
    }

    String getBreed() {
        return breed;
    }

    void setBreed(String breed) {
        this.breed = breed;
    }
}
