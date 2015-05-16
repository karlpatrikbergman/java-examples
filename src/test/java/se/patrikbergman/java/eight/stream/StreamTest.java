package se.patrikbergman.java.eight.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Recapitulate:
 * The compareTo method compares the receiving object with the specified object and
 * returns a negative integer, 0, or a positive integer depending on whether the receiving
 * object is less than, equal to, or greater than the specified object.
 */

public class StreamTest {

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

    Function<Component, Integer> f = new Function<Component, Integer>() {
        @Override
        public Integer apply(Component component) {
            return (component instanceof Fiber) ? 1 : 0;
        }
    };

    @Test
    public void java8() {
        List<Double> distances = components.stream()
                .filter(component -> component instanceof Fiber)
                .sorted(comparing(component -> ((Fiber) component).getDistance()).reversed())
                .map(component -> ((Fiber) component).getDistance())
                .collect(toList());
        System.out.println(distances);
    }


    @Test
    public void java7() {
        List<Fiber> fibers = new ArrayList<>();
        for (Component component : components) {
            if (component instanceof Fiber) {
                fibers.add((Fiber) component);
            }
        }
        Collections.sort(fibers, new Comparator<Fiber>() {
            @Override
            public int compare(Fiber fiber1, Fiber fiber2) {
                if (fiber1.getDistance() > fiber2.getDistance()) return -1;
                if (fiber1.getDistance() < fiber2.getDistance()) return 1;
                return 0;
            }
        });

        List<Double> distances = new ArrayList<>();
        for(Fiber fiber : fibers) {
            distances.add(fiber.getDistance());
        }
        System.out.println(distances);
    }
}
