package se.patrikbergman.java.basictest;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class RandomJavaExploringTests {

    /**
     * I thought assignment had to be done when declaring variable, if final.
     * So a variable can be defined final without giving it a value, and later when
     * value is set, it can't be set again.
     */
    @Test
    public void testFinalModifier() {
        final String string;
        if (true) {
            string = "true";
        } else {
            string = "false";
        }
        System.out.println(string);
        //string ="cant be done";
    }

    /**
     * Making sure we don't need null check before instance of
     */
    @Test
    public void instanceOfWithNull() {
        RockBand band = null;
        boolean result = (band instanceof Band);
        assertFalse(result);

    }
}
