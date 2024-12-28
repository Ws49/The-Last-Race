package io.github.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import io.github.stages.FirstLevel;



public class Main extends ApplicationAdapter {
    private FirstLevel menu;
    
    @Override
    public void create() {
        menu = new FirstLevel();
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
