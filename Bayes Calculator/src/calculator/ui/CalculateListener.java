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

	private JButton calcButton;
	private Calculator calcs;
	private ParseTextToDouble parser;
	private Event aGivenB;
	private Event a;
	private Event b;
	private Event bGivenA;
	private List<Event> allEventsList;

	public CalculateListener(JTextField aGivenB, JTextField a, JTextField b, JTextField bGivenA, JButton calcButton) {
		this.aGivenB = new Event(aGivenB);
		this.a = new Event(a);
		this.b = new Event(b);
		this.bGivenA = new Event(bGivenA);
		this.calcButton = calcButton;
		parser = new ParseTextToDouble();
		calcs = new Calculator();
		allEventsList = new ArrayList<Event>();
	}

	public void fieldAction(Event inputEvent) {
		double fieldsValue;

		try {
			fieldsValue = parser.parse(inputEvent.getTextField().getText());
			inputEvent.setProb(fieldsValue);
			allEventsList.add(inputEvent);
		} catch (NumberFormatException nfe) {
			inputEvent.setText("bad input bruh");
		} catch (EmptyCellException ece) {

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

		fieldAction(aGivenB);
		fieldAction(a);
		fieldAction(b);
		fieldAction(bGivenA);

		// refactor to tie the text fields to an event so that I can easily add an error
		// message to the uninitialized events
		if (getUninitalizedEvents().size() > 1) {
			for (Event event : getUninitalizedEvents()) {
				event.setText("only one event can not have prob set");
			}
		} else if (getUninitalizedEvents().size() == 0) {
			for (Event event : getUninitalizedEvents()) {
				event.setText("one field must remain blank");
			}
		}

		/*
		 * a.setText("Test"); b.setText("Test"); bGivenA.setText("Test");
		 */

	}

}
