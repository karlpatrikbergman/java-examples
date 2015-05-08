package se.patrikbergman.java.foo;

import java.util.List;

class FiberSpanMatrix {

    public static void getNumberOfFiberSpans(final List<Component> components) {

        for(int i=0; i<Channel.NR_OF_CHANNELS; i++) {
            for(int j=0; j<components.size(); j++) {
                Component component = components.get(j);
                Channel channel = component.getChannel(i);
                System.out.println(component + " " + channel);
            }
            System.out.println("--");
        }
    }

}
