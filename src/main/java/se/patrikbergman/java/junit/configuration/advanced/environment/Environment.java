package se.patrikbergman.java.junit.configuration.advanced.environment;

public enum Environment {
	DEV("development"),
	TEST("test"),
	QA("QA");

	private final String name;

	Environment(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Environment fromValue(String value) throws IllegalArgumentException{
		for(Environment env: Environment.values()) {
			if(env.getName().equals(value)) {
				return env;
			}
		}
		throw new IllegalArgumentException("Unknown value. Failed to create enum Env");
	}
}
