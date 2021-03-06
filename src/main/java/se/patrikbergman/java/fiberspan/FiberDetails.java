package se.patrikbergman.java.fiberspan;


import java.util.List;

public class FiberDetails {

    //C F4 C F4 C
    //C F4 F4 F4 C
    //C F0.4 F0.4 C F4 C
    //C F4 F0.4 C F
    public static int getNumberOfFiberSpans(final List<Component> components) {
        int numberOfFiberSpans = 0;
        boolean previousComponentIsFiber = false;
        double accumulatedFiberLength = 0;

        for(Component component: components) {
            if(component instanceof Fiber) {
                if(!previousComponentIsFiber) {
                    if( ((Fiber) component).getDistance() >= 0.5) {
                        numberOfFiberSpans++;
                        previousComponentIsFiber = true;
                        accumulatedFiberLength = 0;
                    } else {
                        accumulatedFiberLength += ((Fiber) component).getDistance();
                        if(accumulatedFiberLength >= 0.5) {
                            numberOfFiberSpans++;
                            previousComponentIsFiber = true;
                            accumulatedFiberLength = 0;
                        }
                    }
                }
            } else {
                previousComponentIsFiber = false;
                accumulatedFiberLength = 0;
            }
        }
        return numberOfFiberSpans;
    }

}
