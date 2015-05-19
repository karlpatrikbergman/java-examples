package se.patrikbergman.java.eight.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        FiberSpanCalculator.calculateFiberSpansPerChannel(components, 5).stream()
        .forEach(calcResult -> System.out.println(calcResult.getTotalResult()));
    }
}
