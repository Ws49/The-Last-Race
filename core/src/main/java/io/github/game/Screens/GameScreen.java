package io.github.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

import io.github.game.stages.Game.FirstLevel;

//STATE
public class GameScreen implements Screen {
    private FirstLevel FirstLevel;
    private Stage currentStage;

    public GameScreen(){
        FirstLevel = new FirstLevel(); 
        currentStage = FirstLevel;  
        Gdx.input.setInputProcessor(currentStage); 
    }



    @Override
    public void resize(int width, int height) {
        if (currentStage != null) {
            currentStage.getViewport().update(width, height, true);  
        }
}


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        currentStage.act(Gdx.graphics.getDeltaTime());  
        currentStage.draw();  
    }

    public void changeStage(Stage stage) {
        currentStage = stage;
        Gdx.input.setInputProcessor(currentStage);  
    }


    @Override
    public void show() {
       
    }



    @Override
    public void pause() {
       
    }



    @Override
    public void resume() {

    }



    @Override
    public void hide() {
        
    }



    @Override
    public void dispose() {
       
    }

 
}
