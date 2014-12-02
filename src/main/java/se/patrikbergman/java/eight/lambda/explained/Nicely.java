package se.patrikbergman.java.eight.lambda.explained;


import se.patrikbergman.java.entities.Brand;
import se.patrikbergman.java.entities.Guitar;
import se.patrikbergman.java.entities.Instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Nicely {

	public static void main(String args[]) {

		Brand brand = new Brand("Fender");
		Guitar guitar = new Guitar(brand);
		List<Instrument> instruments = new ArrayList<>();
		instruments.add(guitar);

		Predicate<Instrument> p = new Predicate<Instrument>() {
			@Override
			public boolean test(Instrument instrument) {
				return instrument.getBrand().getModel().equals("Fender");
			}
		};

		Function<Instrument, String> f = new Function<Instrument, String>() {
			@Override
			public String apply(Instrument instrument) {
				return instrument.getBrand().getModel();
			}
		};

		Consumer<String> c = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		};

		processInstruments(instruments, p, f, c);

		//Equals

		processInstruments(
				instruments,
				i -> i.getBrand().getModel().equals("Fender"),
				i -> i.getBrand().getModel(),
				model -> System.out.println(model));

	}

	public static void processInstruments(
			List<Instrument> instruments,
			Predicate<Instrument> tester,
			Function<Instrument, String> mapper,
			Consumer<String> block) {
		//Här borde man kunna använda stream().map()
		for (Instrument instrument : instruments) {
			if (tester.test(instrument)) {
				String data = mapper.apply(instrument);
				block.accept(data);
			}
		}
	}

}
