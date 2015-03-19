package se.patrikbergman.java.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


public class NatureServiceWithMockitoTest {

	private AnimalService animalService;
	private FlowerService flowerService;
	private NatureService natureService = new NatureService(animalService, flowerService);

	@Before
	public void setup() {
		animalService = Mockito.mock(AnimalService.class);
		flowerService = Mockito.mock(FlowerService.class);
		natureService = new NatureService(animalService, flowerService);
	}

	@Test
	public void test() {
		when(animalService.getOldestAnimal()).
		thenReturn(new Animal.Builder()
			.name("TestWolf")
			.description("TestWolf description")
			.build());
		final Animal animal = natureService.getOldestAnimalInNature();
		assertNotNull(animal);
		System.out.println(animal);
	}

}
