package lab4;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Window");
		frame.setLocation(400,400);
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		final JTextField rate = new JTextField();
		final JTextField greeting = new JTextField();
		
		JComboBox<String> box = new JComboBox<String>(MovieInfo.MOVIES);
		JCheckBox check = new JCheckBox("Вывести год выпуска");
		
		JTextArea area = new JTextArea();
		area.setText("Выберите фильм");
		area.setEditable(false);
		
		BoxListener myListener = new BoxListener(box, area, check);
		box.addActionListener(myListener);
		
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = box.getSelectedIndex();
				if (check.isSelected()) {
					String temp = area.getText();
					area.setText(temp +  "\nГод: " + MovieInfo.YEAR[index]);
				}
				else {
					String temp = area.getText();
					temp = temp.replace(temp, "");
					area.setText(temp);
					}
			}
		});
		
		rate.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				greeting.setText("Ваша оценка: " + rate.getText());
			}
		});
		
		frame.add(box, BorderLayout.SOUTH);
		frame.add(check, BorderLayout.WEST);
		frame.add(rate, BorderLayout.CENTER);
		frame.add(greeting, BorderLayout.EAST);
		frame.add(area, BorderLayout.NORTH);
		frame.setVisible(true);
		
	}

}
