package colt.net.datacentreapi.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5256735231721012281L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
