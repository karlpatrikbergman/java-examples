package se.patrikbergman.java.junit.rules.configuration2;

import org.junit.Rule;
import org.junit.Test;

public class EnvironmentConfigurationTest {

	@Rule
	public final ConfigurationRule configurationRule = new ConfigurationRule();

	@Environment(env = Env.DEV)
	@Test
	public void testInDevelopmentEnvironment() {
		TestServer testServer = configurationRule.getTestServer();
		testServer.connect();
	}

	@Environment(env = Env.TEST)
	@Test
	public void testInTestEnvironment() {
		TestServer testServer = configurationRule.getTestServer();
		testServer.connect();
	}

	@Environment(env = Env.QA)
	@Test
	public void testInQaEnvironment() {
		TestServer testServer = configurationRule.getTestServer();
		testServer.connect();
	}
}
