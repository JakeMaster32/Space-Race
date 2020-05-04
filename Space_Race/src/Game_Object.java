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
	Player one;
	Player two;
	Random random = new Random();
	
	public Game_Object(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		ArrayList<Debris> debris = new ArrayList<Debris>();
		collisionBox = new Rectangle(x, y, width, height);
		
	}
	Game_Object(Player one, Player two) {
		this.one = one;
		this.two = two;
		
	}

	public void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	//void checkCollision() {
		//for (Debris debris : debris) {
		//	if (one.collisionBox.intersects(debris.collisionBox)) {
				//one.isActive = false;
				//debris.isActive = false;
			//}

		//}
	}

