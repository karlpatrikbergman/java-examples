package se.patrikbergman.java.junit.rules.externalresource;

import org.junit.rules.ExternalResource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class DatabaseResource extends ExternalResource {

	private final DataSource dataSource;

	public DatabaseResource() {
		this.dataSource = setupDataSource();
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

	public DataSource getDataSource() {
		return dataSource;
	}

	private DataSource setupDataSource() {
		return new DataSource() {
			@Override
			public Connection getConnection() throws SQLException {
				return null;
			}

			@Override
			public Connection getConnection(String username, String password) throws SQLException {
				return null;
			}

			@Override
			public PrintWriter getLogWriter() throws SQLException {
				return null;
			}

			@Override
			public void setLogWriter(PrintWriter out) throws SQLException {

			}

			@Override
			public void setLoginTimeout(int seconds) throws SQLException {

			}

			@Override
			public int getLoginTimeout() throws SQLException {
				return 0;
			}

			@Override
			public Logger getParentLogger() throws SQLFeatureNotSupportedException {
				return null;
			}

			@Override
			public <T> T unwrap(Class<T> iface) throws SQLException {
				return null;
			}

			@Override
			public boolean isWrapperFor(Class<?> iface) throws SQLException {
				return false;
			}
		};
	}
}
