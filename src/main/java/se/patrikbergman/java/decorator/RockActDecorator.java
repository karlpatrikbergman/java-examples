package se.patrikbergman.java.decorator;

abstract class RockActDecorator implements RockAct {
    protected OrdinaryBand ordinaryBand;

    public RockActDecorator(OrdinaryBand ordinaryBand) {
        this.ordinaryBand = ordinaryBand;
    }
}
