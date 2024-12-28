package io.github.game.AssetsControl;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class AssetsControl{
    private AssetManager assetManager;
    private static float stateTime;

    private static Map<String, Texture> textures;
    private static Map<String, Music> sounds;
    private static AssetsControl assetsControl;

    private AssetsControl(){
        assetManager = new AssetManager();
        textures = new HashMap<String,Texture>();

        assetManager.load("Car2.png", Texture.class);

        textures.put("Car", assetManager.get("Car2.png", Texture.class));
        stateTime = 0f;
    }
     
    public static AssetsControl getInstanceAssetsControl(){
        if(assetsControl == null){
            assetsControl = new AssetsControl();
        }
        return assetsControl;
    }

    public void update(float deltaTime){
        stateTime += deltaTime;
    }

    public Texture getTexture(String key){
        return textures.get(key);
    }

    public TextureRegion[][] getTextureRegions(String key, Vector2 size){
        return TextureRegion.split(textures.get(key), (int)size.x, (int)size.y);
    }

    public TextureRegion[][] getTextureRegions(String key){
        return getTextureRegions(key, new Vector2(60,60));
    }

    public Animation<TextureRegion> getAnimation(TextureRegion[][] textureRegion, int line, float duration){
        return new Animation<TextureRegion>(duration, textureRegion[line]);
    }

    public TextureRegion getCurrentRegion(Animation<TextureRegion> animation){
        return animation.getKeyFrame(stateTime,true);
    }


}
