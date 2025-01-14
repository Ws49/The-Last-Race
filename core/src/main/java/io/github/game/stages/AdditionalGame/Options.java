package io.github.game.stages.AdditionalGame;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
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
import io.github.game.stages.AdditionalGame.UIobjects.CreditsBar;
import io.github.game.stages.AdditionalGame.UIobjects.PanelSettings;
import io.github.game.stages.AdditionalGame.UIobjects.TypesButtonUI;
import io.github.game.stages.Game.Levels.LevelOne;

public class Options extends Stage{
    private Texture menuBackgroundTexture;
    private AssetsControl assetsControl;
    private PanelSettings panel;
    private SpriteBatch batch;
    private BoxDrawablesUI drawablesUI;
    private ButtonUI continueButton;
    private ButtonUI shopButton;
    private ButtonUI creditsButton;
    private ButtonUI mainMenuButton;
    private boolean isCredits;
    private CreditsBar creditsBar;
    private Screen contextMainGame;

    public Options(BoxDrawablesUI drawables, Screen contextMainGame){
        panel = PanelSettings.getPanelSettings();
        batch = new SpriteBatch();
        assetsControl = AssetsControl.getInstanceAssetsControl();
        menuBackgroundTexture = assetsControl.getTexture("BackgroundMenu");
        continueButton = new ButtonUI(new ImageButton.ImageButtonStyle(),TypesButtonUI.CONTINUE, 330, 480);
        shopButton = new ButtonUI(new ImageButton.ImageButtonStyle(),TypesButtonUI.SHOP, 330, 360);
        creditsButton = new ButtonUI(new ImageButton.ImageButtonStyle(),TypesButtonUI.CREDITS, 330, 240);
        mainMenuButton = new ButtonUI(new ImageButton.ImageButtonStyle(),TypesButtonUI.MAINMENU, 330, 120);
        creditsBar = new CreditsBar();
        this.contextMainGame = contextMainGame;
        this.drawablesUI = drawables;
        this.isCredits = false;
        this.contextMainGame = contextMainGame;
        setListenerButtons();
    }

    public Options(Screen contextMainGame){
        panel = PanelSettings.getPanelSettings();
        batch = new SpriteBatch();
        assetsControl = AssetsControl.getInstanceAssetsControl();
        menuBackgroundTexture = assetsControl.getTexture("BackgroundMenu");
        continueButton = new ButtonUI(new ImageButton.ImageButtonStyle(),TypesButtonUI.CONTINUE, 330, 480);
        shopButton = new ButtonUI(new ImageButton.ImageButtonStyle(),TypesButtonUI.SHOP, 330, 360);
        creditsButton = new ButtonUI(new ImageButton.ImageButtonStyle(),TypesButtonUI.CREDITS, 330, 240);
        mainMenuButton = new ButtonUI(new ImageButton.ImageButtonStyle(),TypesButtonUI.MAINMENU, 330, 120);
        creditsBar = new CreditsBar();
        drawablesUI = new BoxDrawablesUI();
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity1", new Vector2(30, 25), 0.15f, 810, 405));
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity2", new Vector2(19, 29), 0.1f, 174, 376));
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity3", new Vector2(20, 28), 0.07f, 328, 421, 20, 20));
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity4", new Vector2(100, 31), 0.07f, 301, 507, 70, 20));
        drawablesUI.addDrawable(new CitySignsDecorationUI("ElementyCity5", new Vector2(23, 64), 0.07f, 46, 580, 70, 200));
        this.contextMainGame = contextMainGame;
        this.contextMainGame = contextMainGame;
        this.isCredits = false;
        setListenerButtons();
        
    }
    
    public void setListenerButtons() {
        this.addActor(continueButton);
        this.addActor(shopButton);
        this.addActor(creditsButton);
        this.addActor(mainMenuButton);
        this.addActor(creditsBar.getCloseButton());
        continueButton.addListener(event->{
            if(!isCredits){
                if(event.isHandled()){
                    continueButton.Play();
                    ((GameScreen) contextMainGame).changeStage(new LevelOne(contextMainGame));
                }
               
            }
            return false;
        });
                
        shopButton.addListener(event->{
            if(!isCredits){
                if(event.isHandled()){
                    shopButton.Play();
                    //((GameScreen) mainGame).changeStage(new Shop(mainGame));
                }
            }
            return false;
        });
                
        creditsButton.addListener(event->{
            if(!isCredits){
                if(event.isHandled()){
                    creditsButton.Play();
                    isCredits = true;
                }
            }
            return false;
        });
        
        creditsBar.getCloseButton().addListener(event->{
            if(isCredits){
                if(event.isHandled()){
                    creditsButton.Play();
                    isCredits = false;
                }
            }
            return false;
        });

        mainMenuButton.addListener(event->{
            if(!isCredits){
                if(event.isHandled()){
                    mainMenuButton.Play();
                    ((GameScreen) contextMainGame).changeStage(new Menu(contextMainGame));
                }
            }
            return false;
        });
    }




    public void setColorButtonsOptions(Color c){
        continueButton.setColor(c);
        mainMenuButton.setColor(c);
        shopButton.setColor(c);
        creditsButton.setColor(c);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        assetsControl.update(delta);

        if(!isCredits){
            drawablesUI.update();
            continueButton.update();
            shopButton.update();
            creditsButton.update();
            mainMenuButton.update();
            creditsBar.getCloseButton().setColor(new Color(255, 255, 255, 0f));
        }else{
            setColorButtonsOptions(new Color(255, 255, 255, 0f));
            creditsBar.update();
            if(creditsBar.getScretLevel() >= 3){
                ((GameScreen) contextMainGame).changeStage(new LevelOne(contextMainGame));
            }
        }
    }

    @Override
    public void draw() {
        batch.begin();
        batch.draw(menuBackgroundTexture, 0, 0, getWidth(), getHeight() + 200);
        drawablesUI.draw(batch);
        panel.draw(batch);

        if(isCredits){
            creditsBar.draw(batch);
        }

        batch.end();
        super.draw();
        
    }
    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        super.dispose();
    }


}
