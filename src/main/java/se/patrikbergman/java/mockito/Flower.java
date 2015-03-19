package se.patrikbergman.java.mockito;

class Flower {
	private final String name;
	private final String description;

	private Flower(Builder builder) {
		name = builder.name;
		description = builder.description;
	}

	public void blossom() {
		System.out.printf("%s is blossoming\n", name);
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public static final class Builder {
		private String name;
		private String description;

		public Builder() {
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Flower build() {
			return new Flower(this);
		}
	}
}
