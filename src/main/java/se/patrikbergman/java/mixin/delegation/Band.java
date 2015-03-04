package se.patrikbergman.java.mixin.delegation;

class Band implements Bookable{
	private final String name;
	private final String description;
	private final int rockFactor;
	private final BookingService bookingService;

	private Band(Builder builder) {
		name = builder.name;
		description = builder.description;
		rockFactor = builder.rockFactor;
		bookingService = builder.bookingService;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getRockFactor() {
		return rockFactor;
	}

	/**
	 * Boiler plate code. Could in practice be many methods just delegating to some other class
	 * @return
	 */
	@Override
	public String book() {
		return bookingService.book(this.name);
	}

	public static final class Builder {
		private String name;
		private String description;
		private int rockFactor;
		private BookingService bookingService;

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

		public Builder rockFactor(int rockFactor) {
			this.rockFactor = rockFactor;
			return this;
		}

		public Builder bookingService(BookingService bookingService) {
			this.bookingService = bookingService;
			return this;
		}

		public Band build() {
			return new Band(this);
		}
	}
}
