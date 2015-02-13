package se.patrikbergman.java.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.LocalDate;

import java.util.List;

/**
 * @JsonCreator and @JsonProperty is needed for deserialization (JSON --> Java)
 */

class User {

	private final LocalDate localDate;
	private final int age;
	private final String name;
	private final ImmutableList<String> messages;

	@JsonCreator
	public User(
			@JsonProperty("localDate") LocalDate localDate,
			@JsonProperty("age") int age,
			@JsonProperty("name") String name,
			@JsonProperty("messages") ImmutableList<String> messages) {
		this.localDate = localDate;
		this.age = age;
		this.name = name;
		this.messages = messages;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public List<String> getMessages() {
		return messages;
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
