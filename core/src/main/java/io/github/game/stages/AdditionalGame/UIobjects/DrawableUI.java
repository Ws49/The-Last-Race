package io.github.game.stages.AdditionalGame.UIobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface DrawableUI {
    public void draw(SpriteBatch batch);
    public void update();
    public void setX(int x);
    public void setY(int y);
    public int getY();
    public int getX();
}
