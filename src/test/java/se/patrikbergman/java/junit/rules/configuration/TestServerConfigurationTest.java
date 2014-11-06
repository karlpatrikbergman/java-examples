package se.patrikbergman.java.junit.rules.configuration;

import org.junit.Rule;
import org.junit.Test;

public class TestServerConfigurationTest {

	@Rule
	public ConfigurationRule configurationRule = new ConfigurationRule();

	@ServerConfiguration(host = "localhost", port = "7001", user = "patrik", password = "multikulti123")
	@Test
	public void localhostTest() {
		System.out.println(TestServerConfigurationTest.class.getSimpleName() + " localhost");
		ConfigurationRule.TestServer testServer = configurationRule.getTestServer();
		testServer.connect();
	}

	@ServerConfiguration(host = "199.199.199", port = "8001", user = "John", password = "beatlesforever")
	@Test
	public void remoteServerTest() {
		System.out.println(TestServerConfigurationTest.class.getSimpleName() + " remote server");
		ConfigurationRule.TestServer testServer = configurationRule.getTestServer();
		testServer.connect();
	}
}
