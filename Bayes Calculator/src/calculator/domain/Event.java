package calculator.domain;

public class Event {

	private double probability;
	private boolean isInitialized;

	public Event(double prob) {
		probability = prob;
		isInitialized = true;
	}

	public Event() {
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

}
