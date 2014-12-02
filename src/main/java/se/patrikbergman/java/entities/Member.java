package se.patrikbergman.java.entities;

import java.util.ArrayList;
import java.util.List;

public final class Member {
	final String name;
	final List<Instrument> instruments = new ArrayList<>();

	public Member(String name, List<Instrument> instruments) {
		this.name = name;
		this.instruments.addAll(instruments);
	}

	public String getName() {
		return name;
	}

	public List<Instrument> getInstruments() {
		return instruments;
	}

	public void learnedNewInstrument(Instrument instrument) {
		this.instruments.add(instrument);
	}

	public boolean playsInstrument(Instrument instrument) {
		for(Instrument instrument1 : instruments) {
			if(instrument1.getClass().getName() == instrument.getClass().getName())
				return true;
		}
		return false;
	}
}
