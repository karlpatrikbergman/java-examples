package se.patrikbergman.java.guava;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

class Band {
	private final String name;
	private final String description;
	private final int rockFactor;

	public Band(String name, String description, int rockFactor) {
		this.name = Preconditions.checkNotNull(name, "name must not be null");
		this.description = Preconditions.checkNotNull(description, "description must not be null");
		Preconditions.checkArgument((rockFactor > 0 && rockFactor < 11), String.format("rockFacctor must be between 0-10 (%s)", rockFactor));
		this.rockFactor =  rockFactor;
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

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("name", name)
				.add("description", description)
				.add("rockFactor", rockFactor)
				.toString();
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Band that = (Band) o;

		return Objects.equal(this.name, that.name) &&
				Objects.equal(this.description, that.description) &&
				Objects.equal(this.rockFactor, that.rockFactor);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name, description, rockFactor);
	}
}
