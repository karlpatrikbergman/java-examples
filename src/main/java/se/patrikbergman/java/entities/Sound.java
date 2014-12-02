package se.patrikbergman.java.entities;

public final class Sound {
	final int level;
	final String description;

	public Sound(int level, String description) {
		this.level = level;
		this.description = description;
	}

	public int getLevel() {
		return level;
	}

	public String getDescription() {
		return description;
	}
}
