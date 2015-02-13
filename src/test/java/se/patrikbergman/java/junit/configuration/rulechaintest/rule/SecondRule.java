package se.patrikbergman.java.junit.configuration.rulechaintest.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class SecondRule implements TestRule {

	private final String config;

	public SecondRule(String config) {
		this.config = config;
	}

	public String getConfig() {
		return config;
	}

	@Override
	public Statement apply(final Statement base, final Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				System.out.println("Second rule apply()");
				base.evaluate();
			}
		};
	}
}
