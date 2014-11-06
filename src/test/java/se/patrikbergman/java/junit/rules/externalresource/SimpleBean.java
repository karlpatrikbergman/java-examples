package se.patrikbergman.java.junit.rules.externalresource;

import javax.sql.DataSource;

public class SimpleBean {
	private final DataSource dataSource;

	public SimpleBean(DataSource dataSource) {
		if(dataSource == null) {
			throw new NullPointerException("Argument dataSource was null");
		}
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
}
