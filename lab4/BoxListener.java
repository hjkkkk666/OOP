package lab4;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class BoxListener implements ActionListener {
	
	private JComboBox<String> box;
	private JTextArea area;
	private JCheckBox check;

	
	public BoxListener(JComboBox<String> box, JTextArea area, JCheckBox check) {
		this.box = box;
		this.area = area;
		this.check = check;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int index = box.getSelectedIndex();
		area.setText(MovieInfo.INFO[index]);
		if (check.isSelected()) {
			area.setText(MovieInfo.INFO[index] + "\nГод: " + MovieInfo.YEAR[index]);
		}
		area.setText(MovieInfo.INFO[index]);
	}

}
