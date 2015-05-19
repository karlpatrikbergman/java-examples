package se.patrikbergman.java.eight.stream;

class Channel {
    private static int index = 0;

    Channel() {
        index++;
    }

    int getIndex() {
        return index;
    }

    public static Channel[] createChannels() {
        return null;
    }

}
