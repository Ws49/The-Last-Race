package io.github.game.stages.AdditionalGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.Screens.GameScreen;
import io.github.game.stages.AdditionalGame.UIobjects.BoxDrawablesUI;
import io.github.game.stages.AdditionalGame.UIobjects.BuildingUI;
import io.github.game.stages.AdditionalGame.UIobjects.MenuCarUI;
import io.github.game.stages.AdditionalGame.UIobjects.RoadUI;
import io.github.game.stages.AdditionalGame.UIobjects.TypesBuildingUI;


public class StartGame extends Stage {
    private SpriteBatch batch;
    private Texture MenuBackgroundTexture;
    private Texture titleGame;
    private AssetsControl assetsControl;
    private BitmapFont font;
    private Screen contextMainGame;
    private BoxDrawablesUI drawablesUI;
    private MenuCarUI menuCar;
    private long lastBuildingTime;
    private long lastRoadTime;
    private long updateTransparecny;
    private float transparency;
    private boolean upTransparecny;
    private Music music;

    public StartGame(Screen contextMainGame) {
        batch = new SpriteBatch();
   
        assetsControl = AssetsControl.getInstanceAssetsControl();
           
        MenuBackgroundTexture = assetsControl.getTexture("BackgroundStart");
        titleGame = assetsControl.getTexture("Title");
        font = assetsControl.getFont("Font/Pixel.ttf", 12);
        music = assetsControl.getMusic("Music1");
        

        menuCar = new MenuCarUI();
        drawablesUI = new BoxDrawablesUI();
        this.contextMainGame = contextMainGame;

        transparency = 0f;
        updateTransparecny = TimeUtils.millis();
        upTransparecny = true;

        
        drawablesUI.addDrawable(menuCar);
        drawablesUI.setY(-25);
        drawablesUI.setX(0);

        spawnBuilding();
        spawRoad();

        music.play();
        music.setVolume(0.1f);
        music.setLooping(true);
    }

    public void spawRoad(){
        if(lastRoadTime == 0){
            int space = 0;
            for(int i =0; i < 5;i++){
                RoadUI roadUI = new RoadUI();
                if(i ==0 ){
                    space = ((int) ((float) roadUI.getWidth() * -1.2f));
                }
                roadUI.setX(space);
                roadUI.setY(0);
                roadUI.setSize(345, 150);
                drawablesUI.addDrawable(roadUI);

                space += roadUI.getWidth();
            }
        }else{
            RoadUI roadUI = new RoadUI();
            roadUI.setX((int) ((float) roadUI.getWidth() * -1.2f));

            roadUI.setY(0);
            roadUI.setSize(345, 150);
            drawablesUI.addDrawable(roadUI);
        }
        lastRoadTime = TimeUtils.millis();
    }


    public void spawnBuilding(){
        if(lastBuildingTime == 0){
            int space =0;
            for(int i =0; i < 5;i++){
                if(i == 0){
                    space = (TypesBuildingUI.BUILDING1.getWidth() * -1);
                }

                drawablesUI.addDrawable(new BuildingUI(TypesBuildingUI.BUILDING1,space,100));
                drawablesUI.addDrawable(new BuildingUI(TypesBuildingUI.BUILDING2,space,10));
                drawablesUI.addDrawable(new BuildingUI(TypesBuildingUI.BUILDING3,space,10));
                space += TypesBuildingUI.BUILDING1.getWidth();
            }
        }else{
            drawablesUI.addDrawable(new BuildingUI(TypesBuildingUI.BUILDING1,(TypesBuildingUI.BUILDING1.getWidth() * -1),100)); 
            drawablesUI.addDrawable(new BuildingUI(TypesBuildingUI.BUILDING2,(TypesBuildingUI.BUILDING2.getWidth() * -1),10));
            drawablesUI.addDrawable(new BuildingUI(TypesBuildingUI.BUILDING3,(TypesBuildingUI.BUILDING3.getWidth() * -1),10));
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
            ((GameScreen)contextMainGame).changeStage(new Menu(contextMainGame));
            this.dispose();
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
        assetsControl.update(delta);
        drawablesUI.update();
        updateScreen();
    }
    
    @Override
    public void draw() {
        super.draw();
        batch.begin();

        batch.draw(MenuBackgroundTexture, 0,0, getWidth(), getHeight());
        drawablesUI.draw(batch);

        //batch.setColor(0, 255, 255,transparency);
        batch.draw(titleGame, 150,320, 700, 250);
       // batch.setColor(Color.WHITE);
        font.setColor(0, 255, 255,transparency);

        font.draw(batch, "PRESS ENTER", 440, 300);
        

        batch.end();
    }

    
    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        //music.dispose();
        MenuBackgroundTexture.dispose();
        //titleGame.dispose();

    }
}
