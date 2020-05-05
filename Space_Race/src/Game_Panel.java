import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
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
	final int SUDDENDEATH = 3;
	final int END = 4;
	boolean timerOver = false;
	int state = MENU;
	boolean SuddenDeathInstructions = false;
	Player one = new Player(200, 620, 30, 50, true);
	Player two = new Player(450, 620, 30, 50, false);
	Timer timer = new Timer(1000 / 60, this);
	Timer gametimer = new Timer(1000, this);
	int SuddenDeath = 0;
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
		if (state == SUDDENDEATH) {
			drawSuddenDeathState(g);
		}
		if (state == END) {
			drawEndState(g);
		}
	}

	void drawSuddenDeathState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 700, 700);
		one.draw(g);
		two.draw(g);
		g.setFont(new Font("Arial", Font.PLAIN, 70));
		g.setColor(Color.WHITE);
		g.drawString("" + one.score, 60, 650);
		g.drawString("" + two.score, 620, 650);
		g.setFont(new Font("Arial", Font.PLAIN, 48));
		if (SuddenDeathInstructions) {
			one.y = 620;
			two.y = 620;
			if (SuddenDeath > 480) {
				g.drawString("SUDDEN DEATH", 180, 100);
				SuddenDeath--;
			} else if (SuddenDeath > 380) {
				g.drawString("FIRST TO SCORE WINS", 100, 100);
				SuddenDeath--;
			} else if (SuddenDeath > 280) {
				g.drawString("3", 300, 100);
				SuddenDeath--;
			} else if (SuddenDeath > 180) {
				g.drawString("2", 300, 100);
				SuddenDeath--;
			} else if (SuddenDeath > 120) {
				g.drawString("1", 300, 100);
				SuddenDeath--;
			} else if (SuddenDeath > 60) {
				g.drawString("GO!", 300, 100);
				SuddenDeath--;
				
			}
			else if (SuddenDeath >0) {
				SuddenDeathInstructions = false;
			}
			
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
		g.drawString("debris. If you get hit, you will go back to start. If the", 20, 210);
		g.drawString("game is over and the scores are even, there will", 20, 260);
		g.drawString("be a sudden death.", 20, 310);
		g.drawString("Player 1 Controls:", 20, 400);
		g.drawString("W = UP", 350, 400);
		g.drawString("S = DOWN", 353, 430);
		g.drawString("Player 2 Controls:", 20, 510);
		g.drawString("UP ARROW = UP", 350, 510);
		g.drawString("DOWN ARROW = DOWN", 353, 540);
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

			}
		} else if (state == INSTRUCTIONS) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				state = GAME;
				countdown = 60;
				gametimer.start();
			}

		} else if (state == END) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				state = MENU;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("UP");
			if (SuddenDeathInstructions == false) {
				two.goUp();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
			if (SuddenDeathInstructions == false) {
				two.goDown();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			if (SuddenDeathInstructions == false) {
				one.goUp();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			if (SuddenDeathInstructions == false) {
				one.goDown();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
			one.keyPressed = false;
		} else {
			two.keyPressed = false;
		}
	}

	void drawMenuState(Graphics g) {
		one.score = 0;
		two.score = 0;
		one.y = 620;
		two.y = 620;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 700, 700);
		g.setFont(new Font("Arial", Font.PLAIN, 48));
		g.setColor(Color.WHITE);
		g.drawString("Space Race", 220, 100);
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
		g.fillRect(350, Space_Race.HEIGHT - (countdown * 4), 10, countdown * 4);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 700, 700);
		g.setFont(new Font("Arial", Font.PLAIN, 70));
		g.setColor(Color.WHITE);
		g.drawString("GAME OVER", 150, 100);
		if (one.score > two.score) {
			g.drawString("Player One Wins!", 100, 350);
		} else if (two.score > one.score) {
			g.drawString("Player Two Wins!", 100, 350);
		} else {
			g.drawString("DRAW", 250, 350);
		}
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.setColor(Color.WHITE);
		g.drawString("Press 'Space' if you want to play again", 100, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {

			repaint();
		} else {
			if (countdown > 0) {
				countdown = countdown - 10;
				System.out.println("timer");
			} else {
				gametimer.stop();
				countdown = 1;
				if (one.score == two.score) {
					state = SUDDENDEATH;
					if (SuddenDeath == 0) {
						SuddenDeath = 580;
						SuddenDeathInstructions = true;
					}
				} else {
					state = END;
				}
			}

		}

		if (one.y == 0) {
			one.score = one.score + 1;
			one.y = 620;
			if (state == SUDDENDEATH) {
				state = END;
			}
		} else if (two.y == 0) {
			two.score = two.score + 1;
			two.y = 620;
			if (state == SUDDENDEATH) {
				state = END;
			}
		}
	}
}
