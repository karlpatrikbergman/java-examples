package se.patrikbergman.java.mixin.vem;

public interface RockAct {
	int rockFactor = 5;

	default int getRockFactor() {
		return rockFactor;
	}


}
