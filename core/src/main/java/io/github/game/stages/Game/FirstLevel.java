package io.github.game.stages.Game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.stages.Game.Track.PublisherCurve;
import io.github.game.stages.Game.Track.Track;
import io.github.game.stages.Game.Vehicles.PlayerVehicle;
import io.github.game.stages.Game.Vehicles.TruckVehicle;



public class FirstLevel extends Stage {

    private ShapeRenderer sh;
    private SpriteBatch batch;

    private Track track;
    private PlayerVehicle playerVeicle;
    private TruckVehicle truck;
    private PublisherCurve publisherCurve;

    public FirstLevel() {
        sh = new ShapeRenderer();
        batch = new SpriteBatch();
        playerVeicle = new PlayerVehicle();
        truck = new TruckVehicle();
        publisherCurve = new PublisherCurve();
        publisherCurve.addListener(truck);
        track = new Track(200,publisherCurve);
      
    }


    @Override
    public void act(float delta) {
        super.act(delta);
        playerVeicle.update();
        AssetsControl.getInstanceAssetsControl().update(delta);
        truck.update(playerVeicle.getSpeed(),playerVeicle.getPlayerX());
    }

    @Override
    public void draw() {
        super.draw();

        sh.begin(ShapeType.Filled);
        track.drawRoads(sh,batch, playerVeicle.getSpeed(), playerVeicle.getPlayerX());
        sh.end();
        
        batch.begin();
        playerVeicle.draw(batch);
        truck.draw(batch);
        batch.end();
    }
}
