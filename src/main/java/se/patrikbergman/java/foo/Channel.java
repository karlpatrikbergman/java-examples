package se.patrikbergman.java.foo;

class Channel {
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
    }
}
