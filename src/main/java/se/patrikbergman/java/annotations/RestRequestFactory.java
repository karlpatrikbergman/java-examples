package se.patrikbergman.java.annotations;

public final class RestRequestFactory {

	private static class LazyHolder {
		private static final RestRequestFactory INSTANCE = new RestRequestFactory();
	}

	public static RestRequestFactory getInstance() {
		return LazyHolder.INSTANCE;
	}

	public LoginRequest getLoginRequest() {
		return new LoginRequest("patrik.bergman", "some-random-password");
	}

	public ControlQuestionRequest getControlQuestionRequest() {
		return new ControlQuestionRequest("0737-855123", "700303-8911", "patrik.bergman");
	}

}
