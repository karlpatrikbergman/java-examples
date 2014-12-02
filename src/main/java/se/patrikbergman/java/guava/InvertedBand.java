package se.patrikbergman.java.guava;

import com.google.common.base.Objects;

class InvertedBand {
	private final String invertedName;
	private final String invertedDescription;
	private final int intvertedRockFactor;

	public InvertedBand(String invertedName, String invertedDescription, int intvertedRockFactor) {
		this.invertedName = invertedName;
		this.invertedDescription = invertedDescription;
		this.intvertedRockFactor = intvertedRockFactor;
	}

	public String getInvertedName() {
		return invertedName;
	}

	public String getInvertedDescription() {
		return invertedDescription;
	}

	public int getIntvertedRockFactor() {
		return intvertedRockFactor;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("invertedName", invertedName)
				.add("invertedDescription", invertedDescription)
				.add("intvertedRockFactor", intvertedRockFactor)
				.toString();
	}
}
