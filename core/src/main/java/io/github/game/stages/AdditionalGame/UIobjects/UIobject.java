package io.github.game.stages.AdditionalGame.UIobjects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import io.github.game.AssetsControl.AssetsControl;

public abstract class UIobject{

    protected Animation<TextureRegion> animation;
    protected TextureRegion[][] textureRegions;
    protected TextureRegion currentTRegion;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    public UIobject(String nameSprite,Vector2 sizeTextureRegion,float duration){
        textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions(nameSprite,sizeTextureRegion);
        animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, 0, duration);
        currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);
        this.x=0;
        this.y=0;
    }
    public UIobject(String nameSprite,Vector2 sizeTextureRegion,int x, int y,float duration){
        textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions(nameSprite,sizeTextureRegion);
        animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, 0, duration);
        currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);
        this.x=x;
        this.y=y;
    }

}
