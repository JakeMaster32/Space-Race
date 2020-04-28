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
	final int INSTRUCTIONS = 1;
	final int GAME = 2;
	final int END = 3;
	int state = MENU;
	Player one = new Player(200, 600, 50, 70);
	Player two = new Player(450, 600, 50, 70);
	Timer timer = new Timer(1000 / 60, this);
	Timer gametimer = new Timer(1000, this);
	int countdown = 60;

	public Game_Panel() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if (state == MENU) {
			drawMenuState(g);
		}
		if (state == INSTRUCTIONS) {
			drawInstructionsState(g);
		}
		if (state == GAME) {
			drawGameState(g);
		}
		if (state == END) {
			drawEndState(g);
		}
	}

	void drawInstructionsState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 700, 700);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.setColor(Color.WHITE);
		g.drawString("The objective of the game is to reach the end of", 20, 60);
		g.drawString("the screen more times than your opponent in the ", 20, 110);
		g.drawString("given time. While doing so, you must avoid space ", 20, 160);
		g.drawString("debris. If you get hit, you will go back to start.", 20, 210);
		g.drawString("Player 1 Controls:", 20, 350);
		g.drawString("W = UP", 350, 350);
		g.drawString("S = DOWN", 353, 380);
		g.drawString("Player 2 Controls:", 20, 470);
		g.drawString("UP ARROW = UP", 350, 470);
		g.drawString("DOWN ARROW = DOWN", 353, 500);
		g.drawString("Press 'Space' to begin", 200, 650);

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
				state = INSTRUCTIONS;
				System.out.println("hi");
			}
		} else if (state == INSTRUCTIONS) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			}
			state = GAME;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("UP");
			two.up = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");

			two.down = true;
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
		g.drawString("Press 'Space' to continue", 200, 550);
		g.setColor(Color.BLUE);
		g.drawString("By Jake Morley", 250, 350);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 700, 700);
		one.draw(g);
		two.draw(g);
		g.setFont(new Font("Arial", Font.PLAIN, 70));
		g.setColor(Color.WHITE);
		g.drawString("" + one.score, 60, 650);
		g.drawString("" + two.score, 620, 650);
		g.fillRect(350, 435, 10, countdown * 4);
	}

	void drawEndState(Graphics g) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == timer) {
			repaint();
		} else {
			countdown = countdown - 1;
		}
	}
}
