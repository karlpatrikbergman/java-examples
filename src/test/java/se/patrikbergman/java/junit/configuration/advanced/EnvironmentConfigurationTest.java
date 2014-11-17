package se.patrikbergman.java.junit.configuration.advanced;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import se.patrikbergman.java.junit.configuration.advanced.dependencies.TestDataSource;
import se.patrikbergman.java.junit.configuration.advanced.dependencies.TestServer;
import se.patrikbergman.java.junit.configuration.advanced.environment.Environment;
import se.patrikbergman.java.junit.configuration.advanced.rule.ClassConfigurationRule;
import se.patrikbergman.java.junit.configuration.advanced.rule.MethodConfigurationRule;
import se.patrikbergman.java.junit.configuration.advanced.rule.annotations.ClassEnvironment;
import se.patrikbergman.java.junit.configuration.advanced.rule.annotations.MethodEnvironment;

@ClassEnvironment(env = Environment.TEST)
public class EnvironmentConfigurationTest {

	@ClassRule
	public final static ClassConfigurationRule classRule = new ClassConfigurationRule();

	@Rule
	public final MethodConfigurationRule methodRule = new MethodConfigurationRule();

	public EnvironmentConfigurationTest() {
		TestDataSource dataSource = classRule.getDataSource();
		System.out.println(dataSource.getConnection());
	}

	@MethodEnvironment(env = Environment.DEV)
	@Test
	public void testInDevelopmentEnvironment() {
		TestServer testServer = methodRule.getTestServer();
		testServer.connect();
	}

	@MethodEnvironment(env = Environment.TEST)
	@Test
	public void testInTestEnvironment() {
		TestServer testServer = methodRule.getTestServer();
		testServer.connect();
	}

	@MethodEnvironment(env = Environment.QA)
	@Test
	public void testInQaEnvironment() {
		TestServer testServer = methodRule.getTestServer();
		testServer.connect();
	}
}
