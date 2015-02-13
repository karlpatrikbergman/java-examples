package se.patrikbergman.java.junit.configuration.rulechaintest.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import se.patrikbergman.java.junit.configuration.rulechaintest.annotations.Configuration;

public class FirstRule implements TestRule {

	private final String config;

	public FirstRule(String config) {
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
				System.out.println("First rule apply()");
				final Configuration configuration = description.getAnnotation(Configuration.class);
				base.evaluate();
			}
		};
	}
}
