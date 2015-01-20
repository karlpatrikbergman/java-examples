package se.patrikbergman.java.annotations;

import org.junit.ClassRule;
import org.junit.Test;

public class RestServiceIT {

	@InjectTestResource(getFactory = RestRequestFactory.class, getMethod = "getControlQuestionRequest")
	public static ControlQuestionRequest controlQuestionRequest;

	@InjectTestResource(getFactory = RestRequestFactory.class, getMethod = "getLoginRequest")
	public static LoginRequest loginRequest;

	@ClassRule
	public static final TestResourcesRule TEST_RESOURCES_RULE =
			new TestResourcesRule(RestServiceIT.class);

	@Test
	public void getLoginRequest() {
		System.out.println(loginRequest);
	}

	@Test
	public void getControlQuestionRequest() {
		System.out.println(controlQuestionRequest);
	}

}
