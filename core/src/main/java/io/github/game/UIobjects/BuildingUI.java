package io.github.game.UIobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class BuildingUI extends UIobject implements DrawableUI{

    public BuildingUI(TypesBuildingUI typeBuildingUI){
            super(typeBuildingUI.getNameType(),typeBuildingUI.getSizeTextureRegion());
            this.height = typeBuildingUI.getHeight();
            this.width = typeBuildingUI.getWidth();

    }

    public BuildingUI(TypesBuildingUI typeBuildingUI, int x, int y){
        super(typeBuildingUI.getNameType(),typeBuildingUI.getSizeTextureRegion(),x,y);
        this.height = typeBuildingUI.getHeight();
        this.width = typeBuildingUI.getWidth();
}


    @Override
    public void draw(SpriteBatch batch) {
        batch.setColor(Color.MAGENTA);
        batch.draw(currentTRegion, x, y,height,width);
        batch.setColor(Color.WHITE);
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }
    @Override
    public void update() {
        this.x +=2;  
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
