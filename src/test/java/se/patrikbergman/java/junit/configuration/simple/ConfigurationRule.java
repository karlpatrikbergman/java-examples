package se.patrikbergman.java.junit.configuration.simple;

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
				final ServerConfiguration serverConf = description.getAnnotation(ServerConfiguration.class);
				testServer = new TestServer(serverConf.host(), serverConf.port(), serverConf.user(), serverConf.password());
				base.evaluate();
			}
		};
	}

	public class TestServer {
		private final String host;
		private final String port;
		private final String user;
		private final String password;

		public TestServer(String host, String port, String user, String password) {
			this.host = host;
			this.port = port;
			this.user = user;
			this.password = password;
		}

		public void connect() {
			System.out.println(String.format("%s connecting to http://%s:%s as user %s/%s",
					TestServer.class.getSimpleName(), host, port, user, password));
		}

		public String getHost() {
			return host;
		}

		public String getPort() {
			return port;
		}

		public String getUser() {
			return user;
		}

		public String getPassword() {
			return password;
		}

		@Override
		public String toString() {
			return "ServerConfig{" +
					"host='" + host + '\'' +
					", port='" + port + '\'' +
					", user='" + user + '\'' +
					", password='" + password + '\'' +
					'}';
		}
	}
}
