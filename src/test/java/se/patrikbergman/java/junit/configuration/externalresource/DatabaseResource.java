package se.patrikbergman.java.junit.configuration.externalresource;

import org.junit.rules.ExternalResource;

public class DatabaseResource extends ExternalResource {

	private final TestDataSource dataSource;

	public DatabaseResource() {
		this.dataSource = new TestDataSource.Builder()
			.driverName("oracle.jdbc.OracleDriver")
			.serverDnsName("jdbc.test.patrikbergman.se")
			.portNumber("1521")
			.serviceName("databaseService")
			.build();
		System.out.println(DatabaseResource.class.getSimpleName() + " constructor");
	}

	@Override
	protected void before() throws Throwable {
		System.out.println(DatabaseResource.class.getSimpleName() + " before, setup datasource");
	}

	@Override
	protected void after() {
		System.out.println(DatabaseResource.class.getSimpleName() + " after, teardown datasource");
	}

	public TestDataSource getDataSource() {
		return dataSource;
	}

}
