package se.patrikbergman.java.evilextendsis2.solution;

import java.util.Iterator;

public class ExtendedStack<T> implements Stack<T> {

	private int maxCounter, currentSize = 0;
	private final SimpleStack<T> simpleStack = new SimpleStack<>(); //Delegation instead of inheritance

	@Override
	public void push(T item) {
		if(++currentSize > maxCounter) {
			maxCounter = currentSize;
		}
		simpleStack.push(item);
	}

	@Override
	public T pop() {
		--currentSize;
		return simpleStack.pop();
	}

	/**
	 *	Using an interface forces an implementation, and is therefore less fragile (compare with FragileBaseStack)
	 */
	@Override
	public void pushMany(Iterator<T> iterator) {
		int iteratorLength = 0;
		for ( ; iterator.hasNext() ; ++iteratorLength ) {
			iterator.next();
		}
		if( currentSize + iteratorLength > maxCounter ) {
			maxCounter = currentSize + iteratorLength;
		}
		simpleStack.pushMany(iterator);
	}

	public int getMaxSizeSoFar() {
		return maxCounter;
	}

}
