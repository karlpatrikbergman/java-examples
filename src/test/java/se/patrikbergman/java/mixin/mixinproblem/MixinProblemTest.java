package se.patrikbergman.java.mixin.mixinproblem;

import org.junit.Test;

public class MixinProblemTest {

	/**
	 * The out put is
	 *
	 * x2
	 * x2
	 *
	 * showing that makeXfromLambdaExpression() returns a reference to the same
	 * instance. This is due to some JVM optimization in Java 8.
	 */
	@Test
	public void mixinProblemTest1() {
		X x1 = makeXfromLamdaExpresion();
		X x2 = makeXfromLamdaExpresion();
		x1.setName("x1");
		x2.setName("x2");

		System.out.println(x1.getName());
		System.out.println(x2.getName());
	}

	/**
	 * When interface has just one method, run() in this case, you can instantiate with Lambda expression
	 */
	private X makeXfromLamdaExpresion() {
		return () -> { System.out.println("Executing default implementation of run()"); };
	}

	/**
	 * When using a new operator, the problem is gone.
	 */
	@Test
	public void mixinProblemTest2() {
		X x1 = makeXwithNewOperator();
		X x2 = makeXwithNewOperator();
		x1.setName("x1");
		x2.setName("x2");

		System.out.println(x1.getName());
		System.out.println(x2.getName());
	}

	private X makeXwithNewOperator() {
		return new X() {
			@Override
			public void run() {
				System.out.println("Executing default implementation of run()");
			}
		};
	}
}
