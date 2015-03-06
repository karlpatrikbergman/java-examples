package se.patrikbergman.java.eight.functionalinterface;

import org.junit.Test;

public class FunctionalInterfaceTest {

	@Test
	public void testSwimmer() {
		Swimmer swimmer = new Swimmer() {
			@Override
			public void swim() {
				System.out.println("I'm swimming");
			}
		};
		executeSwimmer(swimmer);
	}

	private void executeSwimmer(Swimmer swimmer) {
		swimmer.swim();
	}
//
//	@Test
//	public void testFlyer() {
//		Flyer flyer = new Flyer() {
//			@Override
//			public void fly() {
//				System.out.println("I'm flying");
//			}
//		};
//		executeFlyer(flyer);
//	}
//
//	private void executeFlyer(Flyer flyer) {
//		flyer.fly();
//	}
}
