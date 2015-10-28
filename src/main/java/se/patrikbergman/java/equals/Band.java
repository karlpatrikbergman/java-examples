package se.patrikbergman.java.equals;

import com.google.common.base.Preconditions;

import java.time.LocalDate;

class Band {
    private final String name;
    private final String description;
    private final int rockFactor;
    private final LocalDate formed;
    private final double totalIncome;

    private Band(Builder builder) {
        name = builder.name;
        description = builder.description;
        rockFactor = builder.rockFactor;
        formed = builder.formed;
        totalIncome = builder.totalIncome;
    }

    @Override
    public boolean equals(Object object) {
        if(object == this) return true;
        if(!(object instanceof Band)) return false;

        final Band otherBand = (Band) object;
        return this.name.equals(otherBand.name) &&
                this.description.equals(otherBand.description) &&
                this.rockFactor == otherBand.rockFactor &&
                this.formed.equals(otherBand.formed) &&
                (Double.compare(this.totalIncome, otherBand.totalIncome) == 0);
    }

    public static final class Builder {
        private String name;
        private String description;
        private int rockFactor;
        private LocalDate formed;
        private double totalIncome;

        public Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder rockFactor(int val) {
            rockFactor = val;
            return this;
        }

        public Builder formed(LocalDate val) {
            formed = val;
            return this;
        }

        public Builder totalIncome(double val) {
            totalIncome = val;
            return this;
        }

        public Band build() {
            Preconditions.checkNotNull(name);
            Preconditions.checkNotNull(description);
            Preconditions.checkNotNull(formed);
            return new Band(this);
        }
    }
}
