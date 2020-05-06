import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class Game_Object {
	int x;
	int y;
	int width;
	int height;
	int speed = 0;
	Rectangle collisionBox;
	boolean isActive = true;

	public Game_Object(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		collisionBox = new Rectangle(x, y, width, height);

	}

	

	public void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	}
