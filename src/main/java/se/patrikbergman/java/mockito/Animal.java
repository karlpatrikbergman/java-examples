package se.patrikbergman.java.mockito;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

class Animal {
	private final String name;
	private final String description;

	private Animal(Builder builder) {
		name = builder.name;
		description = builder.description;
	}

	public void move() {
		System.out.printf("%s is moving\n", name);
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public static final class Builder {
		private String name;
		private String description;

		public Builder() {
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Animal build() {
			return new Animal(this);
		}
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
