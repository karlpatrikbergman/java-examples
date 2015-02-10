package se.patrikbergman.java.evilextendsis;

class HeavyMetalBand implements Band {
	private final String name;
	private int rockFactor = 100;

	HeavyMetalBand(final String name, final int currentShape) {
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
