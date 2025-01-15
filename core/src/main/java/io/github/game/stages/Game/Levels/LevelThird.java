package io.github.game.stages.Game.Levels;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.stages.AdditionalGame.UIobjects.CitySignsDecorationUI;
import io.github.game.stages.Game.InterfacesGame.TransitParticipant;
import io.github.game.stages.Game.Vehicles.Player.PlayerVehicle;
import io.github.game.stages.Game.Vehicles.Transit.TypesVehicleTransit;
import io.github.game.stages.Game.Vehicles.Transit.FactoryOpponent;


class LevelThird extends Level {
    public LevelThird(Screen context, PlayerVehicle player){
        super(3,context,player);
        textureBackground = AssetsControl.getInstanceAssetsControl().getTexture("race3");
        insertDrawablesUI();
        spawnVehicle();
        transit.addParticipant((TransitParticipant)FactoryOpponent.getOponnent(TypesVehicleTransit.FERRARI, 870));
        transit.addParticipant((TransitParticipant)FactoryOpponent.getOponnent(TypesVehicleTransit.FERRARI, 700));
        transit.addParticipant((TransitParticipant)FactoryOpponent.getOponnent(TypesVehicleTransit.PORSHE, 870));
        transit.addParticipant((TransitParticipant)FactoryOpponent.getOponnent(TypesVehicleTransit.FERRARI, 700));
    }

    public void  insertDrawablesUI(){
        drawablesUI.addDrawable(new CitySignsDecorationUI("Stars", new Vector2(180,175), 0.12f, -5,601, 200, 200));
        drawablesUI.addDrawable(new CitySignsDecorationUI("Stars", new Vector2(180,175), 0.12f, 195,601, 200, 200));
        drawablesUI.addDrawable(new CitySignsDecorationUI("Stars", new Vector2(180,175), 0.12f, 395,601, 200, 200));
        drawablesUI.addDrawable(new CitySignsDecorationUI("Stars", new Vector2(180,175), 0.12f, 595,601, 200, 200));
        drawablesUI.addDrawable(new CitySignsDecorationUI("Stars", new Vector2(180,175), 0.12f, 795,601, 200, 200));
    }

    @Override
    public void draw() {
        batch.begin();
        batch.setColor(Color.PURPLE);
        batch.draw(textureBackground, 0,-0);
        batch.setColor(Color.WHITE);
        batch.end();
        super.draw();
    }

    @Override
    public void setStatusRace(boolean finishedRace) {
       finalGame = finishedRace;
    }
}

