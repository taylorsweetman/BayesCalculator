package calculator.domain;

import java.util.List;
import java.util.ArrayList;

public class ConditionalEvent extends Event {

	private List<Event> precedants;

	public ConditionalEvent(double probability, Event precendantEvent) {
		super(probability);
		precedants = new ArrayList<>();
		precedants.add(precendantEvent);
	}
	
	public ConditionalEvent (double probability) {
		super(probability);
	}

	public List<Event> getPrecedants() {
		return precedants;
	}

}
