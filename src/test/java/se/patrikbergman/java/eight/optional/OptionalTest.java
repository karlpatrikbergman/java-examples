package se.patrikbergman.java.eight.optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.*;
import java.util.stream.Stream;

public class OptionalTest {

    @Rule
    public TestName name= new TestName();

    private final List<Double> doubleList = Arrays.asList(
            1.5,
            2.5,
            3.5,
            3.5
    );

    private final List<Double> emptyDoubleList = new ArrayList<>();

    @Before
    public void setup() {
        System.out.format("%nExecuting method '%s':%n", name.getMethodName());
    }

    @Test
    public void findFirst() {
        Optional<Double> highestDouble = doubleList.stream()
                .sorted(Comparator.<Double>reverseOrder())
                .findFirst();

        if(highestDouble.isPresent()) {
            System.out.println(highestDouble);
        } else {
            System.out.println("Stream was empty");
        }
    }

    @Test
    public void findMax() {
        Optional<Double> highestDouble = doubleList.stream()
                .max(Comparator.<Double>naturalOrder());

        if(highestDouble.isPresent()) {
            System.out.println(highestDouble);
        } else {
            System.out.println("Stream was empty");
        }
    }

    @Test
    public void findMinInDoubleList() {
        final double minValue = findMin(doubleList.stream());
        System.out.println(minValue);
    }

    @Test(expected = NoSuchElementException.class)
    public void findMinInEmptyDoubleList() {
        final double minValue = findMin(emptyDoubleList.stream());
    }

    private double findMin(final Stream<Double> doubleStream) {
        return doubleStream
                .min(Comparator.<Double>naturalOrder()).get().doubleValue();
    }

}
