package io.github.game.stages.Game.Track;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;




class LineRoad {
    private float x,y,z; 
    private float DrawX,DrawY,DrawW; 
    private float scale, curve,spriteX,clip;


    private final int roadW=2000;
    private float camD=0.84f;
    private int width=1600;
    private int height = 768;
   
    private Texture texture;


    public LineRoad(){
        curve=x=y=z=0;
        spriteX=0;
    }

    void drawSpriteRoad(SpriteBatch batch){
        int w = texture.getWidth();
        int h = texture.getHeight();
        float offsetX = DrawX +  scale * spriteX * width/2;
        float offsetY = DrawY +  4;
        float destW = w * DrawW / 266;
        float destH = h * DrawW / 266;

        offsetX += destW * spriteX; //offsetX
        offsetY += destH * (-1); //offsetY

        float clipH = offsetY+destH-clip;
    
        if(clipH < 0){
            clipH =0;
        }
        if(clipH > destH){
            return;
        }
        
        batch.draw(texture, offsetX, offsetY,destW,destH);
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

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
    public float getSpriteX() {
        return spriteX;
    }

    public void setSpriteX(float spriteX) {
        this.spriteX = spriteX;
    }

    public void setClip(float clip){
        this.clip = clip;
    }
    public float getClip(){
        return clip;
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getDrawX() {
        return DrawX;
    }
    public float getDrawY() {
        return DrawY;
    }

    public float getDrawW() {
        return DrawW;
    }


    public float getCurve() {
        return curve;
    }

    public void setCurve(float curve) {
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
