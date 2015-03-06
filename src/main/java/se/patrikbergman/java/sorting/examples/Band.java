package se.patrikbergman.java.sorting.examples;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

class Band {
	private final String name;
	private final int RockFactor;

	public Band(String name, int rockFactor) {
		this.name = name;
		RockFactor = rockFactor;
	}

	public String getName() {
		return name;
	}

	public int getRockFactor() {
		return RockFactor;
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
