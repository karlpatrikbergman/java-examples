package se.patrikbergman.java.eight.aggregate;

class Band {
	final String name;
	final String description;
	final int rockFactor;

	Band(String name, String description, int rockFactor) {
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
}
