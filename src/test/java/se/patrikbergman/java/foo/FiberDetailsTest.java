package se.patrikbergman.java.foo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FiberDetailsTest {

    private final Vector<Component> components;
    private final int expectedNumberOfFiberSpans;

    public FiberDetailsTest(final Vector<Component> components, final int expectedNumberOfFiberSpans) {
        this.components = components;
        this.expectedNumberOfFiberSpans = expectedNumberOfFiberSpans;
    }

    @Test
    public void test() {
        int actualNumberOfFiberSpans = FiberDetails.getNumberOfFiberSpans(components);
        assertEquals(expectedNumberOfFiberSpans, actualNumberOfFiberSpans);
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final Fiber fourKmFiber = new Fiber(4);
        final Fiber fourHundredMeterFiber = new Fiber(0.4);
        final DMU dmu = new DMU();

        return Arrays.asList(new Object[][]{
                {createVector(new Component[]{dmu, fourKmFiber, dmu}), 1},
                {createVector(new Component[]{dmu, fourHundredMeterFiber, dmu, fourHundredMeterFiber}), 0},
                {createVector(new Component[]{dmu, fourHundredMeterFiber, fourHundredMeterFiber, fourKmFiber, dmu}), 1},
                {createVector(new Component[]{dmu, fourKmFiber, fourHundredMeterFiber, fourHundredMeterFiber, dmu}), 1},
                {createVector(new Component[]{dmu, fourKmFiber, fourHundredMeterFiber, fourHundredMeterFiber, fourHundredMeterFiber, fourHundredMeterFiber}), 1},
                {createVector(new Component[]{dmu, fourHundredMeterFiber, fourHundredMeterFiber, dmu}), 1}
        });
    }

    private static Vector<Component> createVector(Component[] componentsArray) {
        return new Vector<Component>(Arrays.asList(componentsArray));
    }

}
