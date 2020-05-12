import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Debris extends Game_Object {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	boolean right = true;

	Debris(int x, int y, int width, int height, boolean right) {
		super(x, y, width, height);
		speed = 1;
this.right = right;
	}

	public void update() {
		super.update();
		if (right) {
			x += speed;
		}
		if (right == false) {
			x-=speed;
		}
		if (x > 700) {
			isActive = false;
		}
		if (x <0) {
			isActive = false;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(x, y, 10, 10);
	}

}
