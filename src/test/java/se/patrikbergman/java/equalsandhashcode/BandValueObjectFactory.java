package se.patrikbergman.java.equalsandhashcode;

import java.time.LocalDate;
import java.time.Month;

final class BandValueObjectFactory {
    static Band createJudasPriestValueObject() {
        return new Band.Builder()
                .name("Judas Priest")
                .description("Judas Priest is a British heavy metal band formed in Birmingham, England, in 1970.")
                .rockFactor(7)
                .formed(LocalDate.of(1970, Month.APRIL, 16))
                .totalIncome(10654234.23)
                .build();
    }

    static Band createSaxonValueObject() {
        return new Band.Builder()
                .name("Saxon")
                .description("Saxon are an English heavy metal band formed in 1976, in South Yorkshire.")
                .rockFactor(6)
                .formed(LocalDate.of(1976, Month.AUGUST, 31))
                .build();
    }
}
