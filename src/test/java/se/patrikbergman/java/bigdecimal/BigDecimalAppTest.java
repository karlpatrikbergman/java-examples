package se.patrikbergman.java.bigdecimal;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BigDecimalAppTest {

    BigDecimalApp bigDecimalApp = new BigDecimalApp();

    @Test
    public void toBigDecimalWithTwoDecimals() {
        final String valueInMegabitsPerSecond = "10.23";
        assertEquals(BigDecimal.valueOf(10.23), bigDecimalApp.toBigDecimalWithTwoDecimals(valueInMegabitsPerSecond));
    }

    @Test
    public void toDisplayString() {
        int intValue = 1023;
        assertTrue("10.23".equals(bigDecimalApp.toDisplayString(intValue)));
    }

    @Test
    public void toIntegerInHundredsOfMegaBits() {
        assertEquals(1023, bigDecimalApp.toIntegerInHundredsOfMegaBits(BigDecimal.valueOf(10.23)).intValueExact());
    }
}
