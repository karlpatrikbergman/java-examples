package se.patrikbergman.java.mockito;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NatureServiceTest {

	private NatureService natureService;

	@Before
	public void setup() {
		List<Animal> animals = new ArrayList<>();
		Collections.addAll(animals,
			new Animal.Builder()
				.name("Fox")
				.description("Fox description")
				.build());

		Collection<Flower> flowers = new LinkedList<>();
		Collections.addAll(flowers,
			new Flower.Builder()
				.name("Rose")
				.description("Rose description")
				.build());

		natureService = new NatureService(
			new AnimalService(animals),
			new FlowerService(flowers));
	}

	@Test
	public void runNature() {
		natureService.makeAnimalsMoveAndFlowersBlossom();
	}

}
