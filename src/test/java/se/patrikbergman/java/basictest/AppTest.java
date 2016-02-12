package se.patrikbergman.java.basictest;

import org.junit.Test;

public class AppTest {

    /**
     * I thought assignment had to be done when declaring variable, if final
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
}
