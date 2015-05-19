package se.patrikbergman.java.eight.stream;

import java.util.HashSet;
import java.util.Set;

class AddDropComponent implements Component {

    private final Set<Integer> droppedChannels = new HashSet<>();

    AddDropComponent(final Set<Integer> droppedChannels) {
        this.droppedChannels.addAll(droppedChannels);
    }

    public void dropChannel(final int index) {
        droppedChannels.add(index);
    }

    public boolean isDropped(final int index) {
        return droppedChannels.contains(index);
    }

    public Set<Integer> getDroppedChannels() {
        return droppedChannels;
    }

    @Override
    public void calculate() {
        System.out.printf("%s [%s] calculate()", AddDropComponent.class.getSimpleName(), getSerialNumber());
    }

    @Override
    public String toString() {
        return String.format("%s (serial: %s)", AddDropComponent.class.getSimpleName(), getSerialNumber());
    }
}
