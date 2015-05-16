package se.patrikbergman.java.eight.stream;

class DeMux implements Component {

    @Override
    public void calculate() {
        System.out.printf("%s [%s] calculate()", DeMux.class.getSimpleName(), getSerialNumber());
    }

    @Override
    public String toString() {
        return String.format("%s (serial: %s)", DeMux.class.getSimpleName(), getSerialNumber());
    }
}
