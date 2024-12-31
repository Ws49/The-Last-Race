package io.github.game.UIobjects;

import com.badlogic.gdx.math.Vector2;

public enum TypesBuildingUI {
    BUILDING1("Building1", new Vector2(576, 324),750,750),
    BUILDING2("Building2", new Vector2(576, 324),900,900),
    BUILDING3("Building3", new Vector2(576, 324),900,900);
   

    private String nameType;
    private Vector2 sizeTextureRegion;
    private int width;
    private int height;

    TypesBuildingUI(String nameType, Vector2 sizeTexture, int width, int height){
        this.nameType = nameType;
        this.sizeTextureRegion = sizeTexture;
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public String getNameType() {
        return nameType;
    }
    public Vector2 getSizeTextureRegion() {
        return sizeTextureRegion;
    }
  
}
