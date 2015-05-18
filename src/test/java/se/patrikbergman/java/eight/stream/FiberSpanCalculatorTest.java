package se.patrikbergman.java.eight.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FiberSpanCalculatorTest {

    private final List<Component> components = Arrays.asList(
            new Mux(),
            new Fiber(0.4),
            new OA(),
            new Fiber(2.0),
            new OA(),
            new Fiber(1.3),
            new OA(),
            new Fiber(4.3),
            new OA(),
            new Fiber(3.9),
            new OA(),
            new Fiber(0.3),
            new OA(),
            new Fiber(0.3),
            new OA(),
            new Fiber(9.4),
            new DeMux()
    );

    /**
     * Tests only BiConsumer method
     */
    @Test
    public void calculateNrOfFiberSpansForSingleFiberComponent() {
        final CalcResult calcResult = FiberSpanCalculator.calcFiberSpan.apply(
                new CalcResult.Builder()
                        .accumulatedDistance(0)
                        .numberOfFiberSpans(0)
                        .previousComponentFiber(false)
                        .build(),
                new Fiber(1)
        );
        assertEquals(1, calcResult.numberOfFiberSpans);
    }

    /**
     * Tests only BiConsumer method
     */
    @Test
    public void calculateNrOfFiberSpansForSingleMuxComponent() {
        final CalcResult calcResult = FiberSpanCalculator.calcFiberSpan.apply(
                new CalcResult.Builder()
                        .accumulatedDistance(0)
                        .numberOfFiberSpans(0)
                        .previousComponentFiber(false)
                        .build(),
                new Mux()
        );
        assertEquals(0, calcResult.numberOfFiberSpans);
    }

    @Test
    public void calculateFiberSpansForVariousComponents() {
        final CalcResult calcResult = FiberSpanCalculator.calculateNumberOfFiberSpans(components);
        assertEquals(5, calcResult.numberOfFiberSpans);
        System.out.println(calcResult);
    }
}
