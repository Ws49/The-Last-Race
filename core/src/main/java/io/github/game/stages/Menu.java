package io.github.game.stages;


import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.Screens.GameScreen;

public class Menu extends Stage {

    private SpriteBatch batch;
    private Texture startButtonTexture;
    private Texture MenuBackgroundTexture;
    private ImageButton startButton;
    private AssetsControl assetsControl;
    private BitmapFont font;
    public Menu(Screen mainGame) {
        
        batch = new SpriteBatch();
        assetsControl = AssetsControl.getInstanceAssetsControl();
        MenuBackgroundTexture = assetsControl.getTexture("MenuBackground");
        startButtonTexture = assetsControl.getTexture("ButtonStart");
        
     
        ImageButton.ImageButtonStyle buttonStyle = new ImageButton.ImageButtonStyle();
        buttonStyle.up = new TextureRegionDrawable(startButtonTexture);
        font = assetsControl.getFont("Font/Pixel.ttf", 12);
        startButton = new ImageButton(buttonStyle);
        startButton.setPosition(100, 100); 

        this.addActor(startButton);
       

        startButton.addListener(event -> {
            if (event.isHandled()) {
                ((GameScreen)mainGame).changeStage(new FirstLevel());
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
        batch.begin();
        batch.draw(MenuBackgroundTexture, 0,0, getWidth(), getHeight());
        font.draw(batch, "OLAAA", 300, 300,1929,1929,true);
        batch.end();
        super.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        MenuBackgroundTexture.dispose();
        startButtonTexture.dispose();
    }
}
