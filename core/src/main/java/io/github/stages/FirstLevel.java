package io.github.stages;


import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;


class Line{
    double x,y,z; 
    double X,Y,W; 
    double scale, curve;
    int roadW=2000;
    double camD=0.84;
    int with=1600;
    int height = 768;

    public Line(){
        curve=x=y=z=0;
    }

    void project(int camX, int camY, int camZ){
        scale = camD/(z-camZ);
        X = (1 + scale * (x - camX)) * with / 2;
        Y = (1 - scale * (y - camY)) * height / 2;
        W = scale * roadW * with / 2;
    }
}

public class FirstLevel extends Stage {

    private ShapeRenderer sh;
    private SpriteBatch batch;
    private Texture background;
    
    List<Line> lines;
    int segL=200;
    int tam;
    int with=1600;
    int vel = 0;
    int playerX =0;
    TextureRegion carRegion;
    Animation<TextureRegion> animation;

    public FirstLevel() {
        sh = new ShapeRenderer();
        lines = new ArrayList<Line>();
        for(int i =0; i < 160000; i++){
            Line line = new Line();
            line.z = i * segL;

            if(i>200 && i < 700){
                line.curve = -0.5;
            }
            lines.add(line);
        }
        batch = new SpriteBatch();

        tam = lines.size();
    }

    void drawQuad(ShapeRenderer shapeRenderer, Color c,int x1, int y1, int w1, int x2, int y2, int w2){
            ShapeRenderer sh = shapeRenderer;
            sh.setColor(c);
            int [] xPoints = {x1-w1,x2-w2,x2+w2,x1+w1};
            int [] yPoints = {((y1 - 480) * -1) + 200,((y2 - 480) * -1) + 200,((y2 - 480) * -1) + 200,((y1 - 480) * -1) + 200};
            sh.triangle(xPoints[0] - 460,yPoints[0],xPoints[1] - 460,yPoints[1],xPoints[2] - 460,yPoints[2]);
            sh.triangle(xPoints[0] - 460,yPoints[0],xPoints[2] - 460,yPoints[2],xPoints[3] - 460,yPoints[3]);
        
    }

    void drawValues(ShapeRenderer sh){
        //drawQuad(sh,Color.GREEN, 500,500,200,500,300,100);
        int startPos = vel /segL;
        double x=0,dx =0;
        sh.setColor(Color.BLUE);
        sh.rect(0,200,1500,387);
        for(int i = startPos; i < startPos + 300; i++){
            
            Line line = lines.get(i % tam);
            line.project(playerX-(int)x,1500,vel);
            x+=dx;
            dx +=line.curve;
            Color grass = ((i / 2) % 2) == 0 ? new Color(0,0.8f,0,1) : new Color(0,154,0,1);
            Color rumble = ((i / 2) % 2) == 0 ? new Color(255,255,255,1) : new Color(255,0,0,1);
            Color road = Color.BLACK;
            
            Line lineAux = null;
            if(i == 0){
                lineAux = line;
            }else{
                lineAux = lines.get((i - 1) % tam);
            }

            drawQuad(sh, grass, 0, (int) lineAux.Y, with, 0, (int) line.Y, with);
            drawQuad(sh, rumble, (int) lineAux.X,(int) lineAux.Y, (int) (lineAux.W * 1.2), (int) line.X, (int) line.Y,(int) (line.W * 1.2));
            drawQuad(sh, road, (int)lineAux.X,(int)lineAux.Y,(int)lineAux.W,(int)line.X,(int)line.Y,(int)line.W);
            
        }
    }

    public void show() {
        batch = new SpriteBatch();
        background = new Texture("background.jpg");  
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            vel+=200;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            vel-=200;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            playerX -=200;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            playerX +=200;
        }
    }


    @Override
    public void draw() {
        super.draw();
      
        sh.begin(ShapeType.Filled);
        drawValues(sh);
        
        sh.end();
        
        batch.begin();

        batch.end();
    }
}
