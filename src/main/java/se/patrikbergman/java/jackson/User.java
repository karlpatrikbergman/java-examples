package se.patrikbergman.java.jackson;

import com.google.common.base.Objects;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {

	private LocalDateTime timestamp;
	private int age = 29;
	private String name = "mkyong";
	private List<String> messages = new ArrayList<String>() {
		{
			add("msg 1");
			add("msg 2");
			add("msg 3");
		}
	};

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}


	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("timestamp", timestamp)
				.add("age", age)
				.add("name", name)
				.add("messages", messages)
				.toString();
	}
}
