package io.github.game.stages.Vehicles;



import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


import io.github.game.AssetsControl.AssetsControl;

public abstract class Vehicles {
    Animation<TextureRegion> animation;
    protected TextureRegion[][] textureRegions;
    protected TextureRegion currentTRegion;
    protected int speed;
    protected int metersTraveled;


    protected float width;
    protected float height;
    protected float posX;
    protected float posY;
    protected Color color;


    public Vehicles(int posX,int posY,int width,int height){
       this.posX = posX;
       this.posY = posY;
       this.width = width;
       this.height = height;
    }

    public void draw(SpriteBatch batch){
        this.currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);
        batch.setColor(color);
        batch.draw(currentTRegion, posX, posY,width,height);
        batch.setColor(Color.WHITE);
    }
 

    
    public void updateMeters(){
        metersTraveled += speed;
       
    }

    public void update(){
        updateMeters();
        
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void speedUp(int accelerate){
        this.speed += accelerate;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMetersTraveled() {
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
