package se.patrikbergman.java.ooutility;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.javacodegeeks.com/2014/09/oop-alternative-to-ooutility-classes.html
 */
public class Trimmed {
	private final ImmutableList<String> trimmedStrings;

	public Trimmed(FileLines fileLines) {
		trimmedStrings = trim(fileLines.getLines());
	}

	public ImmutableList<String> getTrimmedStrings() {
		return trimmedStrings;
	}

	private ImmutableList<String> trim(ImmutableList<String> source) {
		final List<String> temp = new ArrayList<String>();
		for (String string : source) {
			temp.add(string.trim());
		}
		return ImmutableList.<String>builder().addAll(temp).build();
	}

	@Override
	public String toString() {
		return "Trimmed{" +
				"trimmedStrings=" + trimmedStrings +
				'}';
	}
}
