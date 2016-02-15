package se.patrikbergman.java.dynamicdispatch;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
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
    public void bandMethodTest() {
        x = band;
        x.rockOn(); //Calls bands version of rockOn()
        verify(band, times(1)).rockOn();

    }

    @Test
    public void rockBandMethodTest() {
        x = rockBand;
        x.rockOn(); //Calls rockbands version of rockOn()
        verify(rockBand, times(1)).rockOn();
    }

    @Test
    public void metalBandMethodTest() {
        x = metalBand;
        x.rockOn(); //Calls metalbands version fo rockOn()
        verify(metalBand, times(1)).rockOn();
    }
}
