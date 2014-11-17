package se.patrikbergman.java.junit.configuration.advanced.statement;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MyRule implements TestRule {

	@Override
	public Statement apply(Statement statement, Description description) {
		return new MyStatement(statement);
	}
}
