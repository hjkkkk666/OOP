package lab2;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Bank {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(0,2));
		
		final JLabel firstLabel = new JLabel("Вклад:");
		final JTextField firstField = new JTextField("   ");
		final JLabel sLabel = new JLabel("Процент:");
		final JComboBox<String> fCombo = new JComboBox<String>(new String[] {"5%", "10%", "20%"});
		final JLabel tLabel = new JLabel("Срок:");
		final JComboBox<String> sCombo = new JComboBox<String>(new String[] {"1 год", "3 года", "5 лет"});
		final JButton calculateButton = new JButton("Расчёт");
		final JTextField resultField = new JTextField("   ");
		
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float sum = Float.parseFloat(firstField.getText());
				float result = sum;
				if (fCombo.getSelectedItem().equals("5%")) {
					result *= 1.05;
				} else if (fCombo.getSelectedItem().equals("10%")) {
					result *= 1.1;
				} else if (fCombo.getSelectedItem().equals("20%")) {
					result *= 1.2;
				}
				
				if (sCombo.getSelectedItem().equals("1 год")) {
					result *= 1;
				} else if (sCombo.getSelectedItem().equals("3 года")) {
					result *= 3;
				} else if (sCombo.getSelectedItem().equals("5 лет")) {
					result *= 5;
				}
				
				resultField.setText(String.valueOf(result));
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100,300);
		frame.setLocation(300,300);
		frame.setTitle("Bank");
		frame.setVisible(true);
		
		frame.add(firstLabel);
		frame.add(firstField);
		frame.add(sLabel);
		frame.add(fCombo);
		frame.add(tLabel);
		frame.add(sCombo);
		frame.add(calculateButton);
		frame.add(resultField);	

	}

}
