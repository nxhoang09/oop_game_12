package entities;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import gamestates.Playing;
import levels.Level;
import utilz.LoadSave;
import static utilz.Constants.EnemyConstants.*;

public class EnemyManager {

	private Playing playing;
	private BufferedImage[][] snakeArr, gordonArr, wolfArr;
	private Level currentLevel;

	public EnemyManager(Playing playing) {
		this.playing = playing;
		loadEnemyImgs();
	}

	public void loadEnemies(Level level) {
		this.currentLevel = level;
	}
	public void update(int[][] lvlData) {
		boolean isAnyActive = false;
		for (Snake c : currentLevel.getSnakes())
			if (c.isActive()) {
				c.update(lvlData, playing);
				isAnyActive = true;
			}

		for (Gordon p : currentLevel.getGordons())
			if (p.isActive()) {
				p.update(lvlData, playing);
				isAnyActive = true;
			}

		for (Wolf s : currentLevel.getWolfs())
			if (s.isActive()) {
				s.update(lvlData, playing);
				isAnyActive = true;
			}

		if (!isAnyActive)
			playing.setLevelCompleted(true);
	}

	public void draw(Graphics g, int xLvlOffset) {
		drawSnakes(g, xLvlOffset);
		drawGordons(g, xLvlOffset);
		drawWolfs(g, xLvlOffset);
	}

	private void drawWolfs(Graphics g, int xLvlOffset) {
		for (Wolf s : currentLevel.getWolfs())
			if (s.isActive()) {
				g.drawImage(wolfArr[s.getState()][s.getAniIndex()], (int) s.getHitbox().x - xLvlOffset - WOLF_DRAWOFFSET_X + s.flipX(),
						(int) s.getHitbox().y - WOLF_DRAWOFFSET_Y + (int) s.getPushDrawOffset(), WOLF_WIDTH * s.flipW(), WOLF_HEIGHT, null);
//				s.drawHitbox(g, xLvlOffset);
//				s.drawAttackBox(g, xLvlOffset);
			}
	}

	private void drawGordons(Graphics g, int xLvlOffset) {
		for (Gordon p : currentLevel.getGordons())
			if (p.isActive()) {
				g.drawImage(gordonArr[p.getState()][p.getAniIndex()], (int) p.getHitbox().x - xLvlOffset - GORDON_DRAWOFFSET_X + p.flipX(),
						(int) p.getHitbox().y - GORDON_DRAWOFFSET_Y + (int) p.getPushDrawOffset(), GORDON_WIDTH * p.flipW(), GORDON_HEIGHT, null);
//				p.drawHitbox(g, xLvlOffset);
			}
	}

	private void drawSnakes(Graphics g, int xLvlOffset) {
		for (Snake c : currentLevel.getSnakes())
			if (c.isActive()) {

				g.drawImage(snakeArr[c.getState()][c.getAniIndex()], (int) c.getHitbox().x - xLvlOffset - SNAKE_DRAWOFFSET_X + c.flipX(),
						(int) c.getHitbox().y - SNAKE_DRAWOFFSET_Y + (int) c.getPushDrawOffset(), SNAKE_WIDTH * c.flipW(), SNAKE_HEIGHT, null);

//				c.drawHitbox(g, xLvlOffset);
//				c.drawAttackBox(g, xLvlOffset);
			}

	}

	public void checkEnemyHit(Rectangle2D.Float attackBox) {
		for (Snake c : currentLevel.getSnakes())
			if (c.isActive())
				if (c.getState() != DEAD && c.getState() != HIT)
					if (attackBox.intersects(c.getHitbox())) {
						c.hurt(20);
						return;
					}

		for (Gordon p : currentLevel.getGordons())
			if (p.isActive()) {
				if (p.getState() == ATTACK && p.getAniIndex() >= 3)
					return;
				else {
					if (p.getState() != DEAD && p.getState() != HIT)
						if (attackBox.intersects(p.getHitbox())) {
							p.hurt(20);
							return;
						}
				}
			}

		for (Wolf s : currentLevel.getWolfs())
			if (s.isActive()) {
				if (s.getState() != DEAD && s.getState() != HIT)
					if (attackBox.intersects(s.getHitbox())) {
						s.hurt(20);
						return;
					}
			}
	}

	private void loadEnemyImgs() {
		snakeArr = getImgArr(LoadSave.GetSpriteAtlas(LoadSave.SNAKE), 6, 5, SNAKE_WIDTH_DEFAULT, SNAKE_HEIGHT_DEFAULT);
		gordonArr = getImgArr(LoadSave.GetSpriteAtlas(LoadSave.GORDON), 8, 5, GORDON_WIDTH_DEFAULT, GORDON_HEIGHT_DEFAULT);
		wolfArr = getImgArr(LoadSave.GetSpriteAtlas(LoadSave.WOLF), 7, 5, WOLF_WIDTH_DEFAULT, WOLF_HEIGHT_DEFAULT);
	}

	private BufferedImage[][] getImgArr(BufferedImage atlas, int xSize, int ySize, int spriteW, int spriteH) {
		BufferedImage[][] tempArr = new BufferedImage[ySize][xSize];
		for (int j = 0; j < tempArr.length; j++)
			for (int i = 0; i < tempArr[j].length; i++)
				tempArr[j][i] = atlas.getSubimage(i * spriteW, j * spriteH, spriteW, spriteH);
		return tempArr;
	}

	public void resetAllEnemies() {
		for (Snake c : currentLevel.getSnakes())
			c.resetEnemy();
		for (Gordon p : currentLevel.getGordons())
			p.resetEnemy();
		for (Wolf s : currentLevel.getWolfs())
			s.resetEnemy();
	}

}
