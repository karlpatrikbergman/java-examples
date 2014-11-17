package se.patrikbergman.java.junit.configuration.statement;

import org.junit.Rule;
import org.junit.Test;

public class RulesTest {

	@Rule
	public MyRule myRule = new MyRule();

	@Test
	public void test1() {
		System.out.println("During test 1");
	}

	@Test
	public void test2() {
		System.out.println("During test 2");
	}
}
