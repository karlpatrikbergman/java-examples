package se.patrikbergman.java.foo;


import java.util.List;

public class FiberDetails {


    public static int[] getNumberOfFiberSpanse(final List<Component> components) {
        final int NR_OF_CHANNELS = 4;

        final int[] numberOfFiberSpans = new int[NR_OF_CHANNELS];
        final boolean[] previousComponentIsFiber = new boolean[NR_OF_CHANNELS];
        final double[] accumulatedFiberLength = new double[NR_OF_CHANNELS];

        for(int i = 0; i<components.size(); i++) {
            Component component = components.get(i);
            Channel[] channels = component.getChannels();
            for(int j = 0; j<channels.length; j++) {
                if(component instanceof Fiber) {

                } else {
                    
                }
            }
        }

        return numberOfFiberSpans;
    }


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
