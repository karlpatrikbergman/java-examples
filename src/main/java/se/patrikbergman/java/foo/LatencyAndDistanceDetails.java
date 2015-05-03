package se.patrikbergman.java.foo;


import java.util.List;

public class LatencyAndDistanceDetails {

    public static int getNumberOfFiberSpans(final List<Component> components) {
        int numberOfFiberSpans = 0;
        boolean previousComponenIsFiber = false;
        double accumulatedFiberLength = 0;


        //C F4 C F4 C
        //C F4 F4 F4 C
        //C F0.4 F0.4 C F4 C
        //C F4 F0.4 C F

        for(Component component: components) {
            if(component instanceof Fiber) {
                if(!previousComponenIsFiber) {
                    if( ((Fiber) component).getDistance() >= 0.5) {
                        numberOfFiberSpans++;
                        previousComponenIsFiber = true;
                    } else {
                        accumulatedFiberLength += ((Fiber) component).getDistance();
                        if(accumulatedFiberLength >= 0.5) {
                            numberOfFiberSpans++;
                            previousComponenIsFiber = true;
                            accumulatedFiberLength = 0;
                        }
                    }
                }
            } else {
                previousComponenIsFiber = false;
                accumulatedFiberLength = 0;
            }
        }
        return numberOfFiberSpans;

    }

}
