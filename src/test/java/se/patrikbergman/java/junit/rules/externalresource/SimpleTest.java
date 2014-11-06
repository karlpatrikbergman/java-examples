package se.patrikbergman.java.junit.rules.externalresource;

import org.junit.ClassRule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SimpleTest {

	private final SimpleBean simpleBean;

	@ClassRule
	public static final DatabaseResource resource = new DatabaseResource();

	public SimpleTest() {
		simpleBean = new SimpleBean(resource.getDataSource());
		System.out.println(SimpleTest.class.getSimpleName() + " constructor");
	}

	@Test
	public void test1() {
		assertNotNull("test 1: simpleBean.getDataSource() returned null" , simpleBean.getDataSource());
	}

	@Test
	public void test2() {
		assertNotNull("test2: simpleBean.getDataSource() returned null", simpleBean.getDataSource());
	}


}
