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
	private List<Event> uninitializedEvents;

	public CalculateListener(JTextField aGivenB, JTextField a, JTextField b, JTextField bGivenA, JButton calcButton) {
		this.aGivenB = new Event(aGivenB);
		this.a = new Event(a);
		this.b = new Event(b);
		this.bGivenA = new Event(bGivenA);
		this.calcButton = calcButton;
		parser = new ParseTextToDouble();
		calcs = new Calculator();
		allEventsList = new ArrayList<Event>();
		uninitializedEvents = new ArrayList<Event>();
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
			allEventsList.add(inputEvent);
			uninitializedEvents.add(inputEvent);
		}
	}

	@Override
	public void actionPerformed(ActionEvent calcButtonHit) {

		double answerNumber;
		String answerString;

		allEventsList.clear();
		uninitializedEvents.clear();

		fieldAction(aGivenB);
		fieldAction(a);
		fieldAction(b);
		fieldAction(bGivenA);

		// refactor to tie the text fields to an event so that I can easily add an error
		// message to the uninitialized events
		if (uninitializedEvents.size() > 1) {
			for (Event event : uninitializedEvents) {
				event.setText("only one event can not have prob set");
			}
		} else if (uninitializedEvents.size() == 0) {
			for (Event event : allEventsList) {
				event.setText("one field must remain blank");
			}
		} else {
			calcs.setA(a);
			calcs.setAgivenB(aGivenB);
			calcs.setB(b);
			calcs.setBgivenA(bGivenA);

			if (!a.isInitialized()) {
				answerNumber = calcs.solveForA();
				answerString = Double.toString(answerNumber);

				a.setText(answerString);
			} else if (!b.isInitialized()) {
				answerNumber = calcs.solveForB();
				answerString = Double.toString(answerNumber);

				b.setText(answerString);
			} else if (!aGivenB.isInitialized()) {
				answerNumber = calcs.solveAGivenB();
				answerString = Double.toString(answerNumber);

				aGivenB.setText(answerString);
			} else {
				answerNumber = calcs.solveBGivenA();
				answerString = Double.toString(answerNumber);

				bGivenA.setText(answerString);
			}
		}

		System.out.println(uninitializedEvents.size());

		/*
		 * a.setText("Test"); b.setText("Test"); bGivenA.setText("Test");
		 */

	}

}
