package se.patrikbergman.java.eight.stream;

import lombok.Data;

@Data
public class CalcResult {
    final boolean previousComponentFiber;
    final double accumulatedDistance;
    final int numberOfFiberSpans;

    private CalcResult(Builder builder) {
        previousComponentFiber = builder.previousComponentFiber;
        accumulatedDistance = builder.accumulatedDistance;
        numberOfFiberSpans = builder.numberOfFiberSpans;
    }

    public static final class Builder {
        private boolean previousComponentFiber = false;
        private double accumulatedDistance = 0;
        private int numberOfFiberSpans = 0;

        public double getAccumulatedDistance() {
            return accumulatedDistance;
        }

        public int getNumberOfFiberSpans() {
            return numberOfFiberSpans;
        }

        public void addFiberSpan() {
            this.numberOfFiberSpans++;
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

        public CalcResult build() {
            return new CalcResult(this);
        }
    }
}
