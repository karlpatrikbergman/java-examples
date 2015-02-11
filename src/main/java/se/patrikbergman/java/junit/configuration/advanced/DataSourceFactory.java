package se.patrikbergman.java.junit.configuration.advanced;

import se.patrikbergman.java.junit.configuration.advanced.environment.Environment;

public final class DataSourceFactory {

	public static final TestDataSource createDataSource(final Environment environment  ) {
		switch (environment) {
			case DEV:
				return new TestDataSource("oracle.jdbc.OracleDriver", "jdbc.dev.patrikbergman.se", "1521", "dataService", "patrik", "bergman");
			case TEST:
				return new TestDataSource("oracle.jdbc.OracleDriver", "jdbc.test.patrikbergman.se", "1521", "dataService", "patrik", "bergman");
			case QA:
				return new TestDataSource("oracle.jdbc.OracleDriver", "jdbc.qa.patrikbergman.se", "1521", "dataService", "patrik", "bergman");
			default:
				return new TestDataSource("oracle.jdbc.OracleDriver", "jdbc.dev.patrikbergman.se", "1521", "dataService", "patrik", "bergman");
		}
	}
}

