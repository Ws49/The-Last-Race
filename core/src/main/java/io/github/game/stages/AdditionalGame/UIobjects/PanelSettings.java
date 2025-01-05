package io.github.game.stages.AdditionalGame.UIobjects;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.github.game.AssetsControl.AssetsControl;

public class PanelSettings implements DrawableUI{
    private Texture backgroundPanel;
    private float x,y,width,height;
    private static PanelSettings panel;

    private PanelSettings(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.backgroundPanel = AssetsControl.getInstanceAssetsControl().getTexture("panelSettings");
    }

    public static PanelSettings getPanelSettings(){
        if(panel == null){
            panel = new PanelSettings(70, 90, 900, 600);
        }
        return panel;
    }
    @Override
    public void draw(SpriteBatch batch) {
        batch.setColor(255, 255, 255, 0.7f);
        batch.draw(backgroundPanel, x, y,width,height);    
        batch.setColor(Color.WHITE);
    }

    @Override
    public void update() {
        
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }
    @Override
    public void setY(int y) {
       this.y = y;
    }
    @Override
    public int getY() {
       return (int)y;
    }
    @Override
    public int getX() {
       return (int)x;
    }
 
}
