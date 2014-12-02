package se.patrikbergman.java.entities;

public interface Instrument {
	Sound play(int intensity);
	void thrash();
	boolean isTrashed();
	void mend();
	Brand getBrand();
}
