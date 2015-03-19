package se.patrikbergman.java.mockito;

import java.util.List;

class AnimalService {

	private final List<Animal> animals;

	public AnimalService(List<Animal> animals) {
		this.animals = animals;
	}

	public void moveAnimals() {
		animals.stream().forEach(Animal::move);
	}

	/**
	 * TODO: Implement properly
	 */
	public Animal getOldestAnimal() {
		return animals.get(0);
	}
}
