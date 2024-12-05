package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.Game;
import utilz.LoadSave;

public class QS extends State implements Statemethods {
    boolean flag = false;
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
        entitiesList.add(new ShowEntity(getIdleAni(LoadSave.GetSpriteAtlas(LoadSave.SNAKE), 6, 64, 64), (int) (Game.GAME_WIDTH * 0.12), (int) (Game.GAME_HEIGHT * 0.11)));
        entitiesList.add(new ShowEntity(getIdleAni(LoadSave.GetSpriteAtlas(LoadSave.GORDON), 5, 96, 96), (int) (Game.GAME_WIDTH * 0.60), (int) (Game.GAME_HEIGHT * 0.20)));
        entitiesList.add(new ShowEntity(getIdleAni(LoadSave.GetSpriteAtlas(LoadSave.WOLF), 6, 64, 64), (int) (Game.GAME_WIDTH * 0.15), (int) (Game.GAME_HEIGHT * 0.57)));
    }

    private BufferedImage[] getIdleAni(BufferedImage atlas, int spritesAmount, int width, int height) {
        BufferedImage[] arr = new BufferedImage[spritesAmount];
        for (int i = 0; i < spritesAmount; i++)
            arr[i] = atlas.getSubimage(width * i, 0, width, height);
        return arr;
    }

    @Override
    public void update() {     
        
        if (flag) {
            backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.QS1_img);
            for (ShowEntity se : entitiesList)
            se.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
        if(flag){
            for (ShowEntity se : entitiesList)
            se.draw(g);
        }   
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:         
                flag = false;    
                backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.QS_menu);
                setGamestate(Gamestate.MENU);  
                          
                break;
            case KeyEvent.VK_ENTER:
                flag = true;
                break;
            default:
                break;
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
