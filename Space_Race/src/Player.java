import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Player extends Game_Object {
	int score = 0;
	private boolean up = false;
	private boolean down = false;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	boolean keyPressed = false;
	boolean player1;

	Player(int x, int y, int width, int height, boolean player1) {
		super(x, y, width, height);
		speed = 2;
		if (needImage) {
			loadImage("rocketship.png");
		}
		this.player1 = player1;
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	public void goDown() {

		down = true;
		up = false;
		System.out.println(y);
		keyPressed = true;
	}

	public void goUp() {

		down = false;
		up = true;
		System.out.println("" + y);

		keyPressed = true;
	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
		update();
	}

	public void update() {
		super.update();
		if (up && keyPressed) {
			if (y > 0) {
				y -= speed;

			}

		}
		if (down && keyPressed) {
			if (y <= 616) {
				y += speed;
			}
		}
	
	}
}
