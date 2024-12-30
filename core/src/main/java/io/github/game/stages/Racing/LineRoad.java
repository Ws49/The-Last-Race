package io.github.game.stages.Racing;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class LineRoad {
    double x,y,z; 
    double DrawX,DrawY,DrawW; 
    double scale, curve;
    int roadW=2000;
    double camD=0.84;
    int width=1600;
    int height = 768;
 
    public LineRoad(){
        curve=x=y=z=0;
    }

    public void project(int camX, int camY, int camZ){
        scale = camD/(z-camZ);
        DrawX = (1 + scale * (x - camX)) * width / 2;
        DrawY = (1 - scale * (y - camY)) * height / 2;
        DrawW = scale * roadW * width / 2;
    }

    

    public void drawQuad(ShapeRenderer shapeRenderer, Color c,int x1, int y1, int w1, int x2, int y2, int w2){
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

    public void setDrawX(double drawX) {
        DrawX = drawX;
    }

    public double getDrawY() {
        return DrawY;
    }

    public void setDrawY(double drawY) {
        DrawY = drawY;
    }

    public double getDrawW() {
        return DrawW;
    }

    public void setDrawW(double drawW) {
        DrawW = drawW;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public double getCurve() {
        return curve;
    }

    public void setCurve(double curve) {
        this.curve = curve;
    }

    public int getRoadW() {
        return roadW;
    }

    public void setRoadW(int roadW) {
        this.roadW = roadW;
    }

    public double getCamD() {
        return camD;
    }

    public void setCamD(double camD) {
        this.camD = camD;
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
