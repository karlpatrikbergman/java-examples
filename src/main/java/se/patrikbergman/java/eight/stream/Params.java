package se.patrikbergman.java.eight.stream;

import lombok.Data;

@Data
public class Params {
    final boolean previousComponentFiber;
    final double accumulatedDistance;
    final int numberOfFiberSpans;

    private Params(Builder builder) {
        previousComponentFiber = builder.previousComponentFiber;
        accumulatedDistance = builder.accumulatedDistance;
        numberOfFiberSpans = builder.numberOfFiberSpans;
    }

    public static final class Builder {
        private boolean previousComponentFiber;
        private double accumulatedDistance;
        private int numberOfFiberSpans;

        public double getAccumulatedDistance() {
            return accumulatedDistance;
        }

        public int getNumberOfFiberSpans() {
            return numberOfFiberSpans;
        }

        public Builder() {
        }

        public Builder previousComponentFiber(boolean previousComponentFiber) {
            this.previousComponentFiber = previousComponentFiber;
            return this;
        }

        public Builder accumulatedDistance(double accumulatedDistance) {
            this.accumulatedDistance = accumulatedDistance;
            return this;
        }

        public Builder numberOfFiberSpans(int numberOfFiberSpans) {
            this.numberOfFiberSpans = numberOfFiberSpans;
            return this;
        }

        public Params build() {
            return new Params(this);
        }
    }
}
