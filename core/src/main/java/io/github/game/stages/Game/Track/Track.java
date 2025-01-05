package io.github.game.stages.Game.Track;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class Track {
    private List<LineRoad> linesRoads;
    int segmentLentgh;
    private int verticeDrawX1;
    private int verticeDrawY1;
    private int verticeDrawW1;

    private int verticeDrawX2;
    private int verticeDrawY2;
    private int verticeDrawW2;

    private float newCurve;
    private PublisherCurve publicsherCurve;
    public Track(int segmentLentgh, PublisherCurve publicsher) {
        linesRoads = new ArrayList<LineRoad>();
       
        this.segmentLentgh = segmentLentgh;

        for(int i =0; i < 1600; i++){
            LineRoad line = new LineRoad();
            line.setZ((i * segmentLentgh));

           if(i>400 && i < 700){
                  line.setCurve(-0.5);
            }
            
            line.setY(500);
            linesRoads.add(line);
        }
    
        this.verticeDrawW1 = 0;
        this.verticeDrawX1 = 0;
        this.verticeDrawY1 = 0;
        this.newCurve = 0;
        this.verticeDrawW2 = 0;
        this.verticeDrawX2 = 0;
        this.verticeDrawY2 = 0;
        this.publicsherCurve = publicsher;
    }

    public void drawRoads(ShapeRenderer sh, SpriteBatch batch,int velPlayer, int playerX){
        int startPosition = velPlayer /segmentLentgh;
        double x=0,dx =0;
        
        for(int i = startPosition; i < startPosition + 300; i++){   
            LineRoad line = linesRoads.get(i % linesRoads.size());
            line.project(playerX-(int)x,1500,velPlayer);
            x+=dx;
            dx +=line.getCurve();
            Color grass = ((i / 2) % 2) == 0 ? new Color(0,0.8f,0,1) : Color.GREEN;
            Color rumble = ((i / 2) % 2) == 0 ? new Color(255,255,255,1) :  Color.RED;
            Color divisor = ((i / 2) % 2) == 0 ? Color.WHITE : Color.BLACK;
            Color road = Color.BLACK;
            
            LineRoad lineAux = null;
            if(i == 0){
                lineAux = line;
            }else{
                lineAux = linesRoads.get((i - 1) % linesRoads.size());
            }
            
            verticeDrawX1 = (int)line.getDrawX();
            verticeDrawX2 = (int)lineAux.getDrawX();

            verticeDrawY1 = (int)line.getDrawY();
            verticeDrawY2 = (int)lineAux.getDrawY();

            verticeDrawW1 = (int)line.getDrawW();
            verticeDrawW2 = (int)lineAux.getDrawW();
            lineAux.drawQuad(sh, grass, 0, verticeDrawY2, line.getwidth(), 0, verticeDrawY1, line.getwidth());
            lineAux.drawQuad(sh, rumble, verticeDrawX2,verticeDrawY2, (int)(verticeDrawW2 * 1.2), verticeDrawX1, verticeDrawY1,(int)(verticeDrawW1 * 1.2));
            lineAux.drawQuad(sh, road, verticeDrawX2 ,verticeDrawY2,(int)verticeDrawW2,verticeDrawX1,verticeDrawY1,verticeDrawW1); 
            lineAux.drawQuad(sh, divisor, verticeDrawX2,verticeDrawY2,(int)verticeDrawW2 / 16,verticeDrawX1,verticeDrawY1,verticeDrawW1 / 16); 
            

        }

        if(linesRoads.get(startPosition).getCurve() != newCurve ){
            publicsherCurve.setCurve((float)linesRoads.get(startPosition).getCurve());
            newCurve = (float)linesRoads.get(startPosition).getCurve();
        }


    }



}
