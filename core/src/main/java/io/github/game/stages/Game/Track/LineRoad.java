package io.github.game.stages.Game.Track;

import com.badlogic.gdx.graphics.Color;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;



class LineRoad {
    private double x,y,z; 
    private double DrawX,DrawY,DrawW; 
    private double scale, curve;
    private final int roadW=2000;
    private double camD=0.84;
    private int width=1600;
    private int height = 768;
   

    public LineRoad(){
        curve=x=y=z=0;

    }


    public void project(int camX, int camY, int camZ){
        scale = camD/(z-camZ);
        DrawX = (1 + scale * (x - camX)) * width / 2;
        DrawY = (1 - scale * (y - camY)) * height / 2;
        DrawW = scale * roadW * width / 2;
    }

    

    public void drawQuad(ShapeRenderer shapeRenderer,Color c,int x1, int y1, int w1, int x2, int y2, int w2){
            ShapeRenderer sh = shapeRenderer;
            sh.setColor(c);
            int [] xPoints = {x1-w1,x2-w2,x2+w2,x1+w1};
            int [] yPoints = {((y1 - 480) * -1) + 200,((y2 - 480) * -1) + 200,((y2 - 480) * -1) + 200,((y1 - 480) * -1) + 200};
            sh.triangle(xPoints[0] - 320,yPoints[0],xPoints[1] - 320,yPoints[1],xPoints[2] - 320,yPoints[2]);
            sh.triangle(xPoints[0] - 320,yPoints[0],xPoints[2] - 320,yPoints[2],xPoints[3] - 320,yPoints[3]);
    }



    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getDrawX() {
        return DrawX;
    }
    public double getDrawY() {
        return DrawY;
    }

    public double getDrawW() {
        return DrawW;
    }


    public double getCurve() {
        return curve;
    }

    public void setCurve(double curve) {
        this.curve = curve;
    }

    public int getwidth() {
        return width;
    }

    public void setwidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
}
