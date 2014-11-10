package se.patrikbergman.java.pattern.builder;

public enum Genre {
    BLUES {
        public String getName() {
            return "Blues";
        }
    },
    HEAVYMETAL {
        public String getName() {
            return "Heavy Metal";
        }
    };

    public abstract String getName();
}
