package io.github.game.stages.Game.InterfacesGame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public interface TransitParticipant {
    public void update();
    public void draw(SpriteBatch batch);
    public float getMetersTraveled();
    public Rectangle getColision();
}
