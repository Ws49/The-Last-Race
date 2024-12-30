package io.github.game.stages;


import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.stages.Racing.LineRoad;



public class FirstLevel extends Stage {

    private ShapeRenderer sh;
    private SpriteBatch batch;
    List<LineRoad> lines;
    int segL=200;
    int tam;
    int vel = 0;
    int playerX =0;

    Animation<TextureRegion> animation;
    protected TextureRegion[][] textureRegions;
    protected TextureRegion currentTRegion;

    public FirstLevel() {

        sh = new ShapeRenderer();
        lines = new ArrayList<LineRoad>();
        
        for(int i =0; i < 160000; i++){
            LineRoad line = new LineRoad();
            line.setZ((i *segL));

           if(i>200 && i < 700){
               line.setCurve(-0.5);
            }
        
            line.setY(500);
            lines.add(line);
        }
    
        batch = new SpriteBatch();
        textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Car",new Vector2(87,60));
        animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, 0, 0.01f);
        this.currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);

        tam = lines.size();
    }


    void drawRoads(ShapeRenderer sh){
        int startPos = vel /segL;
        double x=0,dx =0;

        for(int i = startPos; i < startPos + 300; i++){   
            LineRoad line = lines.get(i % tam);
            line.project(playerX-(int)x,1500,vel);
            x+=dx;
            dx +=line.getCurve();
            Color grass = ((i / 2) % 2) == 0 ? new Color(0,0.8f,0,1) : new Color(0,154,0,1);
            Color rumble = ((i / 2) % 2) == 0 ? new Color(255,255,255,1) : new Color(255,0,0,1);
            Color divisor = ((i / 2) % 2) == 0 ? Color.WHITE : Color.BLACK;
            Color road = Color.BLACK;
            
            LineRoad lineAux = null;
            if(i == 0){
                lineAux = line;
            }else{
                lineAux = lines.get((i - 1) % tam);
            }
            
            lineAux.drawQuad(sh, grass, 0, (int) lineAux.getDrawY(), line.getwidth(), 0, (int) line.getDrawY(), line.getwidth());
            lineAux.drawQuad(sh, rumble, (int) lineAux.getDrawX(),(int) lineAux.getDrawY(), (int) (lineAux.getDrawW() * 1.2), (int) line.getDrawX(), (int) line.getDrawY(),(int) (line.getDrawW() * 1.2));
            lineAux.drawQuad(sh, road, (int)lineAux.getDrawX() ,(int)lineAux.getDrawY(),(int)lineAux.getDrawW(),(int)line.getDrawX(),(int)line.getDrawY(),(int)line.getDrawW()); 
            lineAux.drawQuad(sh, divisor, (int)lineAux.getDrawX(),(int)lineAux.getDrawY(),(int)lineAux.getDrawW() / 16,(int)line.getDrawX(),(int)line.getDrawY(),(int)line.getDrawW() / 16); 
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        AssetsControl.getInstanceAssetsControl().update(delta);
        this.currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Car",new Vector2(87,60));
            animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, 0, 0.02f);
            vel+=200;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            if(vel != 0){
                vel-=200;
            }
            
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            textureRegions = AssetsControl.getInstanceAssetsControl().getTextureRegions("Car",new Vector2(90.5f,67));
            animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, 1, 0.1f);
            playerX -=200;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, 2, 0.1f);
            playerX +=200;
        }
    }

    @Override
    public void draw() {
        super.draw();

        sh.begin(ShapeType.Filled);
        drawRoads(sh);
        sh.end();
        
        batch.begin();
        batch.draw(currentTRegion, 400, 100,150,150);
        batch.end();
    }
}
