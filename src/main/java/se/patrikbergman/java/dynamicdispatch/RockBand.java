package se.patrikbergman.java.dynamicdispatch;

class RockBand extends Band{

    @Override
    void rockOn() {
        System.out.printf("%s rocks on", RockBand.class.getSimpleName());
    }
}
