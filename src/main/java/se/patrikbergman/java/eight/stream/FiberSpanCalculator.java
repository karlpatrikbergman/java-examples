package se.patrikbergman.java.eight.stream;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

class FiberSpanCalculator {

    private static final double MIN_FIBER_LENGTH = 0.5;

    /**
     * Parallel stream does not work!
     *
     * @param components a collection of components, some of them might be Fiber components
     * @return number of found Fiber components that meets criteria
     */
    static CalcResult calculateNumberOfFiberSpans(final Collection<Component> components) {
        return components.stream()
                .reduce(new CalcResult.Builder() //identity value, see java doc
                                .accumulatedDistance(0)
                                .previousComponentFiber(false)
                                .numberOfFiberSpans(0)
                                .build(),
                        calcFiberSpan::apply,
                        addResult::apply
                );
    }


    static final BiFunction<CalcResult, Component, CalcResult> calcFiberSpan = (resultIn, component) -> {

        final Consumer<CalcResult.Builder> fiberSpanFound = (result) -> {
            result.addFiberSpan();
            result.previousComponentFiber(true);
            result.accumulatedDistance(0);
        };

        CalcResult.Builder resultOutBuilder = new CalcResult.Builder();
        resultOutBuilder.numberOfFiberSpans(resultIn.numberOfFiberSpans);

        if (component instanceof Fiber) {
            final Fiber fiber = ((Fiber) component);
            if (!resultIn.previousComponentFiber) {
                if (fiber.getDistance() >= MIN_FIBER_LENGTH) {
                    fiberSpanFound.accept(resultOutBuilder);
                } else {
                    resultOutBuilder.accumulatedDistance(resultIn.accumulatedDistance + fiber.getDistance());
                    if (resultOutBuilder.getAccumulatedDistance() >= MIN_FIBER_LENGTH) {
                        fiberSpanFound.accept(resultOutBuilder);
                    }
                }
            }
        }
        return resultOutBuilder.build();
    };


    /**
     * Only active when using parallelStream(), and parallelStream() does not work when calculating fiber spans, since
     * calculation order matters
     */
    private static final BinaryOperator<CalcResult> addResult = (fiberCalcResult, fiberCalcResult2) -> new CalcResult.Builder()
            .accumulatedDistance(0)
            .previousComponentFiber(false)
            .numberOfFiberSpans(fiberCalcResult.numberOfFiberSpans + fiberCalcResult2.getNumberOfFiberSpans())
            .build();
}
