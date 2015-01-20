package se.patrikbergman.java.annotations;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class LoginRequest {
	private String username;
	private String password;

	public LoginRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public LoginRequest() {

	}

	public LoginRequest newInstance() {
		return new LoginRequest("patrik.bergman", "some password");
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
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
