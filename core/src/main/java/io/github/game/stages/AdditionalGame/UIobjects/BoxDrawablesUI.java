package io.github.game.stages.AdditionalGame.UIobjects;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//COMPOSITE
public class BoxDrawablesUI implements DrawableUI{
    ArrayList<DrawableUI> drawables;
    int x, y;

    public BoxDrawablesUI(){
         drawables = new ArrayList<DrawableUI>();
         x=0;
         y=0;
    }

    public void addDrawable(DrawableUI drawable){
        drawables.add(drawable);
    }

    public void removeDrawable(DrawableUI drawable){
        drawables.remove(drawable);
    }
    @Override
    public void draw(SpriteBatch batch) {
        drawables.forEach((drawable)->{
            if(drawable instanceof BuildingUI){
                drawable.draw(batch);
            }
        });
        drawables.forEach((drawable)->{
            if(drawable instanceof RoadUI){
                drawable.draw(batch);
            }
        });
        drawables.forEach((drawable)->{
            if(drawable instanceof CitySignsDecorationUI){
                drawable.draw(batch);
            }
        });
        drawables.getFirst().draw(batch);
    }

    @Override
    public void update() {
        drawables.forEach((drawable)->{drawable.update();});
    
        
        Iterator<DrawableUI> iter = drawables.iterator();
        while (iter.hasNext()) {
            DrawableUI drawableUI = iter.next();
            if(drawableUI instanceof BuildingUI || drawableUI instanceof RoadUI ){
                if(drawableUI.getX() > 1024){
                    iter.remove();
                }
            }
        }
    }

    @Override
    public void setX(int x) {
        drawables.forEach((drawable)->{
            if(!(drawable instanceof BuildingUI)){
                drawable.setX(x);
            } 
        });
    }

    @Override
    public void setY(int y) {
        drawables.forEach((drawable)->{
            if(!(drawable instanceof BuildingUI)){
            drawable.setY(y);
            }
        });
    }

    @Override
    public int getY() {
       return y;
    }

    @Override
    public int getX() {
        return x;
    }

    public int size(){
        return drawables.size();
    }

}
