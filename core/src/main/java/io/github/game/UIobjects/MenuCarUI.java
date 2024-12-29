package io.github.game.UIobjects;
import io.github.game.UIobjects.DrawableUI;
import io.github.game.UIobjects.UIobject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class MenuCarUI extends UIobject implements DrawableUI {
    int width;
    int height;
    public MenuCarUI(){
        super("MenuCar", new Vector2(400,300));
        this.width = 100;
        this.height = 100;
    }

    @Override
    public void draw(SpriteBatch batch){
        batch.draw(currentTRegion, x, y,width,height);
    }
    @Override
    public void update(){
        
    }
    @Override
    public void setX(int x){
        this.x = x;
    }
    @Override
    public void setY(int y){
        this.y = y;
    }
    @Override
    public int getY(){
        return y;
    }
    @Override
    public int getX(){
        return x;
    }
    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }
}

