package io.github.game.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.Screens.GameScreen;
import io.github.game.UIobjects.BuildingUI;
import io.github.game.UIobjects.DrawablesUI;
import io.github.game.UIobjects.RoadUI;
import io.github.game.UIobjects.TypesBuildingUI;


public class StartGame extends Stage {
    private SpriteBatch batch;
    private Texture MenuBackgroundTexture;
    private Texture titleGame;
    private AssetsControl assetsControl;
    private BitmapFont font;
    private Screen mainGame;
    private DrawablesUI drawablesUI;
    private long lastBuildingTime;
    private long lastRoadTime;
    private long updateTransparecny;
    private float transparency;
    private boolean upTransparecny;
    private Music music;

    public StartGame(Screen mainGame) {
        batch = new SpriteBatch();
        assetsControl = AssetsControl.getInstanceAssetsControl();
        MenuBackgroundTexture = assetsControl.getTexture("MenuBackground");
        titleGame = assetsControl.getTexture("Title");
        transparency = 0f;
        font = assetsControl.getFont("Font/Pixel.ttf", 12);
        music = assetsControl.getMusic("MainMusic");
        music.play();
        music.setLooping(true);
        this.mainGame = mainGame;

        drawablesUI = new DrawablesUI();
        drawablesUI.setY(0);
        drawablesUI.setX(0);
        updateTransparecny = TimeUtils.millis();
        upTransparecny = true;
        spawnBuilding();
        spawRoad();
    }

    public void spawRoad(){
        if(lastRoadTime == 0){
            int space = 0;
            for(int i =0; i < 5;i++){
                RoadUI roadUI = new RoadUI();
                if(i ==0 ){
                    space = (roadUI.getWidth() * -1);
                }
                roadUI.setX(space);
                roadUI.setY(0);
                drawablesUI.addDrawable(roadUI);
                space += roadUI.getWidth();
            }
        }else{
            RoadUI roadUI = new RoadUI();
            roadUI.setX((roadUI.getWidth() * -1));
            roadUI.setY(0);
            drawablesUI.addDrawable(roadUI);
        }
        
        lastRoadTime = TimeUtils.millis();
    }


    public void spawnBuilding(){
        if(lastBuildingTime == 0){
            int space =0;
            for(int i =0; i < 5;i++){
                if(i == 0){
                    space = (TypesBuildingUI.Building1.getWidth() * -1);
                }

                drawablesUI.addDrawable(new BuildingUI(TypesBuildingUI.Building1,space,100));
                drawablesUI.addDrawable(new BuildingUI(TypesBuildingUI.Building2,space,10));
                drawablesUI.addDrawable(new BuildingUI(TypesBuildingUI.Building3,space,10));
                space += TypesBuildingUI.Building1.getWidth();
            }
        }else{
            drawablesUI.addDrawable(new BuildingUI(TypesBuildingUI.Building1,(TypesBuildingUI.Building1.getWidth() * -1),100)); 
            drawablesUI.addDrawable(new BuildingUI(TypesBuildingUI.Building2,(TypesBuildingUI.Building2.getWidth() * -1),10));
            drawablesUI.addDrawable(new BuildingUI(TypesBuildingUI.Building3,(TypesBuildingUI.Building3.getWidth() * -1),10));
        }
        lastBuildingTime = TimeUtils.millis();
    }


    public void updateScreen(){
        if (TimeUtils.millis() - lastBuildingTime > 3500) {
			spawnBuilding();
		}

        if (TimeUtils.millis() - lastRoadTime > 2400) {
            spawRoad();
		}

        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            ((GameScreen)mainGame).changeStage(new Menu(mainGame));
       }

       if(TimeUtils.millis() - updateTransparecny > 60){
        if(upTransparecny){
            transparency +=0.1;
            if(transparency > 1){
                upTransparecny = false;
            }
        }else{
            transparency -=0.1;
            if(transparency < 0){
                upTransparecny = true;
            }
        }

        updateTransparecny = TimeUtils.millis();
       }
       
    }


    @Override
    public void act(float delta) {
        super.act(delta);
        drawablesUI.update();
        updateScreen();
    }
    
    @Override
    public void draw() {
        super.draw();
        batch.begin();

        batch.draw(MenuBackgroundTexture, 0,0, getWidth(), getHeight());
        drawablesUI.draw(batch);

        batch.setColor(0, 255, 255,transparency);
        batch.draw(titleGame, 120,320, 400, 150);
        batch.setColor(Color.WHITE);
        font.setColor(0, 255, 255,transparency);

        font.draw(batch, "PRESS ENTER", 270, getHeight()/2);
        

        batch.end();
    }

    
    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        music.dispose();
        MenuBackgroundTexture.dispose();
        titleGame.dispose();
    }
}
