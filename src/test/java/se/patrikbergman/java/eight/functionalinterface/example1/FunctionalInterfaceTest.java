package se.patrikbergman.java.eight.functionalinterface.example1;

import org.junit.Test;

public class FunctionalInterfaceTest {

	@Test
	public void createSwimmingCreature() {
		SwimmingCreature swimmingSwimmingCreature = new SwimmingCreature();
		swimmingSwimmingCreature.swim();
	}

	@Test
	public void createSuperCreature() {
		SuperCreature superCreature = new SuperCreature();
		superCreature.fly();
		superCreature.swim();
		superCreature.run();
	}
}
