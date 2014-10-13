package se.patrikbergman.java.comparable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Band implements Comparable<Band> {
	private final String name;
	private final int rockFactor;

	public String getName() {
		return name;
	}

	public int getRockFactor() {
		return rockFactor;
	}

	private Band(Builder builder) {
		name = builder.name;
		rockFactor = builder.rockFactor;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Band)) {
			return false;
		}
		Band n = (Band) o;
		return n.name.equals(name) && n.rockFactor == rockFactor;
	}

	@Override
	public int hashCode() {
		return 31*name.hashCode() + new Integer(rockFactor).hashCode();
	}

	/**
	 * The compareTo method compares the receiving object with the specified object and
	 * returns a negative integer, 0, or a positive integer depending on whether the receiving
	 * object is less than, equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(Band band) {
		int rockFactorCompare = band.getRockFactor() - this.rockFactor;
		return (rockFactorCompare != 0) ? rockFactorCompare : name.compareTo(band.getName());
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public static final class Builder {
		private String name;
		private int rockFactor;

		public Builder() {
		}

		public Builder name(String name) {
			if(name == null) {
				throw new NullPointerException("Name cannot be null");
			}
			this.name = name;
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
}
