package calculator.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

	private void createComponents(Container container) {
		GridLayout layout = new GridLayout(5, 2);
		container.setLayout(layout);

		JLabel aGivenB = new JLabel("P(A|B)");
		JLabel a = new JLabel("P(A)");
		JLabel b = new JLabel("P(B)");
		JLabel bGivenA = new JLabel("P(B|A)");
		JTextField aGivenBInput = new JTextField();
		JTextField aInput = new JTextField();
		JTextField bInput = new JTextField();
		JTextField bGivenAInput = new JTextField();
		JButton calculateButton = new JButton("Calculate");
		JButton clearButton = new JButton("Clear Fields");

		container.add(aGivenB);
		container.add(aGivenBInput);
		container.add(a);
		container.add(aInput);
		container.add(b);
		container.add(bInput);
		container.add(bGivenA);
		container.add(bGivenAInput);
		container.add(calculateButton);
		container.add(clearButton);
		
		CalculateListener calcButtonListener = new CalculateListener(aGivenBInput, aInput, bInput, bGivenAInput);
		ClearListener clearButtonListener = new ClearListener(aGivenBInput, aInput, bInput, bGivenAInput);
		calculateButton.addActionListener(calcButtonListener);
		clearButton.addActionListener(clearButtonListener);
	}

	@Override
	public void run() {
		JFrame frame = new JFrame("Bayes Calculator");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createComponents(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

}
