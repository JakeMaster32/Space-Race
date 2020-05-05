import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Debris extends Game_Object{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	Debris(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 1;
		
	}

	public void update() {
		super.update();
		y += speed;
		if (y > 700) {
			isActive = false;
		}
	}

	
	void draw(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillOval(350, 350, 10, 10);
		}
	

	
}

