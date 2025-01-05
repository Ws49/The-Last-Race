package io.github.game.stages.AdditionalGame.UIobjects;
import com.badlogic.gdx.math.Vector2;

import io.github.game.AssetsControl.AssetsControl;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class MenuCarUI extends UIobject implements DrawableUI {
    int width;
    int height;
    int lineFrame;
     boolean isAccelerate;
    public MenuCarUI(){
        super("MenuCar", new Vector2(100,100),0.1f);
        this.width = 370;
        this.height = 330;
        this.lineFrame = 0;
        this.isAccelerate = false;
    }

    @Override
    public void draw(SpriteBatch batch){
        batch.draw(currentTRegion, x, y,width,height);
    }

    @Override
    public void update(){
        animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, lineFrame, 0.1f);
        currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);

        if((int)AssetsControl.getStateTime() % 2 == 0){
            lineFrame = 0;
            this.isAccelerate = false;
        }else{
            lineFrame = 1;
            this.isAccelerate = true;
        }


    }


    @Override
    public void setX(int x){
        this.x = x + 300;
    }
    @Override
    public void setY(int y){
        this.y = y - 36;
    }
    @Override
    public int getY(){
        return y;
    }
    @Override
    public int getX(){
        return x;
    }
    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }
}

