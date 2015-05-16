package se.patrikbergman.java.eight.stream;

import org.apache.commons.lang3.RandomUtils;

interface Component {
    default int getSerialNumber() {
        return RandomUtils.nextInt(1000,9999);
    };
    void calculate();
}
