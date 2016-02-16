package se.patrikbergman.java.dynamicdispatch;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Polymorphism
 * Provides means to use the same control code to manage all objects in a category even if they are
 * different in their implementation.
 *
 * Subtyping / dynamic method dispatch
 * Tillåter en funktion f att ta argument av en viss typ T, men även av subtyper till denna t.ex U och V. U och V
 * kan då implementera t.ex en method specificerad i T på valfritt sätt utan att det påverkar funkionen f.
 *
 * Here reference of type Band, called x, is declared.
 * The program then assigns a reference to each type of object to r and uses that reference to invoke rockOn().
 * As the output shows, the version of rockOn() executed is determined by the type of object being referred to at
 * the time of the call (run time)
 */
public class DynamicDispatchTest {

    private Band band;
    private RockBand rockBand;
    private MetalBand metalBand;
    private Band x;

    @Before
    public void setup() {
        band = spy(new Band());
        rockBand = spy(new RockBand());
        metalBand = spy(new MetalBand());
    }

    @Test
    public void bandRockOnShouldBeInvokedTest() {
        x = band;
        x.rockOn(); //Calls bands version of rockOn()
        verify(band, times(1)).rockOn();

    }

    @Test
    public void rockBandRockOnShouldBeInvokedTest() {
        x = rockBand;
        x.rockOn(); //Calls rockbands version of rockOn()
        verify(rockBand, times(1)).rockOn();
    }

    @Test
    public void metalBandRockOnShouldBeInvokedTest() {
        x = metalBand;
        x.rockOn(); //Calls metalbands version fo rockOn()
        verify(metalBand, times(1)).rockOn();
    }

    @Test
    public void bandPolymorphicTest() {
        invokeRockOn(band);
        verify(band, times(1)).rockOn();
    }

    @Test
    public void rockBandPolymorphicTest() {
        invokeRockOn(rockBand);
        verify(rockBand, times(1)).rockOn();
    }

    @Test
    public void metalBandPolymorphicTest() {
        invokeRockOn(metalBand);
        verify(metalBand, times(1)).rockOn();
    }

    private void invokeRockOn(Band band) {
        band.rockOn();
    }
}
