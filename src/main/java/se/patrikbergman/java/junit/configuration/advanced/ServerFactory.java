package se.patrikbergman.java.junit.configuration.advanced;

import se.patrikbergman.java.junit.configuration.advanced.environment.Environment;

public final class ServerFactory {

	public static final TestServer createServer(final Environment env  ) {
		switch (env) {
			case DEV:
				return new TestServer("dev.atg.se", "6001", "dev-user", "hokuspokus");
			case TEST:
				return new TestServer("test.atg.se", "7001", "test-user", "abrakadabra");
			case QA:
				return new TestServer("qa.atg.se", "8001", "qa-user", "simsalabim");
			default:
				throw new IllegalArgumentException("Failed to create test server for environment " + env.getName());
		}
	}
}
