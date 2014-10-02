package se.patrikbergman.java.decorator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BandDecoratorTest {

    @Test
    public void testHeavyMetalBandRockFactor() {
        final String ordinaryBandName = "Roxette";
        RockAct ordinaryBand = new OrdinaryBand(ordinaryBandName);
        final String metalBandName = "Accept";
        RockAct heavyMetalBand = new HeavyMetalBand(new OrdinaryBand(metalBandName));
        assertTrue(ordinaryBand.getRockFactor() < heavyMetalBand.getRockFactor());
        assertEquals(metalBandName, heavyMetalBand.getName());
        assertEquals(ordinaryBandName, ordinaryBand.getName());
    }
}
