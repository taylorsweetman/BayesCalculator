package calculator.logic;

import calculator.domain.EmptyCellException;

public class ParseTextToDouble {

	public double parse(String input) {

		double returnParse;

		//TODO-Taylor handle exceptions
		
		if (input.isEmpty()) {
			throw new EmptyCellException("Empty cell thrown");
		}
		

		returnParse = Double.parseDouble(input);
		return returnParse;
	}
}
