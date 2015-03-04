package se.patrikbergman.java.evilextendsis2;

/**
 * Inherits pushMany(), no local implementation forced (no interface)
 */
public class ExtendedStack<T> extends FragileBaseStack<T> {

	private int maxCounter, currentSize = 0;

	/**
	 * Keep track of max items so far.
	 * Inherited pushMany() calls parent version of push() -->
	 *
	 * When inherited pushMany() is used, this method is called,
	 * and maxCounter is correctly updated.
	 *
	 * If inherited pushMany() is changed so that push() in parent
	 * is no longer called, this class will fail to work. currentSize
	 * and maxCounter will not be updated correctly.
	 */
	@Override
	public void push(T item) {
		System.out.println(ExtendedStack.class.getSimpleName() + ".push() (incrementing counter)");
		if(++currentSize > maxCounter) {
			maxCounter = currentSize;
		}
		super.push(item);
	}

	@Override
	public T pop() {
		--currentSize;
		return super.pop();
	}

	public int getMaxSizeSoFar() {
		return maxCounter;
	}
}
