package se.patrikbergman.java.eight.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Foo {

	public static void main(String args[]) {

		Guitar guitar = new Guitar("Fender");
		List<Instrument> instruments = new ArrayList<>();
		instruments.add(guitar);

		Predicate<Instrument> p = new Predicate<Instrument>() {
			@Override
			public boolean test(Instrument instrument) {
				return instrument.getBrand().equals("Fender");
			}
		};

		Function<Instrument, String> f = new Function<Instrument, String>() {
			@Override
			public String apply(Instrument instrument) {
				return instrument.getBrand();
			}
		};

		Consumer<String> c = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		};

		processInstruments(instruments, p, f, c);

	}

	public static void processInstruments(
			List<Instrument> instruments,
			Predicate<Instrument> tester,
			Function<Instrument, String> mapper,
			Consumer<String> block) {
		for (Instrument instrument : instruments) {
			if (tester.test(instrument)) {
				String data = mapper.apply(instrument);
				block.accept(data);
			}
		}
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
			System.out.println(String.format("%s.%s() [#%s]", this.getClass().getSimpleName(),
					action, serialNumber));
		}
	}
}
