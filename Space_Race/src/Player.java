import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Player extends Game_Object {
	int score = 0;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		if (needImage) {
			loadImage("rocketship.png");
		}
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

	public void down() {
		if (y <= 725) {
			y += speed;
		}
	}

	public void up() {
		if (y > 0) {
			y -= speed;
		}

	}
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
		
	}
}
