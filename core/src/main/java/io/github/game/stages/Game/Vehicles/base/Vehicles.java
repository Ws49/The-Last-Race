package io.github.game.stages.Game.Vehicles.base;



import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


import io.github.game.AssetsControl.AssetsControl;

public abstract class Vehicles {
    Animation<TextureRegion> animation;
    protected TextureRegion[][] textureRegions;
    protected TextureRegion currentTRegion;
    protected float metersTraveled;
    protected int lineFrame;

    protected float width;
    protected float height;
    protected float posX;
    protected float posY;
    protected Color color;
    protected boolean isOneTexutre;

    public Vehicles(int posX,int posY,float width,float height){
       this.posX = posX;
       this.posY = posY;
       this.width = width;
       this.height = height;
 
    }

    public void draw(SpriteBatch batch){
        if(isOneTexutre){
            batch.setColor(color);
            batch.draw(textureRegions[lineFrame][0], posX, posY,width,height);
            batch.setColor(Color.WHITE);  
        }else{
            this.currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);
            batch.setColor(color);
            batch.draw(currentTRegion, posX, posY,width,height);
            batch.setColor(Color.WHITE);
        }
    }

    public abstract void update();
    
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void metersTraveledUp(float accelerate){
        this.metersTraveled += accelerate;
    }
    public float getMetersTraveled() {
        return metersTraveled;
    }
    public void setMetersTraveled(int metersTraveled) {
        this.metersTraveled = metersTraveled;
    }
    
    public float getPosX() {
        return posX;
    }
    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }
    public void setPosY(float posY) {
        this.posY = posY;
    }
    public float getWidth() {
        return width;
    }
    
    public float getHeight() {
        return height;
    }
}
