package se.patrikbergman.java.ooutility;

import com.google.common.collect.ImmutableList;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * http://www.javacodegeeks.com/2014/09/oop-alternative-to-ooutility-classes.html
 */
public class FileLines implements List<String> {
	private final ImmutableList<String> lines;

	public FileLines(UnicodeFile unicodeFile) throws IOException {
		lines = ImmutableList.<String>builder()
			.addAll( Files.readAllLines(unicodeFile.getPath(), unicodeFile.getCharset()))
			.build();
	}

	public ImmutableList<String> getLines() {
		return lines;
	}

	@Override
	public int size() {
		return lines.size();
	}

	@Override
	public boolean isEmpty() {
		return lines.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return lines.contains(o);
	}

	@Override
	public Iterator<String> iterator() {
		return lines.iterator();
	}

	@Override
	public Object[] toArray() {
		return lines.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return lines.toArray(a);
	}

	@Deprecated
	@Override
	public boolean add(String s) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return lines.containsAll(c);
	}

	@Deprecated
	@Override
	public boolean addAll(Collection<? extends String> c) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public boolean addAll(int index, Collection<? extends String> c) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String get(int index) {
		return lines.get(index);
	}

	@Deprecated
	@Override
	public String set(int index, String element) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public void add(int index, String element) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public String remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int indexOf(Object o) {
		return lines.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return lines.indexOf(o);
	}

	@Override
	public ListIterator<String> listIterator() {
		return lines.listIterator();
	}

	@Override
	public ListIterator<String> listIterator(int index) {
		return lines.listIterator(index);
	}

	@Override
	public List<String> subList(int fromIndex, int toIndex) {
		return lines.subList(fromIndex, toIndex);
	}

	@Override
	public String toString() {
		return "FileLines{" +
				"lines=" + lines +
				'}';
	}
}
