package se.patrikbergman.java.eight.option;

import java.util.Optional;

public class Simple {

	public static void main(String args[]) {
		playAround();
	}

	public static void playAround() {
		Guitar guitar = new Guitar("Fender");
		Optional<Instrument> optionalInstrument = Optional.of(guitar);
		Member yngwie = new Member("Yngwie Malmsteen", optionalInstrument);
		yngwie.getInstrument().ifPresent(g -> g.play(10));

		// Should not print anything
		Member jeff = new Member("Jeff Scott Soto", Optional.empty());
		jeff.getInstrument().ifPresent(x -> x.play(1));
	}

	static class Band {
		String name;
		Member member;

		public Band(String name, Member member) {
			this.name = name;
			this.member = member;
		}

		public String getName() {
			return name;
		}

		public Member getMember() {
			return member;
		}
	}

	static class Member {
		String name;
		Optional<Instrument> instrument;

		public Member(String name, Optional<Instrument> instrument) {
			this.name = name;
			this.instrument = instrument;
		}

		public String getName() {
			return name;
		}

		public Optional<Instrument> getInstrument() {
			return instrument;
		}
	}

	static interface Instrument {
		void play(int intensity);

		void thrash();

		String getBrand();
	}

	static class Guitar implements Instrument {
		final String brand;
		private static int nrOfGuitarsMade = 0;
		final int serialNumber;

		Guitar(String brand) {
			this.brand = brand;
			this.serialNumber = ++nrOfGuitarsMade;
		}

		@Override
		public String getBrand() {
			return brand;
		}

		int getSerialNumber() {
			return serialNumber;
		}

		@Override
		public void play(int intensity) {
			log(String.format("play(%s)", intensity));
		}

		@Override
		public void thrash() {
			log("trash");
		}

		void log(String action) {
			System.out.println(String.format("%s.%s() [serial#%s]", this.getClass().getSimpleName(),
					action, serialNumber));
		}
	}
}
