package se.patrikbergman.java.junit.configuration.rulestest.rule.annotations;

import se.patrikbergman.java.junit.configuration.rulestest.Environment;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodEnvironment {
	Environment env();
}

