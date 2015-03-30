package se.patrikbergman.java.junit.configuration.rulestest;

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
		final StringBuffer sb = new StringBuffer("TestDataSource{");
		sb.append("driverName='").append(driverName).append('\'');
		sb.append(", serverDnsName='").append(serverDnsName).append('\'');
		sb.append(", portNumber='").append(portNumber).append('\'');
		sb.append(", serviceName='").append(serviceName).append('\'');
		sb.append(", userName='").append(userName).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
