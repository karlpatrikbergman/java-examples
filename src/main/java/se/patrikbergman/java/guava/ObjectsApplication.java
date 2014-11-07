package se.patrikbergman.java.guava;

import com.google.common.base.Objects;

public class ObjectsApplication {

	public static void main(String args[]) {
		Band band = new Band("Iron Maiden", "British New Wave of Heavy Metal", 10);
		System.out.println(band);
		System.out.println(band.hashCode());
	}
}
