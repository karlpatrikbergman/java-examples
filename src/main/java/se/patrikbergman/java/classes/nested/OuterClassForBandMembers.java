package se.patrikbergman.java.classes.nested;

public class OuterClassForBandMembers {

	private final String tourMemory = "We had great burgers in Stockholm in 2002";

	static final class StaticBandMember {
		private final String name;

		public StaticBandMember(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public String getTourMemory() {
			//Compile error
//			return tourMemory;
			return "I don't remember";
		}
	}

	public final class NestedBandMember {
		private final String name;

		public NestedBandMember(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public String getTourMemory() {
			return tourMemory;
		}
	}
}
