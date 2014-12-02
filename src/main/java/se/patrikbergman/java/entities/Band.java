package se.patrikbergman.java.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Man skulle kunna låta ett band ha nån typ av state. State ändras när bandet
 * byter namn eller när bandets medlemmar förändras
 */
public final class Band {
	final String initialName;
	String currentName;
	final String description;
	final List<Member> founders;
	final List<Member> members = new ArrayList<>();

	public Band(String initialName, String description, List<Member> founders) {
		this.initialName = this.currentName = initialName;
		this.description = description;
		this.founders = founders;
		this.members.addAll(founders);
	}

	public void changeName(String newName) {
		this.currentName = newName;
	}

	public void addMember(Member member) {
		this.members.add(member);
	}

	public void removeMember(Member leavingMember) {
		for(Member member : members) {
			if(member.equals(leavingMember)) {
				members.remove(member);
				return;
			}
		}
	}

	public List<Member> currentMembers() {
		return members;
	}

}