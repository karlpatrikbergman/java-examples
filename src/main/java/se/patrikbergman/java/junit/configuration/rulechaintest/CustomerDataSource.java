package se.patrikbergman.java.junit.configuration.rulechaintest;

import com.google.common.base.Objects;

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
		return Objects.toStringHelper(this)
				.add("driverName", driverName)
				.add("serverDnsName", serverDnsName)
				.add("portNumber", portNumber)
				.add("serviceName", serviceName)
				.add("userName", userName)
				.add("password", password)
				.toString();
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
