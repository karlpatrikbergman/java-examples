package se.patrikbergman.java.pattern.builder;

enum Genre {
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
