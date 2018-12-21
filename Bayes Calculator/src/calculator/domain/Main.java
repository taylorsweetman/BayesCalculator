package calculator.domain;

import javax.swing.SwingUtilities;

import calculator.ui.*;

public class Main {
	
	public static void main(String[] args) {
		
		UserInterface calcInterface = new UserInterface();
		SwingUtilities.invokeLater(calcInterface);
	}

}
