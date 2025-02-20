package io.github.game.AssetsControl;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
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
    private static Map<String, Music> musics;
    private static Map<String, Sound> sounds;
    private static AssetsControl assetsControl;
    private FreeTypeFontGenerator generator;
    private FreeTypeFontParameter parameter;
    private AssetsControl(){
        assetManager = new AssetManager();
        textures = new HashMap<String,Texture>();
        musics = new HashMap<String, Music>();
        sounds = new HashMap<String, Sound>();

        assetManager.load("Car.png", Texture.class);
        assetManager.load("Cars/OutrunCars.png", Texture.class);
        assetManager.load("Cars/TraficCars.png", Texture.class);
        assetManager.load("Cars/TraficCars2.png", Texture.class);
        assetManager.load("Cars/buggati.png", Texture.class);
        assetManager.load("Cars/LamborghiniDiablo.png", Texture.class);
        assetManager.load("Cars/LamborghiniRed.png", Texture.class);
        assetManager.load("backgrounds/background.jpg",Texture.class);
        assetManager.load("UI/Buttons/button.png",Texture.class);
        assetManager.load("UI/Buttons/buttonQuit.png",Texture.class);
        assetManager.load("UI/Buttons/buttonSettings.png",Texture.class);
        assetManager.load("UI/Buttons/buttonClose.png",Texture.class);
        assetManager.load("UI/Buttons/panel.png",Texture.class);
        assetManager.load("UI/Buttons/bar.png",Texture.class);
        assetManager.load("UI/Buttons/sfx.png",Texture.class);
        assetManager.load("UI/Buttons/circle.png",Texture.class);
        assetManager.load("UI/Buttons/sound.png",Texture.class);
        assetManager.load("UI/Buttons/buttonContinue.png",Texture.class);
        assetManager.load("UI/Buttons/buttonShop.png",Texture.class);
        assetManager.load("UI/Buttons/buttonCredits.png",Texture.class);
        assetManager.load("UI/Buttons/buttonMainMenu.png",Texture.class);
        assetManager.load("UI/Buttons/arrow.png",Texture.class);
        assetManager.load("UI/Buttons/arrow2.png",Texture.class);
        assetManager.load("UI/Building/1.png",Texture.class);
        assetManager.load("UI/Building/2.png",Texture.class);
        assetManager.load("UI/Building/3.png",Texture.class);
        assetManager.load("UI/TitleGame/nameGame.png",Texture.class);
        assetManager.load("UI/Road/Road.png",Texture.class);
        assetManager.load("UI/MuscleCar/Muscle_sheets.png",Texture.class);
        assetManager.load("UI/CityNeon/Sign 1/close.png",Texture.class);
        assetManager.load("UI/CityNeon/Sign 3/blue.png",Texture.class);
        assetManager.load("UI/CityNeon/Sign 4/green.png",Texture.class);
        assetManager.load("UI/CityNeon/Sign 8/green.png",Texture.class);
        assetManager.load("UI/CityNeon/Sign 17/pink.png",Texture.class);
        assetManager.load("UI/CityNeon/Sign 14/pink.png",Texture.class);
        assetManager.load("UI/CityNeon/Sign 19/cyan.png",Texture.class);
        assetManager.load("UI/Shop/blocked.png",Texture.class);
        assetManager.load("backgrounds/backgroundMenu.png",Texture.class);
        assetManager.load("Bosses/Ice.jpg",Texture.class);
        assetManager.load("Bosses/Sarah.jpg",Texture.class);
        assetManager.load("Bosses/Ws.jpg",Texture.class);
        assetManager.load("Race/BackgroundRaces/back1.png", Texture.class);
        assetManager.load("Race/BackgroundRaces/rio.png", Texture.class);
        assetManager.load("Race/Cenary/OutdoorSega.png", Texture.class);
        assetManager.load("Race/Cenary/OutdoorCamb.png", Texture.class);
        assetManager.load("Race/Cenary/Tree.png", Texture.class);
        assetManager.load("Race/Cenary/rock.png", Texture.class);
        assetManager.load("Race/Cenary/curve.png", Texture.class);
        assetManager.load("Race/Cenary/curve2.png", Texture.class);
        assetManager.load("Race/Cenary/plant.png", Texture.class);
        assetManager.load("Race/Cenary/bakery.png", Texture.class);
        assetManager.load("Race/Cenary/stars.png", Texture.class);
        assetManager.load("Race/Cenary/lineRace.png", Texture.class);
        assetManager.load("Race/UI/velocimeter.png", Texture.class);
        assetManager.load("Race/Cenary/lampost.png", Texture.class);
        assetManager.load("Race/BackgroundRaces/city.jpg",Texture.class);
        assetManager.load("Musics/my!lane - This Feeling (Instrumental).mp3",Music.class);
   
        assetManager.load("Sounds/glitch.mp3",Sound.class);

        assetManager.finishLoading();
        
        textures.put("Car", assetManager.get("Car.png", Texture.class));
        textures.put("OutrunCars", assetManager.get("Cars/OutrunCars.png", Texture.class));        
        textures.put("Buggati", assetManager.get("Cars/buggati.png", Texture.class));        
        textures.put("Lamborghini", assetManager.get("Cars/LamborghiniDiablo.png", Texture.class));
        textures.put("LamborghiniRed", assetManager.get("Cars/LamborghiniRed.png", Texture.class));
        textures.put("TraficCars", assetManager.get("Cars/TraficCars.png", Texture.class));        
        textures.put("TraficCars2", assetManager.get("Cars/TraficCars2.png", Texture.class));        
        textures.put("BackgroundStart", assetManager.get("backgrounds/background.jpg", Texture.class));
        textures.put("ButtonPlay", assetManager.get("UI/Buttons/button.png", Texture.class));
        textures.put("ButtonQuit", assetManager.get("UI/Buttons/buttonQuit.png", Texture.class));
        textures.put("ButtonSettings", assetManager.get("UI/Buttons/buttonSettings.png", Texture.class));
        textures.put("ButtonClose", assetManager.get("UI/Buttons/buttonClose.png", Texture.class));
        textures.put("panelSettings", assetManager.get("UI/Buttons/panel.png", Texture.class));
        textures.put("ButtonContinue", assetManager.get("UI/Buttons/buttonContinue.png", Texture.class));
        textures.put("ButtonShop", assetManager.get("UI/Buttons/buttonShop.png", Texture.class));
        textures.put("ButtonCredits", assetManager.get("UI/Buttons/buttonCredits.png", Texture.class));
        textures.put("ButtonMainMenu", assetManager.get("UI/Buttons/buttonMainMenu.png", Texture.class));
        textures.put("ButtonRight", assetManager.get("UI/Buttons/arrow.png", Texture.class));
        textures.put("ButtonLeft", assetManager.get("UI/Buttons/arrow2.png", Texture.class));
        textures.put("Building1", assetManager.get("UI/Building/1.png",Texture.class));
        textures.put("Building2", assetManager.get("UI/Building/2.png",Texture.class));
        textures.put("Building3", assetManager.get("UI/Building/3.png",Texture.class));
        textures.put("Title", assetManager.get("UI/TitleGame/nameGame.png",Texture.class));
        textures.put("Road", assetManager.get("UI/Road/Road.png",Texture.class));
        textures.put("MenuCar", assetManager.get("UI/MuscleCar/Muscle_sheets.png",Texture.class));
        textures.put("BackgroundMenu", assetManager.get("backgrounds/backgroundMenu.png",Texture.class));
        textures.put("ElementyCity1", assetManager.get("UI/CityNeon/Sign 1/close.png",Texture.class));
        textures.put("ElementyCity2", assetManager.get("UI/CityNeon/Sign 3/blue.png",Texture.class));
        textures.put("ElementyCity3", assetManager.get("UI/CityNeon/Sign 4/green.png",Texture.class));
        textures.put("ElementyCity4", assetManager.get("UI/CityNeon/Sign 8/green.png",Texture.class));
        textures.put("ElementyCity5", assetManager.get("UI/CityNeon/Sign 17/pink.png",Texture.class));
        textures.put("ElementyCity6", assetManager.get("UI/CityNeon/Sign 14/pink.png",Texture.class));
        textures.put("ElementyCity7", assetManager.get("UI/CityNeon/Sign 19/cyan.png",Texture.class));
        textures.put("Blocked", assetManager.get("UI/Shop/blocked.png",Texture.class));
        textures.put("Stars", assetManager.get("Race/Cenary/stars.png",Texture.class));
        textures.put("BarVolume",assetManager.get("UI/Buttons/bar.png",Texture.class));
        textures.put("Sfx",assetManager.get("UI/Buttons/sfx.png",Texture.class));
        textures.put("Circle",assetManager.get("UI/Buttons/circle.png",Texture.class));
        textures.put("Sound",assetManager.get("UI/Buttons/sound.png",Texture.class));
        textures.put("IconIce",assetManager.get("Bosses/Ice.jpg",Texture.class));
        textures.put("IconSarah",assetManager.get("Bosses/Sarah.jpg",Texture.class));
        textures.put("IconWs",assetManager.get("Bosses/Ws.jpg",Texture.class));
        textures.put("race1",assetManager.get("Race/BackgroundRaces/back1.png",Texture.class));
        textures.put("race2",assetManager.get("Race/BackgroundRaces/rio.png",Texture.class));
        textures.put("race3",assetManager.get("Race/BackgroundRaces/city.jpg",Texture.class));
        textures.put("OutdoorSega",assetManager.get("Race/Cenary/OutdoorSega.png", Texture.class));
        textures.put("OutdoorCamb",assetManager.get("Race/Cenary/OutdoorCamb.png", Texture.class));
        textures.put("Tree",assetManager.get("Race/Cenary/Tree.png", Texture.class));
        textures.put("Rock",assetManager.get("Race/Cenary/rock.png", Texture.class));
        textures.put("Curve",assetManager.get("Race/Cenary/curve.png", Texture.class));
        textures.put("Curve2",assetManager.get("Race/Cenary/curve2.png", Texture.class));
        textures.put("Plant",assetManager.get("Race/Cenary/plant.png", Texture.class));
        textures.put("Bakery",assetManager.get("Race/Cenary/bakery.png", Texture.class));
        textures.put("Lamppost",assetManager.get("Race/Cenary/lampost.png", Texture.class));
        textures.put("lineRace",assetManager.get("Race/Cenary/lineRace.png", Texture.class));
        textures.put("velocimeterUI",assetManager.get("Race/UI/velocimeter.png", Texture.class));

        musics.put("Music1", assetManager.get("Musics/my!lane - This Feeling (Instrumental).mp3",Music.class));
      

        sounds.put("Sound1",assetManager.get("Sounds/glitch.mp3",Sound.class));

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
        return musics.get(key);
    }

    public Sound getSound(String key){
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

    public static float getStateTime() {
        return stateTime;
    }

}
