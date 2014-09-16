package se.patrikbergman.java.builder;

import org.junit.Test;
import static org.junit.Assert.*;

public class BandBuilderTest {

    @Test
    public void buildBand() {
        final String name = "Accept";
        final String description = "German Heavy Metal from the eighties";
        final Genre genre = Genre.HEAVYMETAL;
        Band band = new Band.Builder()
                .name(name)
                .description(description)
                .genre(genre)
                .build();
        assertNotNull(band);
        assertEquals(name, band.getName());
        assertEquals(description, band.getDescription());
        assertEquals(genre, band.getGenre());
    }

}
