package se.patrikbergman.java.entities;

public final class Guitar implements Instrument {

	private boolean isTrashed = false;
	private final Brand brand;

	public Guitar(Brand brand) {
		this.brand = brand;
	}

	@Override
	public Sound play(int intensity) {
		return new Sound(intensity*5, "Distorted");
	}

	@Override
	public void thrash() {
		this.isTrashed = true;
	}

	@Override
	public boolean isTrashed() {
		return isTrashed;
	}

	@Override
	public void mend() {
		this.isTrashed = false;
	}

	@Override
	public Brand getBrand() {
		return brand;
	}
}
