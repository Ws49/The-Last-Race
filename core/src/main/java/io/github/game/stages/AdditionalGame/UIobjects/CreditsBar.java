package io.github.game.stages.AdditionalGame.UIobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

import io.github.game.AssetsControl.AssetsControl;


public class CreditsBar {
    private Texture texturePanelIcon;
    private Texture iconRabelo;
    private Texture iconIce;
    private Texture iconWs;
    private BitmapFont fontName;
    private BitmapFont fontGithub;
    private ButtonUI closeButton;

    private Rectangle hitBox1;
    private Rectangle hitBox2;
    private Rectangle hitBox3;
    private int countScret;

    public CreditsBar(){
        closeButton = new ButtonUI(new ImageButton.ImageButtonStyle(), TypesButtonUI.CLOSE, 860, 625);
        texturePanelIcon = AssetsControl.getInstanceAssetsControl().getTexture("panelSettings");
        fontName = AssetsControl.getInstanceAssetsControl().getFont("Font/Pixel.ttf", 20);
        fontGithub = AssetsControl.getInstanceAssetsControl().getFont("Font/Pixel.ttf", 10);
        iconIce = AssetsControl.getInstanceAssetsControl().getTexture("IconIce");
        iconRabelo = AssetsControl.getInstanceAssetsControl().getTexture("IconSarah");
        iconWs = AssetsControl.getInstanceAssetsControl().getTexture("IconWs");

        hitBox1 = new Rectangle(196,317,150,150);
        hitBox2 = new Rectangle(452,317, 150,150);
        hitBox3 = new Rectangle(692,317, 150,150);

        countScret =0;
        
    }


    public void draw(SpriteBatch batch) {
        batch.draw(texturePanelIcon,170,300,200,200);
        batch.draw(texturePanelIcon,430,300,200,200);
        batch.draw(texturePanelIcon,670,300,200,200);

        fontName.setColor(Color.CYAN);
        fontGithub.setColor(Color.CYAN);

        fontName.draw(batch, "ICE", 250,530);
        fontName.draw(batch, "SARAH", 490,530);
        fontName.draw(batch, "Ws", 750,530);

        batch.draw(iconIce, 196,317,150,150);
        batch.draw(iconRabelo, 452,317,150,150);
        batch.draw(iconWs,692,317,150,150);

        fontGithub.draw(batch, "github.com/icehopeless", 180,290);
        fontGithub.draw(batch, "github.com/LoiraDoTchan", 430,290);
        fontGithub.draw(batch, "github.com/Ws49", 700,290);
    }

    public void updateScret(){
        if(Gdx.input.isTouched()){
            if(hitBox1.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())){
                countScret++;
            }
            if(hitBox2.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())){
                countScret++;
            }
            if(hitBox3.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())){
                countScret++;
            }
        }
    }
    public void update() {
        updateScret();
        closeButton.update();
    }
  
    public int getScretLevel(){
        return countScret;
    }
    public ButtonUI getCloseButton() {
        return closeButton;
    }

}
