package calculator.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import calculator.logic.Calculator;
import calculator.logic.ParseTextToDouble;
import calculator.domain.*;

public class CalculateListener implements ActionListener {

	private JTextField aGivenBText;
	private JTextField aText;
	private JTextField bText;
	private JTextField bGivenAText;
	private JButton calcButton;
	private Calculator calcs;
	private ParseTextToDouble parser;
	private Event aGivenB;
	private Event a;
	private Event b;
	private Event bGivenA;

	public CalculateListener(JTextField aGivenB, JTextField a, JTextField b, JTextField bGivenA, JButton calcButton) {
		this.aGivenBText = aGivenB;
		this.aText = a;
		this.bText = b;
		this.bGivenAText = bGivenA;
		this.calcButton = calcButton;
		parser = new ParseTextToDouble();
		calcs = new Calculator();
	}
	
	public void fieldAction(JTextField inputField, Event inputEvent) {
		double fieldsValue;
		
		try {
			fieldsValue = parser.parse(inputField.getText());
			inputEvent = new Event(fieldsValue);
		} catch (NumberFormatException nfe) {
			inputField.setText("bad input bruh");
		} catch (EmptyCellException ece) {
			inputEvent = new Event();
		}
	}

	public List<Event> getUninitalizedEvents() {
		ArrayList<Event> listToReturn = new ArrayList<Event>();
		
		if (!aGivenB.isInitialized()) {
			listToReturn.add(aGivenB);
		}
		
		if (!a.isInitialized()) {
			listToReturn.add(a);
		}
		
		if (!b.isInitialized()) {
			listToReturn.add(b);
		}
		
		if (!bGivenA.isInitialized()) {
			listToReturn.add(bGivenA);
		}
		
		return listToReturn;
	}
	
	@Override
	public void actionPerformed(ActionEvent calcButtonHit) {
		
		fieldAction(aGivenBText, aGivenB);
		fieldAction(aText, a);
		fieldAction(bText, b);
		fieldAction(bGivenAText, bGivenA);
		
		//refactor to tie the text fields to an event so that I can easily add an error message to the uninitialized events
		if (getUninitalizedEvents().size() > 1) {
			for (Event event:getUninitalizedEvents()) {
				
			}
		}

		/*
		 * a.setText("Test"); b.setText("Test"); bGivenA.setText("Test");
		 */

	}

}
