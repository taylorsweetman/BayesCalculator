package calculator.logic;

import calculator.domain.EmptyCellException;

public class ParseTextToDouble {

	public double parse(String input) throws NumberFormatException, EmptyCellException {

		double returnParse;
		
		if (input.isEmpty()) {
			throw new EmptyCellException("Empty cell thrown");
		}
		

		returnParse = Double.parseDouble(input);
		return returnParse;
	}
}
