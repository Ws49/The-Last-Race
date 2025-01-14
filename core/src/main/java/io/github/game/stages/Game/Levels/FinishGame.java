package io.github.game.stages.Game.Levels;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

import io.github.game.stages.AdditionalGame.UIobjects.ButtonUI;
import io.github.game.stages.AdditionalGame.UIobjects.PanelSettings;
import io.github.game.stages.AdditionalGame.UIobjects.TypesButtonUI;

public class FinishGame {
   private  PanelSettings panel;
   private ButtonUI mainMenuButton;
    private  ButtonUI quitButton;

    public FinishGame(){
        panel = PanelSettings.getPanelSettings();
        mainMenuButton = new ButtonUI(new ImageButton.ImageButtonStyle(), TypesButtonUI.MAINMENU, 260, 120);
        quitButton = new ButtonUI(new ImageButton.ImageButtonStyle(), TypesButtonUI.QUIT, 400, 120);
    }

    public void draw(SpriteBatch batch){
        panel.draw(batch);
    }
    public ButtonUI getMainMenuButton() {
        return mainMenuButton;
    }
    
    public ButtonUI getQuitButton() {
        return quitButton;
    }
}
