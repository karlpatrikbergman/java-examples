package se.patrikbergman.java.mixin.eightstyle;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

class Band {
	private final String name;
	private final String description;
	private final int rockFactor;
	private String bookingId;

	private Band(Builder builder) {
		Preconditions.checkNotNull(builder.name, "Band name cannot be null");

		name = builder.name;
		description = builder.description;
		rockFactor = builder.rockFactor;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getRockFactor() {
		return rockFactor;
	}

	public void play() {
		System.out.println(String.format("%s is playing, rock factor is %s", name, rockFactor));
	}


	public static final class Builder {
		private String name;
		private String description;
		private int rockFactor;

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

		public Builder rockFactor(int rockFactor) {
			this.rockFactor = rockFactor;
			return this;
		}

		public Band build() {
			return new Band(this);
		}
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	 public boolean equals(Object obj) {
		if (obj instanceof Band == false) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		final Band band = (Band) obj;
		return new EqualsBuilder()
			.append(this.name, band.name)
			.append(this.description, band.description)
			.append(this.rockFactor, band.rockFactor)
			.isEquals();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
