package se.patrikbergman.java.eight.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FiberSpanCalculatorTest {

    private final Vector<Component> components;
    private final int expectedNumberOfFiberSpans;

    public FiberSpanCalculatorTest(final Vector<Component> components, final int numberOfFiberSpans) {
        this.components= components;
        this.expectedNumberOfFiberSpans = numberOfFiberSpans;
    }

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
    public void calculateNumberOfFiberSpans() {
        final CalcResult calcResult = FiberSpanCalculator.calculateNumberOfFiberSpans(components);
        final int actualNumberOfFiberSpans = calcResult.numberOfFiberSpans;
        assertEquals(expectedNumberOfFiberSpans, actualNumberOfFiberSpans);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final Fiber fourKmFiber = new Fiber(4.0);
        final Fiber fourHundredMeterFiber = new Fiber(0.4); //Fiber under 0.5 km should not be counted as fiber span
        final DeMux deMux = new DeMux();
        final Mux mux = new Mux();
        final OA oa = new OA();

        return Arrays.asList(new Object[][]{
                {new Vector<>(Arrays.asList(deMux, fourKmFiber, mux, fourKmFiber, mux)), 2},
                {new Vector<>(Arrays.asList(mux, fourKmFiber, fourHundredMeterFiber, mux, fourKmFiber, deMux)), 2},
                {new Vector<>(Arrays.asList(mux, fourHundredMeterFiber, fourKmFiber, mux, fourKmFiber, deMux)), 2},
                {new Vector<>(Arrays.asList(mux, fourHundredMeterFiber, fourHundredMeterFiber, oa, fourKmFiber, deMux)), 2},
                {new Vector<>(Arrays.asList(mux, fourHundredMeterFiber, fourHundredMeterFiber, fourKmFiber, oa, fourKmFiber, deMux)), 2},
                {new Vector<>(Arrays.asList(mux, fourKmFiber, fourHundredMeterFiber, fourHundredMeterFiber, oa, fourKmFiber, deMux)), 2},
                {new Vector<>(Arrays.asList(mux, fourKmFiber, fourHundredMeterFiber, fourHundredMeterFiber, oa, fourKmFiber, deMux)), 2},
                {new Vector<>(Arrays.asList(mux, fourHundredMeterFiber, fourHundredMeterFiber, fourKmFiber, oa, fourKmFiber, deMux)), 2},
                {new Vector<>(Arrays.asList(mux, fourHundredMeterFiber, oa, fourHundredMeterFiber, oa, fourKmFiber, oa, fourKmFiber, deMux)), 2}
        });
    }
}
