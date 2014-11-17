package se.patrikbergman.java.junit.configuration.advanced.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import se.patrikbergman.java.junit.configuration.advanced.dependencies.ServerFactory;
import se.patrikbergman.java.junit.configuration.advanced.dependencies.TestServer;
import se.patrikbergman.java.junit.configuration.advanced.rule.annotations.MethodEnvironment;

public class MethodConfigurationRule implements TestRule {

	private TestServer testServer;

	public TestServer getTestServer() {
		return testServer;
	}

	@Override
	public Statement apply(final Statement base, final Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				final MethodEnvironment methodEnvironment = description.getAnnotation(MethodEnvironment.class);
				testServer = ServerFactory.createServer(methodEnvironment.env());
				base.evaluate();
			}
		};
	}
}
