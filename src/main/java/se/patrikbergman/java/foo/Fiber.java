package se.patrikbergman.java.foo;

class Fiber implements Component {
    private final double distance;
    private final Channel[] channels;
<<<<<<< Updated upstream

    Fiber(double distance, Channel[] channels) {
        this.distance = distance;
        this.channels = channels;
    }

    Fiber(double distance) {
        this.distance = distance;
        this.channels = null;
=======
    private final int index;

    Fiber(double distance) {
        this.distance = distance;
        this.channels = Channel.createChannels();
        this.index = 0;
    }

    Fiber(int index, double distance) {
        this.distance = distance;
        this.channels = Channel.createChannels();
        this.index = index;
>>>>>>> Stashed changes
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public Channel[] getChannels() {
        return channels;
    }

    @Override
<<<<<<< Updated upstream
=======
    public Channel getChannel(final int channelIndex) {
        return channels[channelIndex];
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
>>>>>>> Stashed changes
    public String toString() {
        return "Fiber " + index;
    }

}
