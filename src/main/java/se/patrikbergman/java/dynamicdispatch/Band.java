package se.patrikbergman.java.dynamicdispatch;

class Band {
    void rockOn() {
        System.out.printf("%s rocks on", Band.class.getSimpleName());
    }
}
