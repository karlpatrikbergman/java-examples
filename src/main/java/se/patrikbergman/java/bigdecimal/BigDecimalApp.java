package se.patrikbergman.java.bigdecimal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;


/**
 * 10.23 MB/s is saved as 1023 on the node
 *
 * 10 000 - 1 500 000   MIB spec
 * 100.00 - 15000.00    Label vid textfält i ENM gui
 * 135.22               Värde i ENM GUI
 * 13522                I MIB value --> 13 522 MB/s
 */

public class BigDecimalApp {

    public static void main(String args[]) {
        int speed = 1023;
        System.out.println(
                toDisplayString(speed)
        );

//        System.out.println(value);
//        System.out.println(
//            toIntegerInHundredsOfMegaBits(
//                toBigDecimalWithTwoDecimals("10.23")
//            ).intValueExact()
//        );
    }

    private static BigDecimal toBigDecimalWithTwoDecimals(String textValue) {
        Double doubleValue = Double.valueOf(textValue);
        return BigDecimal.valueOf(doubleValue).setScale(2, RoundingMode.HALF_DOWN);
    }

    private static BigInteger toIntegerInHundredsOfMegaBits(BigDecimal value) {
        return value.multiply(BigDecimal.valueOf(100)).toBigInteger();
    }

    public static String toDisplayString(int speed) {
        return BigDecimal.valueOf(speed)
                .divide(BigDecimal.valueOf(100))
                .toString();
    }

}
