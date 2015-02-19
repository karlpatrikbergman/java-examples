package se.patrikbergman.java.evilextendsis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class FestivalSummer {

	public static void main(String args[]) {
		MusicFestival hultsfred = arrangeHultsfred();
		hultsfred.run();
		MusicFestival roskilde = arrangeRoskilde();
		roskilde.run();
	}

	//Roskilde festival line-up stored in Map
	private static MusicFestival arrangeRoskilde() {
		final Band accept = new HeavyMetalBand("Accept", 50);
		final Band theCarterFamily = new CountryBand("The Carter Family", 90);
		final Map<Integer,Band> bandMap = new HashMap<>();
		bandMap.put(accept.hashCode(), accept);
		bandMap.put(theCarterFamily.hashCode(), theCarterFamily);
		return new MusicFestival("Roskilde", bandMap.values().iterator());
	}

	//Hultsfred festival line-up stored in Collection
	private static MusicFestival arrangeHultsfred() {
		final Band accept = new HeavyMetalBand("Judas Pries", 80);
		final Band theCarterFamily = new CountryBand("The Flying Burrito Brothers", 20);
		final Collection<Band> bandCollection = new ArrayList<>();
		bandCollection.add(accept);
		bandCollection.add(theCarterFamily);
		return new MusicFestival("Hultsfred", bandCollection.iterator());
	}



}
