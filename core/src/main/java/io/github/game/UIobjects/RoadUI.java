package io.github.game.UIobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class RoadUI extends UIobject implements DrawableUI{
    int width;
    int height;
    public RoadUI(){
        super("Road", new Vector2(436, 190));
        this.width = 300;
        this.height = 80;
    }


    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(currentTRegion, x, y,width,height);
    }

    @Override
    public void update() {
        this.x +=2;  
    }


    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }
    @Override
    public int getY() {
       return y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
            this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
}
