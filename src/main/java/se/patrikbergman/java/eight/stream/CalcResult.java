package se.patrikbergman.java.eight.stream;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
class CalcResult {
    final boolean previousComponentFiber;
    final double accumulatedDistance;
    final int numberOfFiberSpans;
    final List<Integer> fiberSpansList;

    public final List<Integer> getTotalResult() {
        fiberSpansList.add(numberOfFiberSpans);
        return fiberSpansList;
    }

    private CalcResult(Builder builder) {
        previousComponentFiber = builder.previousComponentFiber;
        accumulatedDistance = builder.accumulatedDistance;
        numberOfFiberSpans = builder.numberOfFiberSpans;
        fiberSpansList = builder.fiberSpansList;
    }

    public static final class Builder {
        private boolean previousComponentFiber = false;
        private double accumulatedDistance = 0;
        private int numberOfFiberSpans = 0;
        private List<Integer> fiberSpansList = new ArrayList<>();


        public double getAccumulatedDistance() {
            return accumulatedDistance;
        }

        public int getNumberOfFiberSpans() {
            return numberOfFiberSpans;
        }

        public List<Integer> getFiberSpansList() {
            return fiberSpansList;
        }

        public void addFiberSpan() {
            this.numberOfFiberSpans++;
        }


        /** Builder setters **/

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

        public Builder fiberSpansList(List<Integer> fiberSpansList) {
            this.fiberSpansList = fiberSpansList;
            return this;
        }

        public CalcResult build() {
            return new CalcResult(this);
        }
    }
}
