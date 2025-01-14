package io.github.game.stages.Game.Levels;


import com.badlogic.gdx.Screen;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.stages.Game.Vehicles.Opponents.Opponent;
import io.github.game.stages.Game.Vehicles.Types.TypesVehicleTransit;
import io.github.game.stages.Game.Vehicles.base.PlayerVehicle;

public class LevelTwo extends Level {
    public LevelTwo(Screen context){ 
        super(2,context,new PlayerVehicle());
        textureBackground = AssetsControl.getInstanceAssetsControl().getTexture("race2");
        spawnVehicle();
        transit.addParticipant(new Opponent(TypesVehicleTransit.FERRARI,300));
        transit.addParticipant(new Opponent(TypesVehicleTransit.FERRARI,500)); 
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
