package se.patrikbergman.java.eight.stream;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class ReduceTest {

    private final DecimalFormat df = new DecimalFormat("###.##");

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
     * This reduce method accepts a BinaryOperator accumulator function.
     * That's actually a BiFunction where both operands share the same type, in this case Component.
     * BiFunctions are like Function but accept two arguments.
     * The example function compares both components serial number in order to return the component
     * highest serial number.
     */
    @Test
    public void reduce1() {
        components.stream()
                .reduce((c1, c2) -> c1.getSerialNumber() > c2.getSerialNumber() ? c1 : c2)
                .ifPresent(System.out::println);
    }

    /**
     * The second reduce method accepts both an identity value and a BinaryOperator accumulator.
     * This method can be utilized to construct a new Fiber with the aggregated distance from all other fibers
     * in the stream:
     */
    @Test
    public void reduce2() {
        Fiber result  = (Fiber) components.stream()
                .filter(c -> c instanceof Fiber)
                .reduce(new Fiber(0), (c1, c2) -> {
                    Fiber aggregate = (Fiber) c1;
                    if (c2 instanceof Fiber) {
                        Fiber currentFiber = (Fiber) c2;
                        return new Fiber(aggregate.getDistance() + currentFiber.getDistance());
                    } else {
                        return new Fiber(aggregate.getDistance());
                    }
                });
        System.out.println(result);
    }

    /**
     * Performs a reduction on the elements of this stream, using the provided identity, accumulation and combining
     * functions.
     * With stream() accumulator does all the work
     */
    @Test
    public void reduce3() {
        Double totalDistance = components.stream()
                .filter(component -> component instanceof Fiber)
                .reduce(0d,
                        (accumulatedDistance, component) -> (accumulatedDistance += ((Fiber) component).getDistance()),
                        (accumulatedDistance1, accumulatedDistance2) -> accumulatedDistance1 + accumulatedDistance2);
        System.out.println(df.format(totalDistance));
    }

    /**
     * To se combiner at work, get parallelStream()
     */
    @Test
    public void reduce3WithSystemOut() {
        Double totalDistance = components.parallelStream()
//        Double totalDistance = components.stream()
                .filter(c -> c instanceof Fiber)
                .reduce(0.0d,
                        (accumulatedDistance, c) -> {
                            log("accumulator: distance: " + df.format(accumulatedDistance), "component: " + c.toString());
                            return (accumulatedDistance += ((Fiber) c).getDistance());
                        },
                        (accumulatedDistance1, accumulatedDistance2) -> {
                            log("combiner   : sumdist1: " + df.format(accumulatedDistance1), "distance2: " + df.format(accumulatedDistance2));
                            return accumulatedDistance1 + accumulatedDistance2;
                        });
        System.out.format("Total distance: %s", df.format(totalDistance));
    }

    void log(String column1, String column2) {
        System.out.format("%-30s %-20s\n", column1, column2);
    }

    /***/



}
