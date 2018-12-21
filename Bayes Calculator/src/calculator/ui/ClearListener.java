package calculator.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ClearListener implements ActionListener {

	private JTextField aGivenB;
	private JTextField a;
	private JTextField b;
	private JTextField bGivenA;

	public ClearListener(JTextField aGivenB, JTextField a, JTextField b, JTextField bGivenA) {
		this.aGivenB = aGivenB;
		this.a = a;
		this.b = b;
		this.bGivenA = bGivenA;
	}

	@Override
	public void actionPerformed(ActionEvent calcButtonHit) {
		// TODO Auto-generated method stub
		aGivenB.setText("");
		a.setText("");
		b.setText("");
		bGivenA.setText("");
	}

}
