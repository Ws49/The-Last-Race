package io.github.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import io.github.stages.MenuScreen;
import io.github.stages.FirstLevel;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private MenuScreen menuScreen;
    private FirstLevel firstLevel;
    private Stage currentStage;

    @Override
    public void create() {
        batch = new SpriteBatch();
        menuScreen = new MenuScreen(this); 
        firstLevel = new FirstLevel();
        currentStage = menuScreen;  
        Gdx.input.setInputProcessor(currentStage); 
    }

    @Override
    public void render() {
        currentStage.act(Gdx.graphics.getDeltaTime());  
        currentStage.draw();  
    }

    @Override
    public void resize(int width, int height) {
        if (currentStage != null) {
            currentStage.getViewport().update(width, height, true);  
    }
}

    @Override
    public void dispose() {
        menuScreen.dispose();
        firstLevel.dispose();
        batch.dispose();
    }

    public void changeStage(Stage stage) {
        currentStage = stage;
        Gdx.input.setInputProcessor(currentStage);  
    }
}
