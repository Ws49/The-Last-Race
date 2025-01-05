package io.github.game.stages.Game.Vehicles;

import com.badlogic.gdx.graphics.Color;

public enum VisibleVehicle {
    VISIBLE(new Color(Color.rgba4444(255,255,255,1))),
    INVISIBLE(new Color(Color.rgba4444(0,0,0,0)));

    private Color color;

    VisibleVehicle(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }


}
