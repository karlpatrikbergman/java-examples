package se.patrikbergman.java.mixin.delegation;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

class Band implements Bookable{
	private final String name;
	private final String description;
	private final int rockFactor;
	private final BookingService bookingService;
	private String bookingId;

	private Band(Builder builder) {
		Preconditions.checkNotNull(builder.name, "Band name cannot be null");
		Preconditions.checkNotNull(builder.bookingService, "BookingService cannot be null");

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

	public void play() {
		System.out.println(String.format("%s is playing, rock factor is %s", name, rockFactor));
	}

	/**
	 * Boiler plate code. Could in practice be many methods just delegating to some other class
	 * @return
	 */
	@Override
	public String book() {
		bookingService.cancel(bookingId);
		this.bookingId = bookingService.book(this.name);
		return bookingId;
	}

	@Override
	public void cancel() {
		bookingService.cancel(bookingId);
	}

	@Override
	public boolean confirmBooking() {
		return bookingService.confirmBooking(bookingId);
	}

	@Override
	public String getBookingId() {
		return bookingId;
	}

	@Override
	public void perform() {
		play();
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

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	 public boolean equals(Object obj) {
		if (obj instanceof Band == false) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		final Band band = (Band) obj;
		return new EqualsBuilder()
			.append(this.name, band.name)
			.append(this.description, band.description)
			.append(this.rockFactor, band.rockFactor)
			.isEquals();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
