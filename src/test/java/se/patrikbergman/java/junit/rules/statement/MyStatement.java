package se.patrikbergman.java.junit.rules.statement;

import org.junit.runners.model.Statement;

public class MyStatement extends Statement {

	private final Statement base;

	public MyStatement(Statement base) {
		this.base = base;
	}

	@Override
	public void evaluate() throws Throwable {
		System.out.println("Before");
		try {
			base.evaluate();
		} finally {
			System.out.println("After");
		}
	}
}
