package se.patrikbergman.java.foo;

class Fiber implements Component {
    private final double distance;
    private final Channel[] channels;

    Fiber(double distance, Channel[] channels) {
        this.distance = distance;
        this.channels = channels;
    }

    Fiber(double distance) {
        this.distance = distance;
        this.channels = null;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public Channel[] getChannels() {
        return channels;
    }

    @Override
    public String toString() {
        return "Fiber: distance " + distance;
    }
}
