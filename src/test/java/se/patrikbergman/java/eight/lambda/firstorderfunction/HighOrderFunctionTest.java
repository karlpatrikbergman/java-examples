package se.patrikbergman.java.eight.lambda.firstorderfunction;


import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * A higher-order function is a function that does at least one of the following:
 *
 * [1] One or more of its parameters is a function, and it returns some value.
 * [2] It returns a function, but none of its parameters is a function.
 * [3] Both of the above: One or more of its parameters is a function, and it returns a function.
 *
 * All other functions are first-order functions. (a,b)
 */
public class HighOrderFunctionTest {


    @Test
    public void highOrderFunctionDefinition1() {

        BiFunction<Function<Integer, Boolean>, Integer, Boolean> f = (integerBooleanFunction, integer) -> integerBooleanFunction.apply(integer);

        Function<Integer, Boolean> g = (integer) -> integer < 0;
        Boolean isNegative = f.apply(g, -1);
        System.out.println(isNegative);

        Function<Integer, Boolean> h = (integer) -> integer % 2 == 0;
        Boolean isDividableByTwo = f.apply(h, 4);
        System.out.println(isDividableByTwo);
    }

    /**
     * The function "f" takes an integer "x" as parameter and returns a function, which in turn takes
     * an integer "y" as parameter and returns y > x (boolean)
     *
     * It is an high-order function according to definition:
     * [2] It returns a function, but none of its parameters is a function.
     */
    @Test
    public void highOrderFunctionDefinition2() {
        Function<Integer, Function<Integer, Boolean>> f = threshold -> (value -> value < threshold);
        Function<Integer, Boolean> g = f.apply(100);
        System.out.println(g.apply(100));
    }

    /****************************************************************************/

    @FunctionalInterface
    public interface ExtendedBiFunction<T, U, R>
            extends BiFunction<T, U, R> {

        default Function<U, R> curry1(T t) {
            return u -> apply(t, u);
        }

        default Function<T, R> curry2(U u) {
            return t -> apply(t, u);
        }
    }

    public class Converter implements ExtendedBiFunction<Double, Double, Double> {
        @Override
        public Double apply(Double aDouble, Double aDouble2) {
            return aDouble * aDouble2;
        }
    }

    @Test
    public void currying() {
        //ExtendedBiFunction<T, U, R>
        Converter converter = new Converter();
        Function<Double, Double> f = converter.curry1(3.14);
        Double result = f.apply(20.0);
        System.out.println(result);
    }

    /**
     * NOT HIGH ORDER FUNCTIONS
     * since they do not conform to definition above.
     */
    @Test
    public void firstOrderFunctions() {
        Function<Integer, Integer> square = integer -> integer * 2;
        System.out.println(square.apply(4));

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(2, 2));
    }
}

/* highOrderFunctionDefinition1, Lambda Expression in verbose way
BiFunction<Function<Integer, Boolean>, Integer, Boolean> f = new BiFunction<Function<Integer, Boolean>, Integer, Boolean>() {
    @Override
    public Boolean apply(Function<Integer, Boolean> integerBooleanFunction, Integer integer) {
        return integerBooleanFunction.apply(integer);
    }
};
*

/* highOrderFunctionDefinition2, Lambda Expression in verbose way
Function<Integer, Function<Integer, Boolean>> f = new Function<Integer,Function<Integer,Boolean>>() {
    @Override
    public Function apply(Integer threshold) {
        return new Function<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer value) {
                return value < threshold;
            }
        };
    }
};
*/
