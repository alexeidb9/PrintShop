package main.java.service;

public class PrintServiceException extends RuntimeException {


	private static final long serialVersionUID = -45039187260255302L;

	public PrintServiceException() {
		super();
	}

	public PrintServiceException(String message, Throwable cause, boolean enableSuppression,
								 boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PrintServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PrintServiceException(String message) {
		super(message);
	}

	public PrintServiceException(Throwable cause) {
		super(cause);
	}
}
