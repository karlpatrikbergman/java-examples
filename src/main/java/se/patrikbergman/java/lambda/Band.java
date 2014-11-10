package se.patrikbergman.java.lambda;

import com.google.common.base.Objects;

public class Band {
	final String name;
	final String description;
	final int rockFactor;

	public Band(String name, String description, int rockFactor) {
		this.name = name;
		this.description = description;
		this.rockFactor = rockFactor;
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
}
