package se.patrikbergman.java.evilextendsis2.solution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SimpleStack<T> implements Stack<T> {
	private int pointer = 0;
	private final List<T> data = new ArrayList<>();

	public void push(T item) {
		data.add(pointer++, item);
	}

	public T pop() {
		return data.remove(--pointer);
	}

	/** Not inherited by ExtendedStack. Delegation used instead **/
	public void pushMany(Iterator<T> items) {
		items.forEachRemaining(this::push);
	}
}