package se.patrikbergman.java.junit.rules.configuration2;

public enum Env {
	DEV("development"),
	TEST("test"),
	QA("QA");

	private final String name;

	Env(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Env fromValue(String value) throws IllegalArgumentException{
		for(Env env: Env.values()) {
			if(env.getName().equals(value)) {
				return env;
			}
		}
		throw new IllegalArgumentException("Unknown value. Failed to create enum Env");
	}
}
