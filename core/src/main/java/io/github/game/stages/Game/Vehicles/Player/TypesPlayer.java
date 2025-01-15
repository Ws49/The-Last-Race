package io.github.game.stages.Game.Vehicles.Player;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import io.github.game.AssetsControl.AssetsControl;

public enum TypesPlayer {
    BUGATTI(AssetsControl.getInstanceAssetsControl().getTextureRegions("Buggati", new Vector2(70, 41)),900),
    LAMBORGHINI(AssetsControl.getInstanceAssetsControl().getTextureRegions("Lamborghini", new Vector2(62, 37)),600),
    LAMBORGHINI_RED(AssetsControl.getInstanceAssetsControl().getTextureRegions("LamborghiniRed", new Vector2(82,45)),700);

    private TextureRegion textures[][];
    private int  maxAcceleration;

    private TypesPlayer(TextureRegion[][] textures, int maxAcceleration){
        this.textures = textures;
        this.maxAcceleration = maxAcceleration;
    }
    public int getMaxAcceleration() {
        return maxAcceleration;
    }
    public TextureRegion[][] getTextures() {
        return textures;
    }
}
