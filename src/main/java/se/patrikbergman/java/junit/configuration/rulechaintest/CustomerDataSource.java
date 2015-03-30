package se.patrikbergman.java.junit.configuration.rulechaintest;

public class CustomerDataSource {
	private final String driverName;
	private final String serverDnsName;
	private final String portNumber;
	private final String serviceName;
	private final String userName;
	private final String password;

	public CustomerDataSource(String driverName, String serverDnsName, String portNumber, String serviceName, String userName, String password) {
		this.driverName = driverName;
		this.serverDnsName = serverDnsName;
		this.portNumber = portNumber;
		this.serviceName = serviceName;
		this.userName = userName;
		this.password = password;
	}

	public CustomerInfo getCustomerInfo(final int customerId) {
		return new CustomerInfo.Builder()
				.id(0)
				.firstName("Patrik")
				.lastName("Bergman")
				.mobile("0737-855123")
				.personNummer("700303-8911")
				.build();

	}

	private CustomerDataSource(Builder builder) {
		driverName = builder.driverName;
		serverDnsName = builder.serverDnsName;
		portNumber = builder.portNumber;
		serviceName = builder.serviceName;
		userName = builder.userName;
		password = builder.password;
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
		return String.format("jdbc:%s:thin:@%s:%s/%s", driverName, serverDnsName, portNumber, serviceName);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("CustomerDataSource{");
		sb.append("driverName='").append(driverName).append('\'');
		sb.append(", serverDnsName='").append(serverDnsName).append('\'');
		sb.append(", portNumber='").append(portNumber).append('\'');
		sb.append(", serviceName='").append(serviceName).append('\'');
		sb.append(", userName='").append(userName).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append('}');
		return sb.toString();
	}

	public static final class Builder {
		private String driverName;
		private String serverDnsName;
		private String portNumber;
		private String serviceName;
		private String userName;
		private String password;

		public Builder() {
		}

		public Builder driverName(String driverName) {
			this.driverName = driverName;
			return this;
		}

		public Builder serverDnsName(String serverDnsName) {
			this.serverDnsName = serverDnsName;
			return this;
		}

		public Builder portNumber(String portNumber) {
			this.portNumber = portNumber;
			return this;
		}

		public Builder serviceName(String serviceName) {
			this.serviceName = serviceName;
			return this;
		}

		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public CustomerDataSource build() {
			return new CustomerDataSource(this);
		}
	}
}
