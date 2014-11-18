package se.patrikbergman.java.utility;

import org.junit.Test;

public class JsonStringTest {

	class Book {
		private final String title;
		private final String author;

		public Book(String title, String author) {
			this.title = title;
			this.author = author;
		}

		public String getTitle() {
			return title;
		}

		public String getAuthor() {
			return author;
		}
	}

	@Test
	public void bandToJsonString() {
		final Book book = new Book("Effective Java", "Joshua Bloch");
		System.out.println(new JsonString(book));
	}
}
