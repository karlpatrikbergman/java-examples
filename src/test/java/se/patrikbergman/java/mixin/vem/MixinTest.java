package se.patrikbergman.java.mixin.vem;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MixinTest {

	@Test
	public void createOrdinaryRockAct() {
		RockAct ordinaryRockAct = new OrdinaryRockAct();
		assertEquals(5, ordinaryRockAct.getRockFactor());
	}

	@Test
	public void createExtraSpecialRockAct() {
		RockAct extraSpecialRockAct = new ExtraSpecialRockAct();
		System.out.println(extraSpecialRockAct.getRockFactor());
	}
}
