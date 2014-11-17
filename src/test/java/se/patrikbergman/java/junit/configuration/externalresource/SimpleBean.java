package se.patrikbergman.java.junit.configuration.externalresource;

import com.google.common.base.Preconditions;

public class SimpleBean {
	private final TestDataSource dataSource;

	public SimpleBean(TestDataSource dataSource) {
		Preconditions.checkNotNull(dataSource);
		this.dataSource = dataSource;
	}

	protected TestDataSource getDataSource() {
		return dataSource;
	}

	public void executeDataSourceDependentCommand() {
		System.out.println(String.format("Executing data source dependent command. %s", dataSource.getConnection()));
	}
}
