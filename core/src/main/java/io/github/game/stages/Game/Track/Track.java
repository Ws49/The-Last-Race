package io.github.game.stages.Game.Track;

import java.util.ArrayList;
//import java.util.Random;

import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import io.github.game.stages.Game.Levels.PublisherFinalRace;
import io.github.game.stages.Game.Vehicles.Player.PlayerVehicle;

public class Track {
    private ArrayList<LineRoad> linesRoads;
    int segmentLentgh;
    private int verticeDrawX1;
    private int verticeDrawY1;
    private int verticeDrawW1;

    private int verticeDrawX2;
    private int verticeDrawY2;
    private int verticeDrawW2;

    private PlayerVehicle playerVehicle;
    private PublisherFinalRace publisherFinalRace;

    public Track(PlayerVehicle player, int typeTrack, PublisherFinalRace publisherFinalRace) {
        linesRoads = new ArrayList<LineRoad>();

        this.segmentLentgh = 200;
        this.publisherFinalRace = publisherFinalRace;
        this.playerVehicle = player;
        linesRoads = FactoryRoad.getRoad(typeTrack, segmentLentgh);

        this.verticeDrawW1 = 0;
        this.verticeDrawX1 = 0;
        this.verticeDrawY1 = 0;

        this.verticeDrawW2 = 0;
        this.verticeDrawX2 = 0;
        this.verticeDrawY2 = 0;

    }

    public void drawObjedts(SpriteBatch batch) {
        float metersTraveledPlayer = resetTrack(playerVehicle.getMetersTraveled());
        int startPosition = (int) metersTraveledPlayer / segmentLentgh;
        for (int i = startPosition + 300; i > startPosition; i--) {
            if (linesRoads.get(i % linesRoads.size()).getObjectRoad() != null) {
                linesRoads.get(i % linesRoads.size()).drawSpriteRoad(batch);
            }
        }
    }

    private float resetTrack(float positionPlayer) {
        while (positionPlayer > linesRoads.size() * segmentLentgh) {
            positionPlayer -= linesRoads.size() * segmentLentgh;
        }

        while (positionPlayer < 0) {
            positionPlayer += linesRoads.size() * segmentLentgh;
        }

        return positionPlayer;
    }

    public void drawRoads(ShapeRenderer sh) {

        float metersTraveledPlayer = resetTrack(playerVehicle.getMetersTraveled());
        int startPosition = (int) metersTraveledPlayer / segmentLentgh;
        float x = 0, dx = 0;
        int camH = (int) (1500 + linesRoads.get(startPosition).getY());
        float maxY = 768;

        if(startPosition > linesRoads.size() - 200){
            publisherFinalRace.setFinishedRace(true);
        }
        for (int i = startPosition; i < startPosition + 300; i++) {

            LineRoad line = linesRoads.get(i % linesRoads.size());
            line.project(playerVehicle.getPlayerX() - (int) x, camH,
                    (startPosition * 200) - (i >= linesRoads.size() ? linesRoads.size() * 200 : 0));
            x += dx;
            dx += line.getCurve();

            line.setClip(maxY);

            if (line.getDrawY() >= maxY) {
                continue;
            }

            maxY = line.getDrawY();

            Color grass = ((i / 8) % 2) == 0 ? new Color(0, 0.8f, 0, 1) : Color.GREEN;
            Color rumble = ((i / 8) % 2) == 0 ? Color.GOLD : Color.GOLDENROD;
            Color divisor = ((i / 8) % 2) == 0 ? Color.WHITE : Color.BLACK;
            Color road = Color.BLACK;

            LineRoad lineAux = null;
            if (i == 0) {
                lineAux = line;
            } else {
                lineAux = linesRoads.get((i - 1) % linesRoads.size());
            }

            verticeDrawX1 = (int) line.getDrawX();
            verticeDrawX2 = (int) lineAux.getDrawX();

            verticeDrawY1 = (int) line.getDrawY();
            verticeDrawY2 = (int) lineAux.getDrawY();

            verticeDrawW1 = (int) line.getDrawW();
            verticeDrawW2 = (int) lineAux.getDrawW();
            lineAux.drawQuad(sh, grass, 0, verticeDrawY2, line.getwidth(), 0, verticeDrawY1, line.getwidth());
            lineAux.drawQuad(sh, rumble, verticeDrawX2, verticeDrawY2, (int) (verticeDrawW2 * 1.2), verticeDrawX1,
                    verticeDrawY1, (int) (verticeDrawW1 * 1.2));
            lineAux.drawQuad(sh, road, verticeDrawX2, verticeDrawY2, (int) verticeDrawW2, verticeDrawX1, verticeDrawY1,
                    verticeDrawW1);
            lineAux.drawQuad(sh, divisor, verticeDrawX2, verticeDrawY2, (int) verticeDrawW2 / 18, verticeDrawX1,
                    verticeDrawY1, verticeDrawW1 / 18);

        }

        playerVehicle.setValueCurve(linesRoads.get(startPosition).getCurve());

    }

    public ArrayList<LineRoad> toWay() {
        return linesRoads;
    }
}
