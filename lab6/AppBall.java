package lab6;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.GridLayout;

public class AppBall {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(new GridLayout());
		JTextArea panel = new JTextArea();
		frame.add(panel);
		frame.setVisible(true);
		
		Ball ball1 = new Ball(panel, 2, 50, 200, 40);
		ball1.setColor(Color.WHITE);
		Ball ball2 = new Ball(panel, 10, 10, 100, 50);
		ball2.setColor(Color.BLUE);
		Ball ball3 = new Ball(panel, 5, 20, 30, 30);
		ball3.setColor(Color.GREEN);
		Ball ball4 = new Ball(panel, 5, 40, 130, 30);
		ball4.setColor(Color.PINK);

		ball1.start();
		ball2.start();
		ball3.start();
		ball4.start();
	}

}
