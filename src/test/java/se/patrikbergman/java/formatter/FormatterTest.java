package se.patrikbergman.java.formatter;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class FormatterTest {

    /**
     *  %d      print integer as it is
     *  %6d     print integer as it is, if nr of digits < 6, pad left
     *  %-6d    print integer as it is, if nr of digits < 6, pad right
     *  %06d    print integer as it is, if nr of digits < 6, pad left with zeroes
     *  %.2d    prints max two digits of the integer
     */



    @Test
    public void format() {
        StringUtils.center(Integer.toString(1), 12);
        System.out.format("%-12s%-12s%-12s\n", "Column 1", "Column 2", "Column3");

        System.out.format("%-12s%-12s%-12s\n",
                StringUtils.center(Integer.toString(1), 8),
                StringUtils.center(Integer.toString(1), 8),
                StringUtils.center(Integer.toString(1), 8)
        );
    }
}
