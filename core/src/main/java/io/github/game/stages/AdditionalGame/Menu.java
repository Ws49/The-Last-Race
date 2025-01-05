package io.github.game.stages.AdditionalGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.Screens.GameScreen;
import io.github.game.stages.AdditionalGame.UIobjects.BoxDrawablesUI;
import io.github.game.stages.AdditionalGame.UIobjects.ButtonUI;
import io.github.game.stages.AdditionalGame.UIobjects.CitySignsDecorationUI;
import io.github.game.stages.AdditionalGame.UIobjects.SettingsBar;
import io.github.game.stages.AdditionalGame.UIobjects.TypesButtonUI;

public class Menu extends Stage {

    private SpriteBatch batch;
    private Texture MenuBackgroundTexture;
    private AssetsControl assetsControl;
    private Texture titleGame;
    private ButtonUI playButton;
    private ButtonUI quitButton;
    private BoxDrawablesUI drawablesUI;
    private ButtonUI settingsButton;
    private ButtonUI closeButton;
    private boolean isSettings;
    private Screen contextMainGame;
    private Music music;
    private SettingsBar settingsBar;

    public Menu(Screen contextMainGame) {
        batch = new SpriteBatch();
        assetsControl = AssetsControl.getInstanceAssetsControl();
        MenuBackgroundTexture = assetsControl.getTexture("BackgroundMenu");
        playButton = new ButtonUI(new ImageButton.ImageButtonStyle(), TypesButtonUI.PLAY, 200, 50);
        quitButton = new ButtonUI(new ImageButton.ImageButtonStyle(), TypesButtonUI.QUIT, 500, 50);
        settingsButton = new ButtonUI(new ImageButton.ImageButtonStyle(), TypesButtonUI.SETTING, 920, 620);
        closeButton = new ButtonUI(new ImageButton.ImageButtonStyle(), TypesButtonUI.CLOSE, 860, 625);
        music = assetsControl.getMusic("Music1");
        settingsBar = new SettingsBar(music);
        titleGame = assetsControl.getTexture("Title");

        drawablesUI = new BoxDrawablesUI();
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity1", new Vector2(30, 25), 0.15f, 810, 405));
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity2", new Vector2(19, 29), 0.1f, 174, 376));
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity3", new Vector2(20, 28), 0.07f, 328, 421, 20, 20));
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity4", new Vector2(100, 31), 0.07f, 301, 507, 70, 20));
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity5", new Vector2(23, 64), 0.07f, 46, 580, 70, 200));

        isSettings = false;

  
        this.contextMainGame = contextMainGame;
        this.addActor(playButton);
        this.addActor(quitButton);
        this.addActor(settingsButton);
        this.addActor(closeButton);
        this.addActor(settingsBar.getButtonVolume());
        this.addActor(settingsBar.getButtonSfx());

        if(!music.isPlaying()){
            music.play();
            music.setLooping(true); 
        }

        setListenerButtons();
    }

    public void setListenerButtons() {
        playButton.addListener(event -> {
            if (event.isHandled()) {
                if (!isSettings) {
                    playButton.Play();
                    ((GameScreen) contextMainGame).changeStage(new Options(drawablesUI,contextMainGame));
                    dispose();
                }
            }
            return false;
        });

        quitButton.addListener(event -> {
            if (event.isHandled()) {
                if (!isSettings) {
                    playButton.Play();
                    Gdx.app.exit();
                }
            }
            return false;
        });

        settingsButton.addListener(event -> {
            if (event.isHandled()) {
                if (!isSettings) {
                    playButton.Play();
                    isSettings = true;
                }
            }
            return false;
        });

        closeButton.addListener(event -> {
            if (event.isHandled()) {
                if (isSettings) {
                    playButton.Play();
                    isSettings = false;
                }
            }
            return false;
        });

    }


    @Override
    public void act(float delta) {
        super.act(delta);
        if (!isSettings) {
            playButton.update();
            quitButton.update();
            settingsButton.update();
            closeButton.setColor(255, 255, 255, 0f);
            settingsBar.getButtonVolume().setColor(255, 255, 255, 0f);
            settingsBar.getButtonSfx().setColor(255, 255, 255, 0f);
        } else {
            closeButton.update();
            settingsBar.update();
            playButton.setColor(255, 255, 255, 0f);
            quitButton.setColor(255, 255, 255, 0f);
            settingsButton.setColor(255, 255, 255, 0f);
        }

        assetsControl.update(delta);
    }

    @Override
    public void draw() {
        batch.begin();
        batch.draw(MenuBackgroundTexture, 0, 0, getWidth(), getHeight() + 200);
        batch.draw(titleGame, 150, 400, 700, 250);
        drawablesUI.draw(batch);

        if (isSettings) {
           settingsBar.draw(batch);
        }

        batch.end();
        super.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }
}
