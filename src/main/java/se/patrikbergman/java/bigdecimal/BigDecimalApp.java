package se.patrikbergman.java.bigdecimal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;


/**
 * 10.23 MB/s is saved as 1023 on the node
 *
 * 10 000 - 1 500 000   MIB spec
 * 100.00 - 15000.00    Label vid textfält i ENM gui
 * 135.22               Värde i ENM GUI
 * 13522                I MIB value --> 13 522 MB/s
 *
 *
 * "10.23" --> BigDecimal --> int
 */

class BigDecimalApp {

    BigDecimal toBigDecimalWithTwoDecimals(String decimalString) {
        return BigDecimal
                .valueOf(Double.valueOf(decimalString))
                .setScale(2, RoundingMode.HALF_DOWN);
    }

    BigInteger toIntegerInHundredsOfMegaBits(BigDecimal value) {
        return value.multiply(BigDecimal.valueOf(100)).toBigInteger();
    }

    String toNumericStringWithTwoDecimals(int speed) {
        return BigDecimal.valueOf(speed)
                .divide(BigDecimal.valueOf(100))
                .toString();
    }

    Integer toInteger(String decimalString) {
        return toIntegerInHundredsOfMegaBits(
                toBigDecimalWithTwoDecimals(decimalString)
        ).intValueExact();
    }

    /**
     * This one includes both dot and comma
     * final String regExp = "[0-9]+([,.][0-9]{1,2})?";
     *
     * @param stringValue
     * @return
     */
    boolean isNumericValueWithTwoDecimals(String stringValue) {
        final String regExp = "[0-9]+([.][0-9]{1,2})?";
        return stringValue.matches(regExp);
    }

    String toStringWithTwoDecimals(long longValue) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(longValue);
    }

}
