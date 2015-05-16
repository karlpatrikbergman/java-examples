package se.patrikbergman.java.eight.stream;

class OA implements Component {
    @Override
    public void calculate() {
        System.out.printf("%s [%s] calculate()", OA.class.getSimpleName(), getSerialNumber());
    }

    @Override
    public String toString() {
        return String.format("%s (serial: %s)", OA.class.getSimpleName(), getSerialNumber());
    }
}
