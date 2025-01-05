package io.github.game.stages.AdditionalGame.UIobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.TimeUtils;

import io.github.game.AssetsControl.AssetsControl;

public class ButtonUI extends ImageButton {
    private long updateTransparecny;
    private float transparency;
    private boolean upTransparecny;
    private Rectangle hitBox;
    private TypesButtonUI typesButtonUI;
    private Sound sound;
    private static float volumeButton = 1f;

    public ButtonUI(ImageButtonStyle styleButton, TypesButtonUI type, int x,int y){
        super(styleButton);
        typesButtonUI = type;
        styleButton.up = new TextureRegionDrawable(typesButtonUI.getTextureButton());
        setPosition(x, y);
        setSize(typesButtonUI.getWidth(), typesButtonUI.getHeight());
        hitBox = new Rectangle(x + 20, y + 5, getWidth() - 45, getHeight() - 20);
        sound = AssetsControl.getInstanceAssetsControl().getSound("Sound1");
    }

    public boolean verfyCollisionButton() {
        if (hitBox.contains(Gdx.input.getX(), (((Gdx.input.getY()) - Gdx.graphics.getHeight()) * -1))) {
            return true;
            
        } else {
            return false;
        }
    }
    
    public void update() {
        if (TimeUtils.millis() - updateTransparecny > 60) {
            if (upTransparecny) {
                transparency += 0.2;
                if (transparency > 1) {
                    upTransparecny = false;
                }
            } else {
                transparency -= 0.2;
                if (transparency < 0) {
                    upTransparecny = true;
                }
            }

            updateTransparecny = TimeUtils.millis();
        }
        if(typesButtonUI != TypesButtonUI.VOLUME){
                    if (verfyCollisionButton()) {
            setColor(255, 255, 255, transparency);
        }else{
            setColor(Color.WHITE);
        }
        }else{
            setColor(Color.WHITE);
        }
    }

    @Override
    public boolean addListener(EventListener listener) {
        return super.addListener(listener);
    }

    public void Play() {
        sound.play(volumeButton);
    }
    public static float getVolumeButton() {
        return volumeButton;
    }

    public static void setVolumeButton(float volumeButton) {
        ButtonUI.volumeButton = volumeButton;
    }

    @Override
    public void setX(float x) {
        this.hitBox.setX(x);
        super.setX(x+ 20);
    }
    @Override
    public void setY(float y) {
        this.hitBox.setY(y);
        super.setY(y+5);
    }
}
