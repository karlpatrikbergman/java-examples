package se.patrikbergman.java.decorator;

public class Band implements RockAct {
    private final String name;
    private final int rockFactor;

    private Band(Builder builder) {
        name = builder.name;
        rockFactor = builder.rockFactor;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int rockFactor() {
        return rockFactor;
    }


    public static final class Builder {
        private String name;
        private int rockFactor;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder rockFactor(int rockFactor) {
            this.rockFactor = rockFactor;
            return this;
        }

        public Band build() {
            return new Band(this);
        }
    }
}
