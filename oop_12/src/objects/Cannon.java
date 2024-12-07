package objects;

import main.Game;

public class Cannon extends GameObject {

	private int tileY;

	public Cannon(int x, int y, int objType) {
		super(x, y, objType);
		tileY = y / Game.TILES_SIZE;
		initHitbox(62, 46);
		hitbox.x -= (int) (25 * Game.SCALE);
		hitbox.y -= (int) (10 * Game.SCALE);
	}

	public void update() {
		if (doAnimation)
			updateAnimationTick();
	}

	public int getTileY() {
		return tileY;
	}

}
