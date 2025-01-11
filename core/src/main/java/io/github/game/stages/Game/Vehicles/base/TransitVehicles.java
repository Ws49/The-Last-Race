package io.github.game.stages.Game.Vehicles.base;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.game.AssetsControl.AssetsControl;
import io.github.game.stages.Game.InterfacesGame.TransitParticipant;
import io.github.game.stages.Game.Vehicles.Types.TypesVehicleTransit;

public abstract class TransitVehicles extends Vehicles implements TransitParticipant {

    private boolean postionValid;
    private boolean oldPositionValid;
    private boolean inScreen;
    private boolean wasSurpassed;
    private boolean rightRoad;
    private float startWidth;
    private float startHeight;
    private int speed;

    public abstract void upSize();

    public abstract void downSize();

    public TransitVehicles(TypesVehicleTransit typeVehicle) {
        super(0, 100, typeVehicle.getWidth(), typeVehicle.getHeight());

        setColor(Color.WHITE);

        textureRegions = typeVehicle.getRegionTexture();
        animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, typeVehicle.getLineFrame(),
                typeVehicle.getDurationAnimation());
        currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);
        lineFrame = typeVehicle.getLineFrame();
        isOneTexutre = true;

        postionValid = false;
        oldPositionValid = false;
        inScreen = false;

        wasSurpassed = false;
        rightRoad = new Random().nextBoolean();

        if (rightRoad) {
            posX = 450;
        } else {
            posX = 50;
        }
        speed = new Random().nextInt(70, 400);
        startHeight = height;
        startWidth = width;
        setMetersTraveled(0);

    }

    // recebbe a coordenada x e y da pista

    public void nextPoint(float coordX, float coordY) {
        goPoint(coordX, coordY);
        Overtaking(coordX, coordY);
        oldPositionValid = postionValid;
    }

    public void goPoint(float coordX, float coordY) {
        if (coordY < 290 && coordY > -100) {
            // verifica se ta proximo
            if (oldPositionValid != postionValid) {
                if (coordY > 150) {
                    width = 40;
                    height = 40;
                    posY = coordY;
                }

                inScreen = true;
            } else if (coordY > -100) {
                inScreen = true;
                postionValid = true;
            }


            if (postionValid) {
                if (coordX > 0) {
                    if (rightRoad) {
                        if(metersTraveled > 20000 && posY > 250){
                            posX = coordX - 70;
                        }

                        if( wasSurpassed){
                            if(posY < 250 && posY > 220){
                                posX = coordX - 180;
                            }else if(posY < 220 &&posY > 200){
                                posX = coordX - 200;
                            }else if(posY < 200 && posY > 160){
                                //posX = 720;
                            }
                        }

      
                    } else {
                        // posX = coordX + 30;
                        posX = coordX;
                    }

                } else {
                    if (!rightRoad) {
                        posX--;
                    }
                }

                if (posY < coordY) {

                    wasSurpassed = false;
                    posY = coordY;
                    downSize();

                } else if (posY > coordY && coordY > 0) {
                    wasSurpassed = true;
                    posY--;
                    upSize();
                }

            }

        } else if (coordY > 680 && !wasSurpassed) {

            if (posY <= 280) {
                posY++;
                downSize();
            }
        }
    }

    // ultrapassagem dos veiculos do transito em relacao ao player
    public void Overtaking(float coordX, float coordY) {

        if (wasSurpassed && coordY < 100) {

            if (posY >= -200) {
                posY -= 9;

                if (!Gdx.input.isKeyPressed(Input.Keys.LEFT) && !Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                    if (rightRoad) {
                        posX += 9;
                        upSize();
        
                    } else {
                        if (posX < 100) {
                            posX -= 9;
                            upSize();

                        } else {
                            posX += 9;
                            upSize();
                        }
                    }

                } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                    posX += 9;
                } else {
                    posX -= 9;
                }

                upSize();
            }
        }

        if (posY > 280 || posY < -199) {
            setInScreen(false);
            setpostionValid(false);
            width = startWidth;
            height = startHeight;
       
        }

    }

    @Override
    public void update() {
        metersTraveledUp(speed);

    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    public boolean isInScreen() {
        return inScreen;
    }
    public boolean isRightRoad() {
        return rightRoad;
    }


    public void setInScreen(boolean inScreen) {
        this.inScreen = inScreen;
    }

    public void setpostionValid(boolean postionValid) {
        this.postionValid = postionValid;
    }

}
