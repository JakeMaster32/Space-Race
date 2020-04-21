import java.awt.Color;

import javax.swing.JFrame;

import javax.swing.JPanel;

public class Space_Race {
	JFrame frame = new JFrame();
	Game_Panel panel = new Game_Panel();

	static Space_Race space = new Space_Race();

	public static void main(String[] args) {
		space.setup();

	}

	void setup() {
		frame.add(panel);
		frame.setSize(700, 700);
		frame.setVisible(true);
		frame.addKeyListener(panel);
	}

}
