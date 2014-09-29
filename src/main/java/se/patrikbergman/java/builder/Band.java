package se.patrikbergman.java.builder;

public class Band {
    private final String name;
    private final String description;
    private final Genre genre;

    private Band(Builder builder) {
        name = builder.name;
        description = builder.description;
        genre = builder.genre;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Genre getGenre() {
        return genre;
    }

    public static final class Builder {
        private String name;
        private String description;
        private Genre genre;

        public Builder() { }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder genre(Genre genre) {
            this.genre = genre;
            return this;
        }

        public Band build() {
            return new Band(this);
        }
    }
}
