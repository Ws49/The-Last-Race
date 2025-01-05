package io.github.game.stages.AdditionalGame.UIobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

import io.github.game.AssetsControl.AssetsControl;

public class SettingsBar implements DrawableUI {
    private PanelSettings panel;
    private Texture barVolume;
    private Texture iconVolume;
    private Texture iconSfx;
    private ButtonUI controlVolumeMusic;
    private ButtonUI controlVolumeSfx;
    private int oldPosXMouse;
    private Music music;
    private int x,y;

    public SettingsBar(Music music){
        barVolume = AssetsControl.getInstanceAssetsControl().getTexture("BarVolume");
        iconVolume = AssetsControl.getInstanceAssetsControl().getTexture("Sound");
        iconSfx = AssetsControl.getInstanceAssetsControl().getTexture("Sfx");
        controlVolumeMusic = new ButtonUI(new ImageButton.ImageButtonStyle(), TypesButtonUI.VOLUME, 400, 395);
        controlVolumeSfx = new ButtonUI(new ImageButton.ImageButtonStyle(), TypesButtonUI.VOLUME, 330, 285);
        panel = PanelSettings.getPanelSettings();
        oldPosXMouse = 400;
        this.music = music;
        x = 0;
        y = 0;
        controlVolumeMusic.addListener(event -> {
            updateSettings(0);
            return false;
        });

        controlVolumeSfx.addListener(event -> {
            if(event.isHandled())
            {
                updateSettings(1);
            }
            return false;
        });
    }

    public void updateSettings(int typeButton) {
        if (typeButton == 0) {
            if (controlVolumeMusic.getX() >= 240 && controlVolumeMusic.getX() <= 760) {
                if (Gdx.input.getX() > oldPosXMouse) {
                    controlVolumeMusic.setPosition(controlVolumeMusic.getX() + 10, controlVolumeMusic.getY());
                    if(1f > music.getVolume()){
                        music.setVolume(music.getVolume() + 0.02f);
                    }
                    if(245 > controlVolumeMusic.getX()){
                        music.setVolume(0f);
                    }
                } else if (oldPosXMouse > Gdx.input.getX()) {
                    controlVolumeMusic.setPosition(controlVolumeMusic.getX() - 10, controlVolumeMusic.getY());
                    if(music.getVolume() > 0.01){
                        music.setVolume(music.getVolume() - 0.02f);
                    }
                }
            }else if(controlVolumeMusic.getX() < 280){
                controlVolumeMusic.setX(240);
            }else if(controlVolumeMusic.getX() > 760){
                controlVolumeMusic.setX(700);
            }
        } else {
            if(ButtonUI.getVolumeButton() == 1f){
                ButtonUI.setVolumeButton(0f);
                controlVolumeSfx.setX(220);
            }else{
                ButtonUI.setVolumeButton(1f);
                controlVolumeSfx.setX(330);
            }
        }
        
        oldPosXMouse = Gdx.input.getX();
    }

    @Override
    public void update() {
        controlVolumeMusic.update();
        controlVolumeSfx.update();
    }
    @Override
    public void draw(SpriteBatch batch) {
        panel.draw(batch);
        batch.draw(barVolume, 200, 375, 650, 100);
        batch.draw(iconVolume, 170, 395,65,65);
        batch.draw(barVolume, 240, 265, 150, 100);
        batch.draw(iconSfx, 150, 285,85,65);
    }
    @Override
    public void setX(int x) {
        this.x = x;
    }
    @Override
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public int getY() {
       return y;
    }
    @Override
    public int getX() {
       return x;
    }
    public ButtonUI getButtonVolume(){
        return controlVolumeMusic;
    }
    public ButtonUI getButtonSfx(){
        return controlVolumeSfx;
    }

}
