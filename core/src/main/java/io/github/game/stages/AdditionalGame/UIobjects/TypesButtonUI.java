package io.github.game.stages.AdditionalGame.UIobjects;

import com.badlogic.gdx.graphics.Texture;


import io.github.game.AssetsControl.AssetsControl;

public enum TypesButtonUI {
    PLAY(AssetsControl.getInstanceAssetsControl().getTexture("ButtonPlay"), 300,120),
    QUIT(AssetsControl.getInstanceAssetsControl().getTexture("ButtonQuit"), 300,120),
    SETTING(AssetsControl.getInstanceAssetsControl().getTexture("ButtonSettings"), 90,80),
    CLOSE(AssetsControl.getInstanceAssetsControl().getTexture("ButtonClose"), 70,60),
    VOLUME(AssetsControl.getInstanceAssetsControl().getTexture("Circle"), 65,65),
    CONTINUE(AssetsControl.getInstanceAssetsControl().getTexture("ButtonContinue"), 400,120),
    SHOP(AssetsControl.getInstanceAssetsControl().getTexture("ButtonShop"), 400,120),
    CREDITS(AssetsControl.getInstanceAssetsControl().getTexture("ButtonCredits"), 400,120),
    MAINMENU(AssetsControl.getInstanceAssetsControl().getTexture("ButtonMainMenu"), 400,120);

    private Texture textureButton;
    private float height;
    private float width;

    TypesButtonUI(Texture textureButton,float width,float height){
        this.textureButton = textureButton;
        this.width = width;
        this.height = height;
    }


    public Texture getTextureButton(){
        return textureButton;
    }

    public float getHeight(){
        return height;
    }

    public float getWidth(){
        return width;
    }

}
