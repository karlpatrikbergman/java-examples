package se.patrikbergman.java.mixin.vem;

public interface RockFactorMultiplier extends RockAct {

	default int getRockFactor() {
		return RockAct.super.getRockFactor() * 5;
	}
}
