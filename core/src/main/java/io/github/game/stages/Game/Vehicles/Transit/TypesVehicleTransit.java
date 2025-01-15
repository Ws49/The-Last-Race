package io.github.game.stages.Game.Vehicles.Transit;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import io.github.game.AssetsControl.AssetsControl;

public enum TypesVehicleTransit {
    TRUCK(AssetsControl.getInstanceAssetsControl().getTextureRegions("OutrunCars", new Vector2(64, 64)),250,250,2,0f),
    JEEP(AssetsControl.getInstanceAssetsControl().getTextureRegions("OutrunCars", new Vector2(64, 64)),250,250,1,0f),
    TRUCK2(AssetsControl.getInstanceAssetsControl().getTextureRegions("TraficCars", new Vector2(78,78)),250,250,3,0f),
    TRUCK3(AssetsControl.getInstanceAssetsControl().getTextureRegions("TraficCars2", new Vector2(125,145)),250,250,0,0f),
    POLICE(AssetsControl.getInstanceAssetsControl().getTextureRegions("TraficCars", new Vector2(68,57)),150,150,3,0f),
    CAR_PINK(AssetsControl.getInstanceAssetsControl().getTextureRegions("TraficCars2", new Vector2(125,82)),150,100,3,0f),
    CAR_GREEN(AssetsControl.getInstanceAssetsControl().getTextureRegions("TraficCars2", new Vector2(115,78)),250,200,2,0f),

    FERRARI(AssetsControl.getInstanceAssetsControl().getTextureRegions("OutrunCars", new Vector2(64, 64)),250,250,0,0f),
    PORSHE(AssetsControl.getInstanceAssetsControl().getTextureRegions("TraficCars", new Vector2(78,54)),200,200,1,0f);

    private float durationAnimation;

    private float width;
    private float height; 
    private TextureRegion regionTexture[][];
    private int lineFrame;

    private TypesVehicleTransit(TextureRegion regionTexture[][], float width,float height,int lineFrame,float duration){
        this.regionTexture = regionTexture;
        this.width = width;
        this.height =height;
        this.lineFrame = lineFrame;
        this.durationAnimation = duration;
      
    }

    public int getLineFrame() {
        return lineFrame;
    }
    public float getWidth() {
        return width;
    }
    public float getHeight() {
        return height;
    }

    public float getDurationAnimation() {
        return durationAnimation;
    }
    public TextureRegion[][] getRegionTexture() {
        return regionTexture;
    }
}
