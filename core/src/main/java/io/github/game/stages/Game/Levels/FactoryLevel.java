package io.github.game.stages.Game.Levels;

import com.badlogic.gdx.Screen;

import io.github.game.stages.Game.Vehicles.Player.PlayerVehicle;




public final class FactoryLevel {
    
    public static Level getLevel(TypesLevels type, Screen context, PlayerVehicle player){
        switch (type) {
            case LEVELONE:
                return new LevelOne(context,player);
            case LEVELTWO:
                return new LevelTwo(context,player);
            case LEVELTHIRD:
                return new LevelThird(context,player); 
            default:
                return new LevelOne(context,player);   
        }
    }
}

