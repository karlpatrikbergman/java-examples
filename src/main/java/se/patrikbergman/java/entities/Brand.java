package se.patrikbergman.java.entities;

public final class Brand {
	final String model;

	public Brand(final String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Brand brand = (Brand) o;
		return !(model != null ? !model.equals(brand.model) : brand.model != null);

	}

	@Override
	public int hashCode() {
		return model != null ? model.hashCode() : 0;
	}
}
