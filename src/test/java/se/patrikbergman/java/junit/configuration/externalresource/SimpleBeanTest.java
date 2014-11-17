package se.patrikbergman.java.junit.configuration.externalresource;

import org.junit.ClassRule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SimpleBeanTest {

	private static final SimpleBean simpleBean;
	private static final String className = SimpleBeanTest.class.getSimpleName();

	@ClassRule
	public static final DatabaseResource resource = new DatabaseResource();

	static {
		System.out.println(String.format("%s: Initializing SimpleBean and DataSource", className));
		simpleBean = new SimpleBean(resource.getDataSource());
	}

	@Test
	public void test1() {
		assertNotNull("test 1: simpleBean.getDataSource() returned null" , simpleBean.getDataSource());
		simpleBean.executeDataSourceDependentCommand();
	}

	@Test
	public void test2() {
		assertNotNull("test2: simpleBean.getDataSource() returned null", simpleBean.getDataSource());
		simpleBean.executeDataSourceDependentCommand();
	}


}
