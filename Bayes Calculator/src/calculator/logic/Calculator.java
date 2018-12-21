package calculator.logic;

import calculator.domain.*;
import java.util.List;
import java.util.ArrayList;

public class Calculator {

	private Event a;
	private Event b;
	private ConditionalEvent aGivenB;
	private ConditionalEvent bGivenA;
	private List<Event> initializedEvents;

	public Calculator() {
		initializedEvents = new ArrayList<Event>();
	}

	public double solveForA() {
		double returnValue;

		try {
			returnValue = b.getProb() * aGivenB.getProb() / bGivenA.getProb();
		} catch (Exception e) {
			System.out.println("Not all parameters initialized");
			return -1;
		}
		return returnValue;
	}

	public double solveForB() {
		double returnValue;

		try {
			returnValue = bGivenA.getProb() * a.getProb() / aGivenB.getProb();
		} catch (Exception e) {
			System.out.println("Not all parameters initialized");
			return -1;
		}
		return returnValue;
	}

	public double solveAGivenB() {

		double returnValue;

		try {
			returnValue = bGivenA.getProb() * a.getProb() / b.getProb();
		} catch (Exception e) {
			System.out.println("Not all parameters initialized");
			return -1;
		}
		return returnValue;

	}

	public double solveBGivenA() {

		double returnValue;

		try {
			returnValue = aGivenB.getProb() * b.getProb() / a.getProb();
		} catch (Exception e) {
			System.out.println("Not all parameters initialized");
			return -1;
		}
		return returnValue;

	}

	public void setA(Event event) {
		this.a = event;
		initializedEvents.add(event);
	}

	public void setB(Event event) {
		this.b = event;
		initializedEvents.add(event);
	}

	public void setAgivenB(ConditionalEvent ce) {
		this.aGivenB = ce;
		initializedEvents.add(ce);
	}

	public void setBgivenA(ConditionalEvent ce) {
		this.bGivenA = ce;
		initializedEvents.add(ce);
	}

	public void clearEvents() {
		initializedEvents.clear();
	}

	public boolean enoughInitializedEvents() {
		return initializedEvents.size() == 3;
	}

}
