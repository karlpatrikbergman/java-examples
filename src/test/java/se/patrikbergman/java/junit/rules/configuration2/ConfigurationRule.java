package se.patrikbergman.java.junit.rules.configuration2;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class ConfigurationRule implements TestRule {

	private TestServer testServer;

	public TestServer getTestServer() {
		return testServer;
	}

	@Override
	public Statement apply(final Statement base, final Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				final Environment environment = description.getAnnotation(Environment.class);
				testServer = ServerFactory.createServer(environment.env());
				base.evaluate();
			}
		};
	}


}
