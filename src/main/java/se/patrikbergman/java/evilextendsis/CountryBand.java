package se.patrikbergman.java.evilextendsis;

class CountryBand implements Band {
	private final String name;
	private int rockFactor = 50;

	CountryBand(final String name, final int currentShape) {
		this.name = name;
		this.rockFactor += currentShape;
	}

	@Override
	public int play() {
		return rockFactor;
	}

	@Override
	public String getName() {
		return name;
	}
}
