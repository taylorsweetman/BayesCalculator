package calculator.domain;

public class EmptyCellException extends RuntimeException {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 9068267343548046846L;

	public EmptyCellException (String errorMes) {
		super(errorMes);
	}

}
