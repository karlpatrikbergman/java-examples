package se.patrikbergman.java.junit.configuration.rulechaintest;

import com.google.common.base.Preconditions;

public class CustomerBean {
	private final CustomerDataSource dataSource;

	public CustomerBean(CustomerDataSource dataSource) {
		Preconditions.checkNotNull(dataSource);
		this.dataSource = dataSource;
	}

	public CustomerInfo fetchCustomerInfo(final int customerId) {
		return dataSource.getCustomerInfo(0);
	}
}
