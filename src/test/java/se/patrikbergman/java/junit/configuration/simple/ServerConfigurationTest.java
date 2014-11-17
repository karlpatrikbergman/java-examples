package se.patrikbergman.java.junit.configuration.simple;

import org.junit.Rule;
import org.junit.Test;

public class ServerConfigurationTest {

	@Rule
	public ConfigurationRule configurationRule = new ConfigurationRule();

	@se.patrikbergman.java.junit.configuration.simple.ServerConfiguration(host = "localhost", port = "7001", user = "patrik", password = "multikulti123")
	@Test
	public void localhostTest() {
		System.out.println(ServerConfigurationTest.class.getSimpleName() + " localhost");
		ConfigurationRule.TestServer testServer = configurationRule.getTestServer();
		testServer.connect();
	}

	@se.patrikbergman.java.junit.configuration.simple.ServerConfiguration(host = "199.199.199", port = "8001", user = "John", password = "beatlesforever")
	@Test
	public void remoteServerTest() {
		System.out.println(ServerConfigurationTest.class.getSimpleName() + " remote server");
		ConfigurationRule.TestServer testServer = configurationRule.getTestServer();
		testServer.connect();
	}
}
