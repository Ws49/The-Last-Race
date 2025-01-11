package io.github.game.stages.AdditionalGame.UIobjects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import io.github.game.AssetsControl.AssetsControl;



public class CitySignsDecorationUI extends UIobject implements DrawableUI {
    public CitySignsDecorationUI(String name, Vector2 sizeFrame, float duration,int x,int y){
        super(name, sizeFrame, duration);
        this.x=x;
        this.y=y;
        this.width = 50;
        this.height = 50;

    }

    public CitySignsDecorationUI(String name, Vector2 sizeFrame, float duration,int x,int y,int width, int height){
        super(name, sizeFrame, duration);
        this.x=x;
        this.y=y;
        this.width = width;
        this.height = height;

    }
    @Override
    public void draw(SpriteBatch batch) {
        currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);
       batch.draw(currentTRegion, x, y,width,height); 
    }
    @Override
    public void update() {

    }
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {

        return y;
    }

    @Override
    public void setX(int x) {

        this.x = x;
    }

    @Override
    public void setY(int y) {

        this.y = y;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }
    
    
}
