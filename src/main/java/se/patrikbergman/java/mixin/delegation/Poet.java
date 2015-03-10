package se.patrikbergman.java.mixin.delegation;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Poet implements Bookable {
	private final String name;
	private final String description;
	private final int artFactor;
	private final BookingService bookingService;
	private String bookingId;

	private Poet(Builder builder) {
		Preconditions.checkNotNull(builder.name, "Poet name cannot be null");
		Preconditions.checkNotNull(builder.description, "Poet description cannot be null");
		Preconditions.checkNotNull(builder.bookingService, "BookingService cannot be null");

		name = builder.name;
		description = builder.description;
		artFactor = builder.artFactor;
		bookingService = builder.bookingService;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getArtFactor() {
		return artFactor;
	}

	public void read() {
		System.out.println(String.format("%s is reading poetry, art factor is %s", name, artFactor));
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
		read();
	}

	public static final class Builder {
		private String name;
		private String description;
		private int artFactor;
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

		public Builder artFactor(int artFactor) {
			this.artFactor = artFactor;
			return this;
		}

		public Builder bookingService(BookingService bookingService) {
			this.bookingService = bookingService;
			return this;
		}

		public Poet build() {
			return new Poet(this);
		}
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Poet == false) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		final Poet poet = (Poet) obj;
		return new EqualsBuilder()
				.append(this.name, poet.name)
				.append(this.description, poet.description)
			.append(this.artFactor, poet.artFactor)
			.isEquals();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
