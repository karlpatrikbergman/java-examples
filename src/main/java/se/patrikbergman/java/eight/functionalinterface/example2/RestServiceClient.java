package se.patrikbergman.java.eight.functionalinterface.example2;

public class RestServiceClient {
	private final String host;
	private final String port;
	private boolean connected = false;

	public RestServiceClient(String host, String port) {
		this.host = host;
		this.port = port;
	}

	public void connect() {
		this.connected = true;
	}

	public boolean isConnected() {
		return connected;
	}
}
