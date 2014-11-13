package se.patrikbergman.java.classes.nested;

public class Rockband {

	private final OuterClassForBandMembers.StaticBandMember staticBandMember;
	private final OuterClassForBandMembers.NestedBandMember nestedBandMember;

	public Rockband(OuterClassForBandMembers.StaticBandMember staticBandMember, OuterClassForBandMembers.NestedBandMember nestedBandMember) {
		this.staticBandMember = staticBandMember;
		this.nestedBandMember = nestedBandMember;
	}

}
