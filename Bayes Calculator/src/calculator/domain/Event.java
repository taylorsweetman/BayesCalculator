package calculator.domain;

import javax.swing.JTextField;

public class Event {

	private double probability;
	private boolean isInitialized;
	private JTextField textField;

	public Event(double prob, JTextField inputField) {
		probability = prob;
		isInitialized = true;
		this.textField = inputField;
	}

	public Event(JTextField inputField) {
		this.textField = inputField;
		isInitialized = false;
	}

	public boolean isInitialized() {
		return isInitialized;
	}

	public void setProb(double prob) {
		probability = prob;
		isInitialized = true;
	}

	public double getProb() {
		return probability;
	}
	
	public void setText(String outputText) {
		textField.setText(outputText);
	}
	
	public JTextField getTextField() {
		return textField;
	}

}
