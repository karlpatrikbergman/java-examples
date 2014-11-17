package se.patrikbergman.java.junit.configuration.simple;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface ServerConfiguration {
	String host();
	String port();
	String user();
	String password();
}
