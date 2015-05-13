package se.patrikbergman.java.foo;

class Fiber implements Component {
    private final double distance;

    Fiber(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Fiber " + distance;
    }

}
