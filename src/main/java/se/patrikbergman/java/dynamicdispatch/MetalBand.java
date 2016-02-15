package se.patrikbergman.java.dynamicdispatch;

class MetalBand extends RockBand{

    @Override
    void rockOn() {
        System.out.printf("%s rocks on", MetalBand.class.getSimpleName());
    }
}
