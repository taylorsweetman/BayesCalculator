package calculator.domain;

import javax.swing.JTextField;

public class Event {

	private double prob;
	private boolean isInitialized;
	private JTextField textField;

	// TODO all these constructors are exposing a weak pattern. event is trying to be too many things
	public Event(double prob) {
		this.prob = prob;
		this.isInitialized = true;
		this.textField = null;
	}

	public Event(double prob, JTextField inputField) {
		this(prob);
		this.isInitialized = true;
		this.textField = inputField;
	}

	public Event(JTextField inputField) {
		this.textField = inputField;
		this.isInitialized = false;
	}

	public boolean isInitialized() {
		return isInitialized;
	}

	public void setProb(double prob) {
		this.prob = prob;
		isInitialized = true;
	}

	public double getProb() {
		return prob;
	}
	
	public void setText(String outputText) {
		textField.setText(outputText);
	}
	
	public JTextField getTextField() {
		return textField;
	}

}
