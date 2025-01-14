package io.github.game.stages.Game.Levels;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.stages.AdditionalGame.UIobjects.CitySignsDecorationUI;
import io.github.game.stages.Game.Vehicles.Opponents.Opponent;
import io.github.game.stages.Game.Vehicles.Types.TypesVehicleTransit;
import io.github.game.stages.Game.Vehicles.base.PlayerVehicle;

public class LevelThird extends Level {
    public LevelThird(Screen context){
        super(3,context,new PlayerVehicle());
        textureBackground = AssetsControl.getInstanceAssetsControl().getTexture("race3");
        insertDrawablesUI();
        spawnVehicle();
        transit.addParticipant(new Opponent(TypesVehicleTransit.FERRARI,300));
        transit.addParticipant(new Opponent(TypesVehicleTransit.FERRARI,500));
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

