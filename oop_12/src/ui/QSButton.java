package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gamestates.Gamestate;
import main.Game;
import utilz.LoadSave;
import static utilz.Constants.UI.QSButton.*;

public class QSButton {
  private int xPos, yPos, index;
  private Gamestate state;
  private BufferedImage[] imgs;
  private boolean mouseOver, mousePressed;
  private Rectangle bounds;
  
  public QSButton(int xPos, int yPos, Gamestate state) {
    this.state = state;
    this.xPos = (int) (Game.GAME_WIDTH  - 200 * Game.SCALE);
    this.yPos = (int) (Game.GAME_HEIGHT - 100 * Game.SCALE);
    loadImgs();
    initBounds();
  }

  private void initBounds() {
    bounds = new Rectangle(xPos, yPos, QS_WIDTH, QS_HEIGHT);
  }
  private void loadImgs() {
    imgs = new BufferedImage[3];
    BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.QS_BUTTON);
    
    // Kiểm tra xem ảnh có được tải đúng không
    if (temp == null) {
        System.out.println("Error: Image could not be loaded.");
        return;
    }

    // In ra chiều rộng và chiều cao của ảnh gốc
    System.out.println("Image loaded. Width: " + temp.getWidth() + ", Height: " + temp.getHeight());
    
    for (int i = 0; i < imgs.length; i++) {
        // In ra thông tin subimage
        System.out.println("Loading subimage " + i + " at x: " + (i * QS_WIDTH_DEFAULT) + ", y: 0");
        imgs[i] = temp.getSubimage(i * QS_WIDTH_DEFAULT, 0 * QS_HEIGHT_DEFAULT, QS_WIDTH_DEFAULT, QS_HEIGHT_DEFAULT);
    }
}


  public void draw(Graphics g) {
    g.drawImage(imgs[index] , xPos, yPos, QS_WIDTH, QS_HEIGHT, null);
  }

  public void update() {
    index = 0;
    if (mouseOver)
      index = 1;
    if (mousePressed)
      index = 2;
  }

  public boolean isMouseOver() {
    return mouseOver;
  }

  public void setMouseOver(boolean mouseOver) {
    this.mouseOver = mouseOver;
  }

  public boolean isMousePressed() {
    return mousePressed;
  }

  public void setMousePressed(boolean mousePressed) {
    this.mousePressed = mousePressed;
  }

  public Rectangle getBounds() {
    return bounds;
  }

  public void applyGamestate() {
    Gamestate.state = state;
  }

  public void resetBools() {
    mouseOver = false;
    mousePressed = false;
  }
  public Gamestate getState() {
    return state;
  }

}
