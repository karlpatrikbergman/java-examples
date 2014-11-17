package se.patrikbergman.java.junit.configuration.advanced.rule.annotations;

import se.patrikbergman.java.junit.configuration.advanced.environment.Environment;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassEnvironment {
	Environment env();
}
