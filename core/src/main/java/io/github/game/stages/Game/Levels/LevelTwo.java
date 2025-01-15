package io.github.game.stages.Game.Levels;


import com.badlogic.gdx.Screen;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.stages.Game.InterfacesGame.TransitParticipant;
import io.github.game.stages.Game.Vehicles.Player.PlayerVehicle;
import io.github.game.stages.Game.Vehicles.Transit.FactoryOpponent;
import io.github.game.stages.Game.Vehicles.Transit.TypesVehicleTransit;

class LevelTwo extends Level {
    public LevelTwo(Screen context, PlayerVehicle player){ 
        super(2,context,player);
        textureBackground = AssetsControl.getInstanceAssetsControl().getTexture("race2");
        spawnVehicle();
        transit.addParticipant((TransitParticipant)FactoryOpponent.getOponnent(TypesVehicleTransit.PORSHE, 670));
        transit.addParticipant((TransitParticipant)FactoryOpponent.getOponnent(TypesVehicleTransit.FERRARI, 650));
        transit.addParticipant((TransitParticipant)FactoryOpponent.getOponnent(TypesVehicleTransit.PORSHE, 500));
        transit.addParticipant((TransitParticipant)FactoryOpponent.getOponnent(TypesVehicleTransit.PORSHE, 670));
    }

        @Override
    public void draw() {
        batch.begin();
        batch.draw(textureBackground, 0,260,1424,600);
        batch.end();
        super.draw();
    }
    
    @Override
    public void setStatusRace(boolean finishedRace) {
       finalGame = finishedRace;
    }
}
