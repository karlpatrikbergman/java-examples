package se.patrikbergman.java.mixin.sam;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testCreateSamVehicle() {
		SamVehicle samVehicle = createSamVehicle();
		samVehicle.start();
	}

	/**
	 * Instantiate using Lambda expression. Only works single method interfaces?
	 */
	private SamVehicle createSamVehicle() {
		return () -> { System.out.println("Starting vehicle"); };
	};

	@Test
	public void testCreateVehicle() {
		Vehicle vehicle = createVehicle();
		vehicle.start();
		vehicle.stop();
	}

	private Vehicle createVehicle() {
		return new Vehicle() {
			@Override
			public void start() {
				System.out.println("Starting vehicle");
			}

			@Override
			public void stop() {
				System.out.println("Stopping vehicle");
			}
		};
	};
}
