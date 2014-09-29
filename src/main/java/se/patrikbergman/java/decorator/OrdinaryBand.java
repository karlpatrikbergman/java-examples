package se.patrikbergman.java.decorator;

public class OrdinaryBand implements RockAct {
    private String name;
    private int rockFactor = 100;

    public OrdinaryBand(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRockFactor() {
        return rockFactor;
    }
}
