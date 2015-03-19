package se.patrikbergman.java.mockito;

import java.util.Collection;
import java.util.Optional;

class FlowerService {
	private final Collection<Flower> flowers;

	public FlowerService(Collection<Flower> flowers) {
		this.flowers = flowers;
	}

	public void makeFlowersBlossom() {
		flowers.stream().forEach(Flower::blossom);
	}

	/**
	 * TODO: Implement properly
	 */
	public Flower getMostBeautifulFlower() {
		Optional<Flower> firstElement = flowers.stream().findFirst();
		return firstElement.get();
	}
}
