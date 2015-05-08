package se.patrikbergman.java.foo;

class Channel {
<<<<<<< Updated upstream
    private final boolean startPoint;
    private final boolean endPoint;
    private final double distance;

    Channel(boolean startPoint, boolean endPoint, double distance) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.distance = distance;
    }

    public boolean isStartPoint() {
        return startPoint;
    }

    public boolean isEndPoint() {
        return endPoint;
    }

    public double getDistance() {
        return distance;
=======
    public static final int NR_OF_CHANNELS = 4;
    private final int number;

    Channel(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static Channel[] createChannels() {
        final Channel[] channels = {
                new Channel(0),
                new Channel(1),
                new Channel(2),
                new Channel(3)
        };
        return channels;
    }

    @Override
    public String toString() {
        return Channel.class.getSimpleName() + " " + number;
>>>>>>> Stashed changes
    }
}
