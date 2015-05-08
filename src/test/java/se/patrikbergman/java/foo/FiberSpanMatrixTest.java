package se.patrikbergman.java.foo;

import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

public class FiberSpanMatrixTest {

    private Vector<Component> components;

    @Before
    public void setup() {
        components = new Vector<>();
        components.add(new DMU(0));
        components.add(new Fiber(1, 4));
        components.add(new DMU(2));
        components.add(new Fiber(3, 4));
        components.add(new DMU(4));
    }

    @Test
    public void test() {
        FiberSpanMatrix.getNumberOfFiberSpans(components);
    }

}
