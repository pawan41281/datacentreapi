package colt.net.datacentreapi.exception;

public class ResourceAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 625052432950127962L;

	public ResourceAlreadyExistsException(String message) {
		super(message);
	}
}