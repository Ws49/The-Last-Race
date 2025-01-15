package io.github.game.stages.AdditionalGame;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.Screens.GameScreen;
import io.github.game.stages.AdditionalGame.UIobjects.BoxDrawablesUI;
import io.github.game.stages.AdditionalGame.UIobjects.PanelSettings;
import io.github.game.stages.Game.SaveData;
import io.github.game.stages.Game.Levels.TypesLevels;


public class OptionsLevel extends Stage{
    private PanelSettings panel;
    private Texture texturePanelLevel;
    private Texture textureBlockedlevel;
    private boolean unlockedLevels[];
    private Screen contextMainGame;
    private Texture  menuBackgroundTexture;
    private SpriteBatch batch;
    private BoxDrawablesUI drawablesUI;
    private ImageButton race1;
    private ImageButton race2;
    private ImageButton race3;

    public OptionsLevel(Screen context, BoxDrawablesUI drawablesUI){
        contextMainGame = context;
        this.panel = PanelSettings.getPanelSettings();
        texturePanelLevel = AssetsControl.getInstanceAssetsControl().getTexture("panelSettings");
        menuBackgroundTexture = AssetsControl.getInstanceAssetsControl().getTexture("BackgroundMenu");
        textureBlockedlevel = AssetsControl.getInstanceAssetsControl().getTexture("Blocked");
        this.drawablesUI = drawablesUI;
        batch = new SpriteBatch();
        unlockedLevels = SaveData.instance().Load();
        setButtons();
        addActor(race1);
        addActor(race2);
        addActor(race3);
        race1.setPosition(200,290);
        race2.setPosition(450,290);
        race3.setPosition(700,290);
    }

    public void setButtons(){
        ImageButtonStyle race1Style =  new ImageButtonStyle();
        race1Style.up = new TextureRegionDrawable(AssetsControl.getInstanceAssetsControl().getTexture("race1"));
        race1 = new ImageButton(race1Style);
        race1.setSize(140,140);

        ImageButtonStyle race2Style =  new ImageButtonStyle();
        race2Style.up = new TextureRegionDrawable(AssetsControl.getInstanceAssetsControl().getTexture("race2"));
        race2 = new ImageButton(race2Style);
        race2.setSize(140,140);

        ImageButtonStyle race3Style =  new ImageButtonStyle();
        race3Style.up = new TextureRegionDrawable(AssetsControl.getInstanceAssetsControl().getTexture("race3"));
        race3 = new ImageButton(race3Style);
        race3.setSize(140,140);

        race1.addListener(event ->{
            if (event.isHandled()) {
                if(unlockedLevels[0]){
                    ((GameScreen)contextMainGame).changeStage(new Shop(contextMainGame,TypesLevels.LEVELONE));
                }
            }
            return false;
        });

        race2.addListener(event ->{
            if (event.isHandled()) {
                if(unlockedLevels[1]){
                    ((GameScreen)contextMainGame).changeStage(new Shop(contextMainGame,TypesLevels.LEVELTWO));
                }
            }
            return false;
        });

        race3.addListener(event ->{
            if (event.isHandled()) {
                if(unlockedLevels[2]){
                    ((GameScreen)contextMainGame).changeStage(new Shop(contextMainGame,TypesLevels.LEVELTHIRD));
                }
            }
            return false;
        });
    }

    @Override
    public void act(float delta) {
        AssetsControl.getInstanceAssetsControl().update(delta);
        super.act(delta);
        drawablesUI.update();
    }

    public void drawIconLevels(SpriteBatch batch){
    
        if(!unlockedLevels[0]){
            batch.draw(textureBlockedlevel ,170,270,200,200);
        }

        if(!unlockedLevels[1]){
            batch.draw(textureBlockedlevel ,420,270,200,200);
        }

        if(!unlockedLevels[2]){
            batch.draw(textureBlockedlevel ,670,270,200,200);
        }
        

    }

    @Override
    public void draw() {
        batch.begin();
        batch.draw(menuBackgroundTexture, 0, 0, getWidth(), getHeight() + 200);
        drawablesUI.draw(batch);
        panel.draw(batch);
        batch.draw(texturePanelLevel ,170,270,200,200);
        batch.draw(texturePanelLevel ,420,270,200,200);
        batch.draw(texturePanelLevel ,670,270,200,200);
        batch.end();
        
        super.draw();

        batch.begin();
        drawIconLevels(batch);
        batch.end();
        
    }
}