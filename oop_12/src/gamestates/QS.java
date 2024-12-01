package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.Game;
import utilz.LoadSave;

public class QS extends State implements Statemethods {

    private BufferedImage backgroundImg;
    private ArrayList<ShowEntity> entitiesList;

    public QS(Game game) {
        super(game);
        backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.QS_menu);
        loadEntities();
    }

    private void loadEntities() {
        entitiesList = new ArrayList<>();
//        entitiesList.add(new ShowEntity(getIdleAni(LoadSave.GetSpriteAtlas(LoadSave.PLAYER_PIRATE), 5, 64, 40), (int) (Game.GAME_WIDTH * 0.60), (int) (Game.GAME_HEIGHT * 0.55)));
        entitiesList.add(new ShowEntity(getIdleAni(LoadSave.GetSpriteAtlas(LoadSave.SNAKE), 6, 64, 64), (int) (Game.GAME_WIDTH * 0.70), (int) (Game.GAME_HEIGHT * 0.55)));
        entitiesList.add(new ShowEntity(getIdleAni(LoadSave.GetSpriteAtlas(LoadSave.GORDON), 10, 128, 128), (int) (Game.GAME_WIDTH * 0.65), (int) (Game.GAME_HEIGHT * 0.75)));
        entitiesList.add(new ShowEntity(getIdleAni(LoadSave.GetSpriteAtlas(LoadSave.WOLF), 7, 64, 64), (int) (Game.GAME_WIDTH * 0.75), (int) (Game.GAME_HEIGHT * 0.75)));
    }

    private BufferedImage[] getIdleAni(BufferedImage atlas, int spritesAmount, int width, int height) {
        BufferedImage[] arr = new BufferedImage[spritesAmount];
        for (int i = 0; i < spritesAmount; i++)
            arr[i] = atlas.getSubimage(width * i, 0, width, height);
        return arr;
    }

    @Override
    public void update() {
        
        for (ShowEntity se : entitiesList)
            se.update();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
        for (ShowEntity se : entitiesList)
            se.draw(g);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
          
            setGamestate(Gamestate.MENU);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    private class ShowEntity {
        private BufferedImage[] idleAnimation;
        private int x, y, aniIndex, aniTick;

        public ShowEntity(BufferedImage[] idleAnimation, int x, int y) {
            this.idleAnimation = idleAnimation;
            this.x = x;
            this.y = y;
        }

        public void draw(Graphics g) {
            g.drawImage(idleAnimation[aniIndex], x, y, (int) (idleAnimation[aniIndex].getWidth() * 4), (int) (idleAnimation[aniIndex].getHeight() * 4), null);
        }

        public void update() {
            aniTick++;
            if (aniTick >= 25) {
                aniTick = 0;
                aniIndex++;
                if (aniIndex >= idleAnimation.length)
                    aniIndex = 0;
            }

        }
    }

}
