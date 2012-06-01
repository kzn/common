package ru.iitp.proling.common.io.unchecked;



/**
 * Unchecked version of IOException
 * @author ant
 *
 */
public class RuntimeIOException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RuntimeIOException() {
		super();
	}

	public RuntimeIOException(String message, Throwable cause) {
		super(message, cause);
	}

	public RuntimeIOException(String message) {
		super(message);
	}

	public RuntimeIOException(Throwable cause) {
		super(cause);
	}
}
