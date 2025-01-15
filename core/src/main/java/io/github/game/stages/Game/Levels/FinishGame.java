package io.github.game.stages.Game.Levels;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

import io.github.game.AssetsControl.AssetsControl;
import io.github.game.stages.AdditionalGame.UIobjects.ButtonUI;
import io.github.game.stages.AdditionalGame.UIobjects.PanelSettings;
import io.github.game.stages.AdditionalGame.UIobjects.TypesButtonUI;


public class FinishGame {
    private PanelSettings panel;
    private ButtonUI mainMenuButton;
    private BitmapFont font;

    public FinishGame() {
        panel = PanelSettings.getPanelSettings();
        mainMenuButton = new ButtonUI(new ImageButton.ImageButtonStyle(), TypesButtonUI.MAINMENU, 330, 200);
        font = AssetsControl.getInstanceAssetsControl().getFont("Font/Pixel.ttf", 100);
    }

    public void draw(SpriteBatch batch, boolean win) {
        panel.draw(batch);
        font.setColor(Color.CYAN);
        if(win){
            font.draw(batch, "YOU WIN", 193, 600);
        }else{
            font.draw(batch, "YOU LOSE", 165, 600);
        }
    }

    public ButtonUI getMainMenuButton() {
        return mainMenuButton;
    }


}
