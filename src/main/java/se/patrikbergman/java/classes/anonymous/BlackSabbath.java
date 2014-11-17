package se.patrikbergman.java.classes.anonymous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackSabbath {

	interface BandMember {
		String getName();
		int getAge();
	}

	private List<BandMember> members = new ArrayList<>();

	public BlackSabbath() {

		BandMember singer = new BandMember() { //Anonymous class
			@Override
			public String getName() {
				return "Ozzy Osbourne";
			}

			@Override
			public int getAge() {
				return 65;
			}
		};
		BandMember guitarist = new BandMember() { //Anonymous class
			@Override
			public String getName() {
				return "Toni Iommi";
			}

			@Override
			public int getAge() {
				return 66;
			}
		};
		BandMember basePlayer = new BandMember() { //Anonymous class
			@Override
			public String getName() {
				return "Geezer Butler";
			}

			@Override
			public int getAge() {
				return 65;
			}
		};
		this.members.addAll(Arrays.asList(new BandMember[] {singer, guitarist, basePlayer}));
	}

	public List<BandMember> getMembers() {
		return members;
	}
}
