package exceptions;

public class RepeatedUserException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "";

	public RepeatedUserException() {
		super(MESSAGE);
	}
}