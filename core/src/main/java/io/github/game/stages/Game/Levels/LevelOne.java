package io.github.game.stages.Game.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.stages.AdditionalGame.UIobjects.CitySignsDecorationUI;
import io.github.game.stages.Game.InterfacesGame.TransitParticipant;
import io.github.game.stages.Game.Vehicles.Player.PlayerVehicle;
import io.github.game.stages.Game.Vehicles.Transit.FactoryOpponent;
import io.github.game.stages.Game.Vehicles.Transit.TypesVehicleTransit;


class LevelOne extends Level {
    public LevelOne(Screen context, PlayerVehicle player){
        super(1,context,player);
        textureBackground = AssetsControl.getInstanceAssetsControl().getTexture("race1");
        insertDrawablesUI();
        spawnVehicle();
        transit.addParticipant((TransitParticipant)FactoryOpponent.getOponnent(TypesVehicleTransit.FERRARI, 500));
        transit.addParticipant((TransitParticipant)FactoryOpponent.getOponnent(TypesVehicleTransit.PORSHE, 550));
        transit.addParticipant((TransitParticipant)FactoryOpponent.getOponnent(TypesVehicleTransit.FERRARI, 580));
        transit.addParticipant((TransitParticipant)FactoryOpponent.getOponnent(TypesVehicleTransit.PORSHE, 300));
    }

    public void  insertDrawablesUI(){
        drawablesUI.addDrawable(new CitySignsDecorationUI("Stars", new Vector2(180,175), 0.12f, -5,601, 200, 200));
        drawablesUI.addDrawable(new CitySignsDecorationUI("Stars", new Vector2(180,175), 0.12f, 195,601, 200, 200));
        drawablesUI.addDrawable(new CitySignsDecorationUI("Stars", new Vector2(180,175), 0.12f, 395,601, 200, 200));
        drawablesUI.addDrawable(new CitySignsDecorationUI("Stars", new Vector2(180,175), 0.12f, 595,601, 200, 200));
        drawablesUI.addDrawable(new CitySignsDecorationUI("Stars", new Vector2(180,175), 0.12f, 795,601, 200, 200));
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity3", new Vector2(20, 28), 0.07f, 548,342, 20, 20));
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity4", new Vector2(100, 31), 0.07f, 586,473, 50, 20));
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity5", new Vector2(23, 64), 0.07f, 708,378, 20, 100));
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity6", new Vector2(67, 66), 0.4f, 409,545, 60, 80));
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity7", new Vector2(78, 29), 0.1f, 314,438,40,20));
    }

    @Override
    public void draw() {
        batch.begin();
        batch.draw(textureBackground, 0,-20,Gdx.graphics.getWidth() * 2,Gdx.graphics.getHeight() * 2);
        batch.end();
        super.draw();
    }
    @Override
    public void setStatusRace(boolean finishedRace) {
       finalGame = finishedRace;
    }
}
