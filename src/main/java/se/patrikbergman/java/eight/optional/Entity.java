package se.patrikbergman.java.eight.optional;

import java.util.ArrayList;
import java.util.List;

public class Entity {

	/**
	 * Man skulle kunna låta ett band ha nån typ av state. State ändras när bandet
	 * byter namn eller när bandets medlemmar förändras
	 */
	class Band {
		final String initialName;
		String currentName;
		final String description;
		final List<Member> founders;
		List<Member> members = new ArrayList<>();

		public Band(String initialName, String description, List<Member> founders) {
			this.initialName = this.currentName = initialName;
			this.description = description;
			this.founders = founders;
			this.members.addAll(founders);
		}

		public void changeName(String newName) {
			this.currentName = newName;
		}

		public void addMember(Member member) {
			this.members.add(member);
		}

		public void removeMember(Member leavingMember) {
			for(Member member : members) {
				if(member.equals(leavingMember)) {
					members.remove(member);
					return;
				}
			}
		}

		public List<Member> currentMembers() {
			return members;
		}

	}

	class Member {
		final String name;
		List<Instrument> instruments = new ArrayList<>();

		public Member(String name, List<Instrument> instruments) {
			this.name = name;
			this.instruments = instruments;
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

	interface Instrument {
		Sound play(int intensity);
		void thrash();
		boolean isTrashed();
		void mend();
		Brand getBrand();
	}

	public class Guitar implements Instrument {

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

	class Brand {
		final String model;
		final int serialNumber;

		public Brand(String model, int serialNumber) {
			this.model = model;
			this.serialNumber = serialNumber;
		}

		public String getModel() {
			return model;
		}

		public int getSerialNumber() {
			return serialNumber;
		}
	}

	class Sound {
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

}
