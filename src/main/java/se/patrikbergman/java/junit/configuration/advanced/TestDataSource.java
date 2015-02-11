package se.patrikbergman.java.junit.configuration.advanced;

import com.google.common.base.Objects;

public class TestDataSource {
	private final String driverName;
	private final String serverDnsName;
	private final String portNumber;
	private final String serviceName;
	private final String userName;
	private final String password;

	public TestDataSource(String driverName, String serverDnsName, String portNumber, String serviceName, String userName, String password) {
		this.driverName = driverName;
		this.serverDnsName = serverDnsName;
		this.portNumber = portNumber;
		this.serviceName = serviceName;
		this.userName = userName;
		this.password = password;
	}

	public String getDriverName() {
		return driverName;
	}

	public String getServerDnsName() {
		return serverDnsName;
	}

	public String getPortNumber() {
		return portNumber;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getConnection() {
		return this.toString();
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("driverName", driverName)
				.add("serverDnsName", serverDnsName)
				.add("portNumber", portNumber)
				.add("serviceName", serviceName)
				.add("userName", userName)
				.add("password", password)
				.toString();
	}
}
