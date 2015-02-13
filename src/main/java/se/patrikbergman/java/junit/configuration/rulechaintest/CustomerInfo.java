package se.patrikbergman.java.junit.configuration.rulechaintest;

public class CustomerInfo {

	private final int id;
	private final String firstName;
	private final String lastName;
	private final String mobile;
	private final String personNummer;

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public String getPersonNummer() {
		return personNummer;
	}

	private CustomerInfo(Builder builder) {
		id = builder.id;
		firstName = builder.firstName;
		lastName = builder.lastName;
		mobile = builder.mobile;
		personNummer = builder.personNummer;
	}


	public static final class Builder {
		private int id;
		private String firstName;
		private String lastName;
		private String mobile;
		private String personNummer;

		public Builder() {
		}

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder mobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		public Builder personNummer(String personNummer) {
			this.personNummer = personNummer;
			return this;
		}

		public CustomerInfo build() {
			return new CustomerInfo(this);
		}
	}
}
