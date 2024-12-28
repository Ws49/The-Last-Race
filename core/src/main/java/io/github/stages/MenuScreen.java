package io.github.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import io.github.game.Main;

public class MenuScreen extends Stage {

    private SpriteBatch batch;
    private Texture startButtonTexture;
    private ImageButton startButton;
    private Main mainGame;  

    public MenuScreen(Main mainGame) {
        this.mainGame = mainGame;  
        batch = new SpriteBatch();

        startButtonTexture = new Texture("buttom.png");
        
        ImageButton.ImageButtonStyle buttonStyle = new ImageButton.ImageButtonStyle();
        buttonStyle.up = new TextureRegionDrawable(startButtonTexture);

        startButton = new ImageButton(buttonStyle);
        startButton.setPosition(100, 100); 

        this.addActor(startButton);

        startButton.addListener(event -> {
            if (event.isHandled()) {
                mainGame.changeStage(new FirstLevel());
            }
            return false;
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw() {
        super.draw();
        batch.begin();
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        startButtonTexture.dispose();
    }
}
