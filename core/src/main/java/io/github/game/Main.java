package io.github.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import io.github.stages.MenuStage;



public class Main extends ApplicationAdapter {
    private MenuStage menu;
    
    @Override
    public void create() {
        menu = new MenuStage();
    }

    @Override
    public void render() {
        menu.draw();
        menu.act();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }
    
    @Override
    public void dispose() {


    }
}
