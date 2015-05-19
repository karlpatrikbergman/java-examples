package se.patrikbergman.java.eight.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FiberSpansPerChannelTest {

    private List<Component> components;
    private final Set<Integer> droppedChannels = new HashSet<>();

    @Before
    public void setup() {

        droppedChannels.addAll(Arrays.asList(1));
        components = Arrays.asList(
                new Mux(),
                new Fiber(2.0), //1
                new OA(),
                new Fiber(0.1), //1
                new OA(),
                new Fiber(0.3),
                new Fiber(0.3), //2
                new OA(),
                new Fiber(2.0), //3
                new AddDropComponent(droppedChannels),
                new Fiber(2.0), //1
                new OA(),
                new Fiber(2.0), //2
                new DeMux()
        );

    }

    @Test
    public void calculateFiberSpansPerChannel() {

        IntStream.range(0, 2)
            .mapToObj(channelIndex ->
                components.stream()
                    .reduce(
                            new CalcResult.Builder().build(),
                            getFiberSpanCalcFunction(channelIndex),
                            addResult::apply //Not used
                    )
            )
            .collect(Collectors .toList())
            .stream()
            .forEach(calcResult -> System.out.println(calcResult.getTotalResult()));
    }

    private BiFunction<CalcResult, Component, CalcResult> getFiberSpanCalcFunction(int channelIndex) {

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


    BiFunction<Component, Integer, Boolean> channelIsDropped = (component, channelIndex) ->
            (component instanceof AddDropComponent && ((AddDropComponent) component).isDropped(channelIndex));

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
