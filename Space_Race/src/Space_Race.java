import java.awt.Color;

import javax.swing.JFrame;

import javax.swing.JPanel;

public class Space_Race {
	static final int HEIGHT = 700;
	static final int WIDTH = 700;
	JFrame frame = new JFrame();
	Game_Panel panel = new Game_Panel();

	static Space_Race space = new Space_Race();

	public static void main(String[] args) {
		space.setup();

	}

	void setup() {
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.addKeyListener(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
