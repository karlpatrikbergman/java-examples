package se.patrikbergman.java.foo;

import org.junit.Before;
import org.junit.Test;

import java.util.ListIterator;
import java.util.Vector;

public class FooTest {

    class Fiber {
        private final int distance;

        Fiber(int distance) {
            this.distance = distance;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public String toString() {
            return "Fiber: distance " + distance;
        }
    }

    private final Vector<Object> components = new Vector<>();

    @Before
    public void setup() {
        components.add("NodeA");
        components.add(new Fiber(3));
        components.add("NodeB");
        components.add(new Fiber(1));
        components.add(new Fiber(4));
        components.add("NodeC");
        components.add(new Fiber(1));
        components.add("NodeD");
        components.add(new Fiber(4));
        components.add(new Fiber(1));
        components.add("NodeE");
    }


    @Test
    public void bar() {
        ListIterator<Object> listIterator = components.listIterator();
        while (listIterator.hasNext()) {
            if(listIterator.hasPrevious())
            System.out.println(listIterator.previousIndex());
            System.out.println(listIterator.next());
        }
    }

    @Test
    public void foo() {
        int nrOfSpans = 0;
        boolean previousComponentFiber = false;

        for(Object component : components) {
            if(component instanceof Fiber && !previousComponentFiber && ((Fiber)component).getDistance() > 2) {
                nrOfSpans++;
                previousComponentFiber = true;
            } else {
                previousComponentFiber = false;
            }
        }
        System.out.println(nrOfSpans);
    }


}
