package io.github.game.stages.Game.Track;

import java.util.ArrayList;

public class FactoryRoad {
    private static ArrayList<LineRoad> linesRoads;
    private static final float spriteX = -2.5f;

    public static ArrayList<LineRoad> getRoad(int type, int segmentLentgh){
        switch (type) {
            case 1:
                setRoad1(segmentLentgh);
                break;
            case 2:
                setRoad2(segmentLentgh);
                break;
            default:
                setRoad1(segmentLentgh);
                break;
        }
        return linesRoads;
    }
    
    private static void setRoad1(int segmentLentgh){

        linesRoads = new ArrayList<LineRoad>();
        for (int i = 0; i < 5600; i++) {
            LineRoad line = new LineRoad();
            line.setZ((i * segmentLentgh));

            if(i == 5400){
                line.setObjectRoad(new ObjectRoad(TypesObjectsRoad.LINERACE, true));
                line.setSpriteX(spriteX);
            }

            if (i > 300 && i < 1000) {
                line.setCurve(0.5f);
                if (i % 20 == 0) {
                    line.setObjectRoad(new ObjectRoad(TypesObjectsRoad.CURVE2, true));
                    line.setSpriteX(spriteX);
                }
            }

            if (i > 1200 && i < 1850) {
                line.setCurve(-0.7f);
                if (i % 20 == 0) {
                    line.setObjectRoad(new ObjectRoad(TypesObjectsRoad.CURVE, false));
                    line.setSpriteX(spriteX);
                }
            }

            if(i > 2000 & i < 3500){
                if (i % 40 == 0) {
                    line.setObjectRoad(new ObjectRoad(TypesObjectsRoad.TREE, false));
                    line.setSpriteX(spriteX);
                }if (i % 50 == 0) {
                    line.setObjectRoad(new ObjectRoad(TypesObjectsRoad.PLANT, true));
                    line.setSpriteX(spriteX);
                }
            }

            if(i > 4000 && i < 5000){

                if (i % 100 == 0) {
                    line.setObjectRoad(new ObjectRoad(TypesObjectsRoad.OUTDOOR_SEGA, true));
                    line.setSpriteX(spriteX);
                }else if(i % 60 == 0) {
                    line.setObjectRoad(new ObjectRoad(TypesObjectsRoad.BAKERY, false));
                    line.setSpriteX(spriteX);
                }
            }
            linesRoads.add(line);
        }
    }
    
    private static void setRoad2(int segmentLentgh){
        linesRoads = new ArrayList<LineRoad>();
        for (int i = 0; i < 8600; i++) {
            LineRoad line = new LineRoad();
            line.setZ((i * segmentLentgh));
            
            if(i == 8400){
                line.setObjectRoad(new ObjectRoad(TypesObjectsRoad.LINERACE, true));
                line.setSpriteX(spriteX);
            }

            if(i  < 500){
                if(i % 50 == 0){
                    line.setObjectRoad(new ObjectRoad(TypesObjectsRoad.TREE, true));
                    line.setSpriteX(spriteX);
                }
                if( i % 40 == 0){
                    line.setObjectRoad(new ObjectRoad(TypesObjectsRoad.TREE, false));
                    line.setSpriteX(spriteX);
                }
            }
            
            if( i > 250 && i < 400){
                line.setCurve(0.5f);
                if (i % 20 == 0) {
                    line.setObjectRoad(new ObjectRoad(TypesObjectsRoad.CURVE2, true));
                    line.setSpriteX(spriteX);
                }
            }
            
            if(i > 400 &&  i < 1000){
                line.setCurve(-0.5f);
                if (i % 20 == 0) {
                    line.setObjectRoad(new ObjectRoad(TypesObjectsRoad.CURVE, false));
                    line.setSpriteX(spriteX);
                }
            }

            if(i > 2500 && i < 5000){
                if (i % 20 == 0) {
                    line.setObjectRoad(new ObjectRoad(TypesObjectsRoad.ROCK, true));
                    line.setSpriteX(spriteX);
                }
                if (i % 100 == 0) {
                    line.setObjectRoad(new ObjectRoad(TypesObjectsRoad.OUTDOOR_SEGA, false));
                    line.setSpriteX(spriteX);
                }
            }

            
            if(i > 6500 && i < 7400){
                line.setCurve(-0.5f);
                if (i % 20 == 0) {

                    line.setObjectRoad(new ObjectRoad(TypesObjectsRoad.TREE, true));
                    line.setSpriteX(spriteX);
                }
                if (i % 100 == 0) {
                    line.setObjectRoad(new ObjectRoad(TypesObjectsRoad.OUTDOOR_SEGA, false));
                    line.setSpriteX(spriteX);
                }
            }

            if(i > 7600 && i < 8200){
                if(i % 40 == 0) {
                    line.setObjectRoad(new ObjectRoad(TypesObjectsRoad.LAMPPOST, false));
                    line.setSpriteX(spriteX);
                }
            }

            linesRoads.add(line);
        }
    }
}
