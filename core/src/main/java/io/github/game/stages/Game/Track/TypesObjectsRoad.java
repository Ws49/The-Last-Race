package io.github.game.stages.Game.Track;

import com.badlogic.gdx.graphics.Texture;

import io.github.game.AssetsControl.AssetsControl;

public enum TypesObjectsRoad {
    OUTDOOR_SEGA(AssetsControl.getInstanceAssetsControl().getTexture("OutdoorSega"), 50, 50),
    OUTDOOR_CAMB(AssetsControl.getInstanceAssetsControl().getTexture("OutdoorCamb"), 50, 50),
    TREE(AssetsControl.getInstanceAssetsControl().getTexture("Tree"), 50, 50),
    ROCK(AssetsControl.getInstanceAssetsControl().getTexture("Rock"), 50, 50),
    CURVE(AssetsControl.getInstanceAssetsControl().getTexture("Curve"), 0,0),
    CURVE2(AssetsControl.getInstanceAssetsControl().getTexture("Curve2"), 0,0),
    PLANT(AssetsControl.getInstanceAssetsControl().getTexture("Plant"), 50, 50),
    BAKERY(AssetsControl.getInstanceAssetsControl().getTexture("Bakery"), 50, 50);
    //TREE();
    private Texture texture;
    private int width;
    private int height;

    private TypesObjectsRoad(Texture texture, int width, int height){
        this.texture =texture;
        this.width = width;
        this.height = height;
    }

    public Texture getTexture() {
        return texture;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}

