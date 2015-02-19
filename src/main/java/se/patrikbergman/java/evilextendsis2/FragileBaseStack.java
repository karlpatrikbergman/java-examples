package se.patrikbergman.java.evilextendsis2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FragileBaseStack<T>  {
	private int pointer = 0;
	private final List<T> data = new ArrayList<>();

	public void push(T item) {
		data.add(pointer++, item);
	}

	public T pop() {
		return data.remove(--pointer);
	}

	/** Inherited by ExtendedStack. Uses method push, and is therefore fragile if changed.  **/
	public void pushMany(Iterator<T> items) {
		items.forEachRemaining(item -> push(item));
	}
}

/*
//New implementation that will cause classes derived from FragileBaseStack to fail
class FragileBaseStack
{   private int stack_pointer = -1;
	private Object[] stack = new Object[1000];
	public void push( Object article )
	{   assert stack_pointer < stack.length;
		stack[ ++stack_pointer ] = article;
	}
	public Object pop()
	{   assert stack_pointer >= 0;
		return stack[ stack_pointer-- ];
	}
	public void push_many( Object[] articles )
	{   assert (stack_pointer + articles.length) < stack.length;
		System.arraycopy(articles, 0, stack, stack_pointer+1,
				articles.length);
		stack_pointer += articles.length;
	}
}
*/