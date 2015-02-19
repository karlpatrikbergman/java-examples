package se.patrikbergman.java.evilextendsis2.solution;

import java.util.Iterator;

public interface Stack<T> {
	void push(T item);
	T pop();
	void pushMany(Iterator<T> iterator);
}
