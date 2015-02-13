package se.patrikbergman.java.junit.configuration.rulestest;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import se.patrikbergman.java.junit.configuration.rulestest.rule.ClassConfigurationRule;
import se.patrikbergman.java.junit.configuration.rulestest.rule.MethodConfigurationRule;
import se.patrikbergman.java.junit.configuration.rulestest.rule.annotations.ClassEnvironment;
import se.patrikbergman.java.junit.configuration.rulestest.rule.annotations.MethodEnvironment;

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
