package io.github.game.stages.Game.Levels;


import java.util.Random;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.Screens.GameScreen;
import io.github.game.stages.AdditionalGame.Options;
import io.github.game.stages.AdditionalGame.UIobjects.BoxDrawablesUI;
import io.github.game.stages.Game.SaveData;
import io.github.game.stages.Game.InterfacesGame.ListennerFinalRace;
import io.github.game.stages.Game.Track.Track;
import io.github.game.stages.Game.Vehicles.Player.PlayerVehicle;
import io.github.game.stages.Game.Vehicles.Transit.FactoryVehiclesTransit;
import io.github.game.stages.Game.Vehicles.Transit.Transit;
import io.github.game.stages.Game.Vehicles.Transit.TypesVehicleTransit;





abstract class Level extends Stage implements ListennerFinalRace {

    private ShapeRenderer sh;
    protected SpriteBatch batch;
    private Track track;
    protected PlayerVehicle playerVeicle;
    protected Transit transit; 
    private long lastVehicleTime;
    protected Texture textureBackground;
    protected BoxDrawablesUI drawablesUI;
    protected boolean finalGame;
    protected PublisherFinalRace publisherFinalRace;
    private FinishGame finishGameView;
    private Screen contextMainGame;
    private int typelevel;

    public Level(int typeLevel,Screen context, PlayerVehicle player) {
        sh = new ShapeRenderer();
        batch = new SpriteBatch();
        this.playerVeicle = player;
        contextMainGame = context;
        publisherFinalRace = new PublisherFinalRace();
        publisherFinalRace.addListener(this);
        track = new Track(playerVeicle,typeLevel,publisherFinalRace);
        transit = new Transit(track.toWay(),playerVeicle); 
        playerVeicle.setMetersTraveled(0);
        player.setAccelerate(0);
        drawablesUI = new BoxDrawablesUI();

        finalGame = false;
        finishGameView = new FinishGame();
        this.typelevel = typeLevel;
        
        spawnVehicle();
        setListenerButtons();
    }

    public void setListenerButtons() {
        finishGameView.getMainMenuButton().addListener(event ->{
            if (event.isHandled()) {
                finishGameView.getMainMenuButton().Play();
                ((GameScreen)contextMainGame).changeStage(new Options(contextMainGame));
            }
            return false;
        });

        addActor(finishGameView.getMainMenuButton());
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
        if(!finalGame){
            playerVeicle.update();
            playerVeicle.updatePosition(transit.getPositionOpponents());
            transit.update();
            if (TimeUtils.millis() - lastVehicleTime > 3000) {
                spawnVehicle();
                lastVehicleTime = TimeUtils.millis();
            }
        }else{
            SaveData.instance().Save(typelevel, playerVeicle.getPosition());
        }

        drawablesUI.update();

    }

    @Override
    public void draw() {
        batch.begin();
        if(drawablesUI.size() > 0){
            drawablesUI.draw(batch);
        }
        batch.end();

        sh.begin(ShapeType.Filled);
        track.drawRoads(sh);
        sh.end();
        
        batch.begin();
        playerVeicle.draw(batch);
        track.drawObjedts(batch);
        
        transit.draw(batch);
        
        playerVeicle.draw(batch);

        if(finalGame){
            if(playerVeicle.getPosition() == 1){
                finishGameView.draw(batch,true);  
            }else{
                finishGameView.draw(batch,false);
            }
            
        }
        batch.end();

        if(finalGame){
            super.draw();
        }

    }
}
