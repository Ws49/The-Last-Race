package io.github.game.stages.Game;


import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.stages.AdditionalGame.UIobjects.BoxDrawablesUI;
import io.github.game.stages.AdditionalGame.UIobjects.CitySignsDecorationUI;
import io.github.game.stages.Game.Track.Track;
import io.github.game.stages.Game.Vehicles.FactoryVehiclesTransit;
import io.github.game.stages.Game.Vehicles.Types.TypesVehicleTransit;
import io.github.game.stages.Game.Vehicles.base.PlayerVehicle;





public class Level extends Stage {

    private ShapeRenderer sh;
    private SpriteBatch batch;

    private Track track;
    private PlayerVehicle playerVeicle;
    private Transit transit; 
    private long lastVehicleTime;
    private BitmapFont font;
    private Texture textureBackground;
    private BoxDrawablesUI drawablesUI;

    public Level() {
        sh = new ShapeRenderer();
        batch = new SpriteBatch();
        playerVeicle = new PlayerVehicle();
        track = new Track(200,playerVeicle);
        transit = new Transit(track.toWay(),200,playerVeicle); 
        font = AssetsControl.getInstanceAssetsControl().getFont("Font/Pixel.ttf", 48);
        textureBackground = AssetsControl.getInstanceAssetsControl().getTexture("race1");
        drawablesUI = new BoxDrawablesUI();
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity4", new Vector2(100, 31), 0.07f, 586,473, 50, 20));
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity5", new Vector2(23, 64), 0.07f, 708,378, 20, 100));
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity6", new Vector2(67, 66), 0.4f, 409,545, 60, 80));
        spawnVehicle();
    }

    public void spawnVehicle(){
        int typeVehicle = new Random().nextInt(1,7);
        switch (typeVehicle) {
            case 1:
                transit.addParticipant(FactoryVehiclesTransit.getVehicle(TypesVehicleTransit.TRUCK));
                break;

            case 2:
                transit.addParticipant(FactoryVehiclesTransit.getVehicle(TypesVehicleTransit.POLICE));
                break;
                
            case 3:
                transit.addParticipant(FactoryVehiclesTransit.getVehicle(TypesVehicleTransit.TRUCK2));
                break;
            
            case 4:
                transit.addParticipant(FactoryVehiclesTransit.getVehicle(TypesVehicleTransit.JEEP));
                break;
            case 5:
                transit.addParticipant(FactoryVehiclesTransit.getVehicle(TypesVehicleTransit.CAR_PINK));
                break;
            case 6:
                transit.addParticipant(FactoryVehiclesTransit.getVehicle(TypesVehicleTransit.TRUCK3));
                break;
            case 7:
                transit.addParticipant(FactoryVehiclesTransit.getVehicle(TypesVehicleTransit.CAR_GREEN));
                break;
        
            default:
                break;
        }
        
        lastVehicleTime = TimeUtils.millis();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        AssetsControl.getInstanceAssetsControl().update(delta);

        playerVeicle.update();
        transit.update();
        
        drawablesUI.update();

        if (TimeUtils.millis() - lastVehicleTime > 5000) {
            spawnVehicle();
            lastVehicleTime = TimeUtils.millis();
        }

        
    }

    @Override
    public void draw() {
        super.draw();
        batch.begin();
        batch.draw(textureBackground, 0,-20,Gdx.graphics.getWidth() * 2,Gdx.graphics.getHeight() * 2);
        drawablesUI.draw(batch);
        batch.end();

        sh.begin(ShapeType.Filled);
        track.drawRoads(sh);
        sh.end();
        
        batch.begin();
        track.drawObjedts(batch);
        playerVeicle.draw(batch);
        transit.draw(batch);
        font.setColor(Color.BLACK);
        batch.end();
    }
}
