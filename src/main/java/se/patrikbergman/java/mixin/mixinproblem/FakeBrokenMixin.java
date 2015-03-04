package se.patrikbergman.java.mixin.mixinproblem;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public interface FakeBrokenMixin {
	static Map<FakeBrokenMixin, String> backingMap
			= Collections.synchronizedMap(new WeakHashMap<FakeBrokenMixin, String>());

	default String getName()  { return backingMap.get(this); }
	default void setName(String name)  { backingMap.put(this, name); }
}
