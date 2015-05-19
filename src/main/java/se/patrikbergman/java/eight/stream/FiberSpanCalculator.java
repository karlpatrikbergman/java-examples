package se.patrikbergman.java.eight.stream;

import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FiberSpanCalculator {

    private static final double MIN_FIBER_LENGTH = 0.5;

    /**
     * Parallel stream does not work!
     *
     * @param components a collection of components, some of them might be Fiber components
     * @return number of found Fiber components that meets criteria
     */
    final static CalcResult calculateFiberSpansPerSystem(final Collection<Component> components) {
        return components.stream()
            .reduce(
                new CalcResult.Builder().build(), //identity value, see java doc´
                calcFiberSpan::apply,
                addResult::apply
            );
    }

    final static List<CalcResult> calculateFiberSpansPerChannel(final Collection<Component> components, final int nrOfChannels) {
        return IntStream.range(0, nrOfChannels)
            .mapToObj(channelIndex ->
                            components.stream()
                                    .reduce(
                                            new CalcResult.Builder().build(),
                                            getFiberSpanCalcFunction(channelIndex),
                                            addResult::apply //Not used
                                    )
            ).collect(Collectors.toList());
    }

    /**
     * Calculates number fiber spans with regard to channels
     */
    final static BiFunction<CalcResult, Component, CalcResult> getFiberSpanCalcFunction(int channelIndex) {
        return (resultIn, component) -> {
            CalcResult.Builder resultOutBuilder = new CalcResult.Builder();
            resultOutBuilder.getFiberSpansList().addAll(resultIn.getFiberSpansList());

            if (channelIsDropped.apply(component, channelIndex)) {
                resultOutBuilder.getFiberSpansList().add(resultIn.numberOfFiberSpans);
            } else {
                resultOutBuilder.numberOfFiberSpans(resultIn.numberOfFiberSpans);
            }

            final Consumer<CalcResult.Builder> fiberSpanFound = (result) -> {
                result.addFiberSpan();
                result.previousComponentFiber(true);
                result.accumulatedDistance(0);
            };

            if (component instanceof Fiber) {
                final Fiber fiber = ((Fiber) component);
                if (!resultIn.previousComponentFiber) {
                    if (fiber.getDistance() >= 0.5) {
                        fiberSpanFound.accept(resultOutBuilder);
                    } else {
                        resultOutBuilder.accumulatedDistance(resultIn.accumulatedDistance + fiber.getDistance());
                        if (resultOutBuilder.getAccumulatedDistance() >= 0.5) {
                            fiberSpanFound.accept(resultOutBuilder);
                        }
                    }
                }
            }
            return resultOutBuilder.build();
        };
    }

    final static BiFunction<Component, Integer, Boolean> channelIsDropped = (component, channelIndex) ->
            (component instanceof AddDropComponent && ((AddDropComponent) component).isDropped(channelIndex));

    /**
     * Calculates number fiber spans regardless of channels
     */
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
    static BinaryOperator<CalcResult> addResult = (fiberCalcResult, fiberCalcResult2) -> new CalcResult.Builder()
            .accumulatedDistance(0)
            .previousComponentFiber(false)
            .numberOfFiberSpans(fiberCalcResult.numberOfFiberSpans + fiberCalcResult2.getNumberOfFiberSpans())
            .build();
}
