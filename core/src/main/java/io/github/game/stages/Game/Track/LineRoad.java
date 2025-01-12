package io.github.game.stages.Game.Track;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

class ObjectRoad{
    private Texture textureObject;
    private float width;
    private float height;
    private Rectangle hitBox;
    private boolean side;
    private TypesObjectsRoad type;
    private float scaleDistance;
    private float posX;

    public ObjectRoad(TypesObjectsRoad type, boolean side){
        this.type = type;
        this.textureObject = type.getTexture();
        this.width = type.getWidth();
        this.height = type.getHeight();
        hitBox = new Rectangle();
        this.side = side;
        scaleDistance =0f;
        posX = 0f;
    }

    public void redimensionObject(float DrawX, float DrawW, float DrawY){
        if(side){
            if(type == TypesObjectsRoad.CURVE || type == TypesObjectsRoad.CURVE2){

                scaleDistance  = 1.0f - (DrawY/ 280);
                posX = (DrawX - (DrawW + 320) * scaleDistance) - 370;

            }else{

                scaleDistance  = 1.0f - (DrawY/ 280);
                posX = (DrawX - (DrawW + 320) * scaleDistance) - 400;
                
            }
        }else{
            if(type == TypesObjectsRoad.CURVE ||type == TypesObjectsRoad.CURVE2){

                scaleDistance  = (DrawY/ 280);
                if(((DrawY- 480) * -1)+ 200 > 280){
                    posX = (DrawX - (DrawW * scaleDistance) + 320) - 700;
                }else{
                    posX = (DrawX - (DrawW * scaleDistance) + 320) - 800;
                }

            }else{

                scaleDistance  = (DrawY/ 280);
                if(((DrawY- 480) * -1)+ 200 > 280){
                    posX = (DrawX - (DrawW * scaleDistance) + 320) - 700;
                }else{
                    posX = (DrawX - (DrawW * scaleDistance) + 320) - 800;
                }

            }

        }
    }

    public void draw(SpriteBatch batch, float DrawX, float DrawW, float DrawY){
        int w = textureObject.getWidth();
        int h = textureObject.getHeight();

        float destW = w * DrawW / 266;
        float destH = h * DrawW / 266;

        if(type == TypesObjectsRoad.CURVE || type == TypesObjectsRoad.CURVE2){
            batch.draw(textureObject, posX, (((DrawY- 480) * -1)+ 200),(int)(destW * 0.25 ),(int)(destH * 0.25));
        }else{
            batch.draw(textureObject, posX, (((DrawY- 480) * -1)+ 200),destW + width ,destH + height);
        }
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

}

public class LineRoad {
    private float x,y,z; 
    private float DrawX,DrawY,DrawW; 
    private float scale, curve,spriteX,clip;

    private ObjectRoad objectRoad;
    private final int roadW=4000;
    private float camD=0.84f;
    private int width=1600;
    private int height = 768;
   

    public LineRoad(){
        curve=x=y=z=0;
        spriteX=0;
        objectRoad = null;
    }
    
    void drawSpriteRoad(SpriteBatch batch){
        objectRoad.redimensionObject(DrawX,DrawW,DrawY);
        objectRoad.draw(batch, DrawX, DrawW, DrawY);
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
            sh.triangle(xPoints[0] - 300,yPoints[0],xPoints[1] - 300,yPoints[1],xPoints[2] - 300,yPoints[2]);
            sh.triangle(xPoints[0] - 300,yPoints[0],xPoints[2] - 300,yPoints[2],xPoints[3] - 300,yPoints[3]);
    }

    public ObjectRoad getObjectRoad() {
        return objectRoad;
    }

    public void setObjectRoad(ObjectRoad objectRoad) {
        this.objectRoad = objectRoad;
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
