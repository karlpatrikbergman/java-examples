package se.patrikbergman.java.annotations;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ControlQuestionRequest {
	private String username;
	private String personnummer;
	private String phoneNumber;

	public ControlQuestionRequest(String phoneNumber, String personnummer, String username) {
		this.phoneNumber = phoneNumber;
		this.personnummer = personnummer;
		this.username = username;
	}

	public ControlQuestionRequest() {}

	public String getUsername() {
		return username;
	}

	public String getPersonnummer() {
		return personnummer;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
