import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Game_Panel extends JPanel implements KeyListener, ActionListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int state = MENU;
	Timer timer = new Timer(1000/60, this);
	public Game_Panel() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if (state == MENU) {drawMenuState(g);}
		if (state == GAME) {drawGameState(g);}
		if (state == END) {drawEndState(g);}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
if (state == MENU) {
	if (e.getKeyCode() == KeyEvent.VK_SPACE) {
		state = GAME;
		System.out.println("hi");
	}
}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 700, 700);
		g.setFont(new Font("Arial", Font.PLAIN, 48));
		g.setColor(Color.WHITE);
		g.drawString("Space Race", 200, 100);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.drawString("Press 'Space' to begin", 200, 550);
		g.setColor(Color.BLUE);
		g.drawString("By Jake Morley", 250, 350);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 700, 700);
	}

	void drawEndState(Graphics g) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
}
