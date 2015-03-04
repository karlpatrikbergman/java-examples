package se.patrikbergman.java.pattern.decorator;

class HeavyMetalBand extends RockActDecorator {


    public HeavyMetalBand(OrdinaryBand ordinaryBand) {
        super(ordinaryBand);
    }

    @Override
    public String getName() {
        return ordinaryBand.getName();
    }

    @Override
    public int getRockFactor() {
        return ordinaryBand.getRockFactor() + 1000;
    }
}
