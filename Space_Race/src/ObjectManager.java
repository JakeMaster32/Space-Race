import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Player one;
	Player two;
	Random random = new Random();
	ArrayList<Debris> debris = new ArrayList<Debris>();
	int number;

	public ObjectManager(Player one2, Player two2) {
		one = one2;
		two = two2;
	}

	void addDebris() {
		number = random.nextInt(2);
		if (number == 0) {
			debris.add(new Debris(0, random.nextInt(Space_Race.HEIGHT) + 200, 10, 10));
		} else {
			debris.add(new Debris(700, random.nextInt(Space_Race.HEIGHT) + 200, 10, 10));
		}

	}

	void checkCollision() {
		for (Debris debris : debris) {
			if (one.collisionBox.intersects(debris.collisionBox)) {
				one.isActive = false;
				debris.isActive = false;
			}
			if (two.collisionBox.intersects(debris.collisionBox)) {
				two.isActive = false;
				debris.isActive = false;
			}

		}
	}

	public void actionPerformed(ActionEvent e) {
		
addDebris();
	}

	void update() {
		System.out.println("Tracking down object");
		for (Debris debris : debris) {
			debris.update();

		}

		checkCollision();
		purgeObjects();
	}

	void purgeObjects() {
		for (int i = (debris.size() - 1); i >= 0; i--) {
			if (debris.get(i).isActive == false) {
				debris.remove(i);
			}
		}
	}

	void draw(Graphics g) {
		one.draw(g);
		two.draw(g);
		for (Debris alien : debris) {
			alien.draw(g);
		}

	}

}
