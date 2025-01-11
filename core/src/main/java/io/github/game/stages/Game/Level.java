package io.github.game.stages.Game;


import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;

import io.github.game.AssetsControl.AssetsControl;

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

    public Level() {
        sh = new ShapeRenderer();
        batch = new SpriteBatch();
        playerVeicle = new PlayerVehicle();
        track = new Track(200,playerVeicle);
        transit = new Transit(track.toWay(),200); 
        font = AssetsControl.getInstanceAssetsControl().getFont("Font/Pixel.ttf", 48);
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
        playerVeicle.update();
        AssetsControl.getInstanceAssetsControl().update(delta);
        transit.update();
    
        if (TimeUtils.millis() - lastVehicleTime > 5000) {
            spawnVehicle();
            lastVehicleTime = TimeUtils.millis();
        }
    }

    @Override
    public void draw() {
        super.draw();
        batch.begin();
        //batch.draw(backgroungRace, backgroundX,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.end();

        sh.begin(ShapeType.Filled);
        track.drawRoads(sh);
        sh.end();
        
        batch.begin();
        //track.drawObjedts(batch,playerVeicle.getMetersTraveled());
        playerVeicle.draw(batch);
        transit.draw(batch);
        font.setColor(Color.BLACK);
        batch.end();
    }
}
