package se.patrikbergman.java.casting;

class Animal {
    final String name;

    Animal(String name) {
        this.name = name;
    }

    void takeAShit() {
        System.out.printf("Animal %s is taking a shit", this.getName());
    }

    String getName() {
        return name;
    }
}
