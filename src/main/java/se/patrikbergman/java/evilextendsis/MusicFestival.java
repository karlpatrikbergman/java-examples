package se.patrikbergman.java.evilextendsis;

import java.util.Iterator;

class MusicFestival {
	private final String name;
	private final Iterator<Band> lineup; //Not coupled to specific implementation

	MusicFestival(final String name, final Iterator<Band> lineup) {
		this.name = name;
		this.lineup = lineup;
	}

	void run() {
		System.out.printf("Now it's time for %s\n", name);
		lineup.forEachRemaining(band -> System.out.printf("%s played show. Score: %s\n", band.getName(), band.play()));
	}
}
