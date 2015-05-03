package se.patrikbergman.java.foo;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.function.ToIntFunction;

public class Faa {


    public final ImmutableList<Object> components = ImmutableList.of(
            "ComponentA",
            new Fiber(4),
            "ComponentB",
            new Fiber(3),
            "ComponentC");

    @Test
    public void test() {

        ToIntFunction<Object> f = component -> (component instanceof Fiber) ? 1 : 0;

        Integer numberOfSpans = components
                .stream()
                .mapToInt(f)
                .sum();
        System.out.println(numberOfSpans);

    }

    @Test
    public void testReduce() {
        final ImmutableList<Integer> integers = ImmutableList.of(1, 2, 3, 4, 5);
        Integer sum = integers
                .stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }

}
