package se.patrikbergman.java.eight.stream;

class Fiber implements Component {
    private final double distance;

    Fiber(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }


    @Override
    public void calculate() {
        System.out.printf("%s [%s] calculate()", Fiber.class.getSimpleName(), getSerialNumber());
    }

    @Override
    public String toString() {
        return String.format("%s (serial: %s distance: %s)", Fiber.class.getSimpleName(), getSerialNumber(), distance);
    }
}
