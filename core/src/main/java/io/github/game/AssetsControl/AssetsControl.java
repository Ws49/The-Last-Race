package io.github.game.AssetsControl;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.Vector2;

public class AssetsControl{
    private AssetManager assetManager;
    private static float stateTime;

    private static Map<String, Texture> textures;
    private static Map<String, Music> sounds;
    private static AssetsControl assetsControl;
    private FreeTypeFontGenerator generator;
    private FreeTypeFontParameter parameter;
    private AssetsControl(){
        assetManager = new AssetManager();
        textures = new HashMap<String,Texture>();
        sounds = new HashMap<String, Music>();
        
        assetManager.load("Car.png", Texture.class);
        assetManager.load("buttom.png",Texture.class);
        assetManager.load("background.jpg",Texture.class);
        assetManager.load("UI/Building/1.png",Texture.class);
        assetManager.load("UI/Building/2.png",Texture.class);
        assetManager.load("UI/Building/3.png",Texture.class);
        assetManager.load("UI/TitleGame/nameGame.png",Texture.class);
        assetManager.load("UI/Road/Road.png",Texture.class);
        assetManager.load("Muscle/MOVE/WEST/Muscle_sheets.png",Texture.class);
        assetManager.load("Musics/my!lane - This Feeling (Instrumental).mp3",Music.class);
        assetManager.finishLoading();
        
        textures.put("Car", assetManager.get("Car.png", Texture.class));
        textures.put("ButtonStart", assetManager.get("buttom.png", Texture.class));
        textures.put("MenuBackground", assetManager.get("background.jpg", Texture.class));
        textures.put("Building1", assetManager.get("UI/Building/1.png",Texture.class));
        textures.put("Building2", assetManager.get("UI/Building/2.png",Texture.class));
        textures.put("Building3", assetManager.get("UI/Building/3.png",Texture.class));
        textures.put("Title", assetManager.get("UI/TitleGame/nameGame.png",Texture.class));
        textures.put("Road", assetManager.get("UI/Road/Road.png",Texture.class));
        textures.put("MenuCar", assetManager.get("Muscle/MOVE/WEST/Muscle_sheets.png",Texture.class));

        sounds.put("MainMusic", assetManager.get("Musics/my!lane - This Feeling (Instrumental).mp3",Music.class));
        parameter = new FreeTypeFontParameter();
        stateTime = 0f;
    }
     
    public static AssetsControl getInstanceAssetsControl(){
        if(assetsControl == null){
            assetsControl = new AssetsControl();
        }
        return assetsControl;
    }

    public BitmapFont getFont(String pathName, int size){
        generator = new FreeTypeFontGenerator(Gdx.files.internal(pathName));
        parameter.size = size;
    
        return generator.generateFont(parameter);
    }
    public void update(float deltaTime){
        stateTime += deltaTime;
    }

    public Texture getTexture(String key){
        return textures.get(key);
    }

    public Music getMusic(String key){
        return sounds.get(key);
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
