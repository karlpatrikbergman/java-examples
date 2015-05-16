package se.patrikbergman.java.eight.stream;

class Mux implements Component {

    @Override
    public void calculate() {
        System.out.printf("%s [%s] calculate()", Mux.class.getSimpleName(), getSerialNumber());
    }

    @Override
    public String toString() {
        return String.format("%s (serial: %s)", Mux.class.getSimpleName(), getSerialNumber());
    }
}
