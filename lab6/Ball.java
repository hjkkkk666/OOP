package lab6;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JTextArea;


public class Ball extends Thread {
	
	private JTextArea panel; private Color color;
	private int step; private int size;
	private int x0; private int y0;
	
	public Ball(JTextArea panel, int step, int size, int x0, int y0) {
		super();
		this.panel = panel;
		this.step = step;
		this.size = size;
		this.x0 = x0;
		this.y0 = y0;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public void run() {
		int x = x0;
		int y = y0;
		int xdir = +1;
		int ydir = +1;
		
		panel.setBackground(Color.BLACK);
		Graphics gr = panel.getGraphics();
		
		while (true) {
			gr.setColor(this.color);
			gr.fillOval(x, y, size, size);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			gr.setColor(Color.BLACK);
			gr.fillOval(x, y, size, size);
			
			if (x > panel.getWidth() - size) {xdir = -1;}
			if (x < size) {xdir = +1;}
			if (y > panel.getHeight() - size) {ydir = -1;}
			if (y < size) {ydir = +1;}
			
			x += xdir * step; y += ydir * step;
		}
		
	}

}
