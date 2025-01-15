package io.github.game.stages.AdditionalGame;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.Screens.GameScreen;
import io.github.game.stages.AdditionalGame.UIobjects.ButtonUI;
import io.github.game.stages.AdditionalGame.UIobjects.PanelSettings;
import io.github.game.stages.AdditionalGame.UIobjects.TypesButtonUI;
import io.github.game.stages.Game.SaveData;
import io.github.game.stages.Game.Levels.FactoryLevel;
import io.github.game.stages.Game.Levels.TypesLevels;
import io.github.game.stages.Game.Vehicles.Player.PlayerVehicle;
import io.github.game.stages.Game.Vehicles.Player.TypesPlayer;

public class Shop extends Stage {
    private PanelSettings panel;

    private ArrayList<TextureRegion> carsTexture;

    private ButtonUI buyButton;
    private ButtonUI leftButton;
    private ButtonUI rightButton;
    private Screen contextMainGame;
    private Texture menuBackgroundTexture;
    private SpriteBatch batch;
    private boolean[] unlockedCars;
    private Texture textureBlockedCar;
    private int indexCar;
    private TypesLevels typeLevel;

    public Shop(Screen context, TypesLevels type) {
        contextMainGame = context;
        this.panel = PanelSettings.getPanelSettings();
        menuBackgroundTexture = AssetsControl.getInstanceAssetsControl().getTexture("BackgroundMenu");
        batch = new SpriteBatch();
        buyButton = new ButtonUI(new ImageButton.ImageButtonStyle(), TypesButtonUI.CONTINUE, 320, 140);
        leftButton = new ButtonUI(new ImageButton.ImageButtonStyle(), TypesButtonUI.LEFT, 100, 300);
        rightButton = new ButtonUI(new ImageButton.ImageButtonStyle(), TypesButtonUI.RIGHT, 750, 300);
        textureBlockedCar = AssetsControl.getInstanceAssetsControl().getTexture("Blocked");
        batch = new SpriteBatch();
        carsTexture = new ArrayList<>();
        indexCar = 0;
        unlockedCars = SaveData.instance().Load();
        this.typeLevel = type;
        setListenerButtons();
        setCars();
    }

    public void setListenerButtons() {
        this.addActor(buyButton);
        this.addActor(leftButton);
        this.addActor(rightButton);

        buyButton.addListener(event -> {
            if (event.isHandled()) {
                buyButton.Play();
                if (unlockedCars[indexCar]) {
                    switch (indexCar) {
                        case 0:
                            ((GameScreen) contextMainGame).changeStage(FactoryLevel.getLevel(typeLevel, contextMainGame,PlayerVehicle.getPlayer(TypesPlayer.LAMBORGHINI)));
                            break;

                        case 1:
                            ((GameScreen) contextMainGame).changeStage(FactoryLevel.getLevel(typeLevel, contextMainGame,PlayerVehicle.getPlayer(TypesPlayer.LAMBORGHINI_RED)));
                            break;

                        case 2:
                            ((GameScreen) contextMainGame).changeStage(FactoryLevel.getLevel(typeLevel, contextMainGame,PlayerVehicle.getPlayer(TypesPlayer.BUGATTI)));
                            break;

                        default:
                            ((GameScreen) contextMainGame).changeStage(FactoryLevel.getLevel(typeLevel, contextMainGame,PlayerVehicle.getPlayer(TypesPlayer.LAMBORGHINI)));
                            break;
                    }
                }

            }

            return false;
        });

        leftButton.addListener(event -> {
            if (event.isHandled()) {
                leftButton.Play();
                if (indexCar > 0) {
                    indexCar--;
                } else {
                    indexCar = 2;
                }
            }

            return false;
        });
        rightButton.addListener(event -> {
            if (event.isHandled()) {
                rightButton.Play();
                if (indexCar < 2) {
                    indexCar++;
                } else {
                    indexCar = 0;
                }
            }

            return false;
        });
    }



    public void setCars() {
        carsTexture.add(AssetsControl.getInstanceAssetsControl().getTextureRegions("Lamborghini", new Vector2(62, 37))[0][0]);
        carsTexture.add(AssetsControl.getInstanceAssetsControl().getTextureRegions("LamborghiniRed",new Vector2(87, 47))[0][0]);
        carsTexture.add(AssetsControl.getInstanceAssetsControl().getTextureRegions("Buggati", new Vector2(70, 41))[0][0]);
    }

    @Override
    public void act(float delta) {
        AssetsControl.getInstanceAssetsControl().update(delta);
        super.act(delta);
        buyButton.update();
        leftButton.update();
        rightButton.update();
    }

    @Override
    public void draw() {
        batch.begin();
        batch.draw(menuBackgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        panel.draw(batch);
        batch.draw(carsTexture.get(indexCar), 340, 280, 350, 170);
        if (!unlockedCars[indexCar]) {
            batch.draw(textureBlockedCar, 370, 280, 300, 300);
        }
        batch.end();
        super.draw();
    }

    @Override
    public void dispose() {
       super.dispose();
    }
}