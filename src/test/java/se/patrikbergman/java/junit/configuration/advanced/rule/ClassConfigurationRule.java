package se.patrikbergman.java.junit.configuration.advanced.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import se.patrikbergman.java.junit.configuration.advanced.dependencies.DataSourceFactory;
import se.patrikbergman.java.junit.configuration.advanced.dependencies.TestDataSource;
import se.patrikbergman.java.junit.configuration.advanced.rule.annotations.ClassEnvironment;

public class ClassConfigurationRule implements TestRule {

	private TestDataSource dataSource;

	public TestDataSource getDataSource() {
		return dataSource;
	}

	@Override
	public Statement apply(final Statement base, final Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				final ClassEnvironment methodLevelEnvironment = description.getAnnotation(ClassEnvironment.class);
				dataSource = DataSourceFactory.createDataSource(methodLevelEnvironment.env());
				base.evaluate();
			}
		};
	}
}
