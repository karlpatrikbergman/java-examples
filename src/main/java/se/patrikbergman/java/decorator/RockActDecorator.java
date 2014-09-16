package se.patrikbergman.java.decorator;

public class RockActDecorator implements RockAct {
    private final Band band;

    private RockActDecorator(Builder builder) {
        band = builder.band;
    }

    @Override
    public String getName() {
        return band.getName();
    }

    @Override
    public int rockFactor() {
        return 0;
    }

    public static final class Builder {
        private Band band;

        public Builder() {
        }

        public Builder band(Band band) {
            this.band = band;
            return this;
        }

        public RockActDecorator build() {
            return new RockActDecorator(this);
        }
    }
}
