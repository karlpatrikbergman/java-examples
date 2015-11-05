package se.patrikbergman.java.bigdecimal;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BigDecimalAppTest {

    BigDecimalApp bigDecimalApp = new BigDecimalApp();

    @Test
    public void toBigDecimalWithTwoDecimals() {
        final String valueInMegabitsPerSecond = "10.23";
        assertEquals(BigDecimal.valueOf(10.23), bigDecimalApp.toBigDecimalWithTwoDecimals(valueInMegabitsPerSecond));
    }

    @Test
    public void toNumericStringWithTwoDecimals() {
        int intValue = 1023;
        assertTrue("10.23".equals(bigDecimalApp.toNumericStringWithTwoDecimals(intValue)));
    }

    @Test
    public void toIntegerInHundredsOfMegaBits() {
        assertEquals(1023, bigDecimalApp.toIntegerInHundredsOfMegaBits(BigDecimal.valueOf(10.23)).intValueExact());
    }

    @Test
    public void foo() {
        //given
        String textFieldValue = "10.23";

        //when
        int intValueToBeSubmitted = bigDecimalApp.toInteger(textFieldValue);

        //then
        assertEquals(1023, intValueToBeSubmitted);
    }

    @Test
    public void numericDecimalStringToInteger() {
        //given
        String textFieldValue = "10.2999";

        //when
        int intValueToBeSubmitted = bigDecimalApp.toInteger(textFieldValue);
        String displayValue = bigDecimalApp.toNumericStringWithTwoDecimals(intValueToBeSubmitted);

        //then
        assertEquals("10.3", displayValue);
    }

    @Test
    public void validNumericDecimalString() {
        assertTrue(bigDecimalApp.isNumericValueWithTwoDecimals("10.23"));
    }

    @Test
    public void validNumericString() {
        assertTrue(bigDecimalApp.isNumericValueWithTwoDecimals("10"));
    }

    @Test
    public void stringWithCommaInsteadOfDot() {
        assertFalse(bigDecimalApp.isNumericValueWithTwoDecimals("10,23"));
    }

    @Test
    public void unValidNumericDecimalString() {
        assertFalse(bigDecimalApp.isNumericValueWithTwoDecimals("non-numeric-string"));
    }

    @Test
    public void toStringWithTwoDecimals() {
        assertEquals("10.00", bigDecimalApp.toStringWithTwoDecimals(10));
    }

}
