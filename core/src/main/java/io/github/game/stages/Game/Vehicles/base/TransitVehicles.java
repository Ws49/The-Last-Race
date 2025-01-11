package io.github.game.stages.Game.Vehicles.base;




import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.game.AssetsControl.AssetsControl;
import io.github.game.stages.Game.InterfacesGame.TransitParticipant;
import io.github.game.stages.Game.Vehicles.Types.TypesVehicleTransit;

public abstract class TransitVehicles extends Vehicles implements TransitParticipant{


    private boolean postionValid;
    private boolean oldPositionValid;
    private boolean inScreen;
    private boolean foiUltrapasado;

    public TransitVehicles(TypesVehicleTransit typeVehicle) {
        super(50, 100, typeVehicle.getWidth(), typeVehicle.getHeight());

        setColor(Color.WHITE);

        textureRegions = typeVehicle.getRegionTexture();
        animation = AssetsControl.getInstanceAssetsControl().getAnimation(textureRegions, typeVehicle.getLineFrame(), typeVehicle.getDurationAnimation());
        currentTRegion = AssetsControl.getInstanceAssetsControl().getCurrentRegion(animation);
        lineFrame = typeVehicle.getLineFrame();
        isOneTexutre = true;
    
        postionValid = false;
        oldPositionValid = false;
        inScreen = false;
       
        foiUltrapasado = false;

        setMetersTraveled(0);
    }

    public abstract void upSize();

    public abstract void downSize();

    public void nextPoint(float coordY, float coordX){

        
    
        if(coordY < 290 && coordY > -100){
            
            //verifica se ta proximo
            
            if(oldPositionValid != postionValid){
                if(coordY > 150){
                    width = 40;
                    height = 40;
                    posY = coordY;
                }

                inScreen = true;
            }else if(coordY > -100){
                inScreen = true;
                postionValid = true;
            }


            if(postionValid){ 
                if(coordX > 0){
                    posX = coordX + 30;     
                }else{
                    posX--;
                }

                if(posY < coordY){
                    foiUltrapasado = false;
                    posY = coordY;
                    downSize();
                }else if(posY > coordY && coordY > 0){
                    foiUltrapasado = true;
                    posY--;
                    upSize();
                }
                
            }
        }else if(foiUltrapasado){
            if(posY >= -200){
                posY-=9;
                if(posY < 200){
                    posX-= 9;
                }
              
                upSize();
            }
        }else if(coordY > 680 && !foiUltrapasado){
            if(posY <= 280){
                posY ++;
                downSize();
            }
        }

        if(posY > 280|| posY < -199){
            setInScreen(false);
            setpostionValid(false);
        }


        System.out.println(coordY);
        oldPositionValid = postionValid;
    }

    @Override
    public void update() {
        metersTraveledUp(100);
        
    }
    @Override
    public void draw(SpriteBatch batch){
        super.draw(batch);
    }

    public boolean isInScreen() {
        return inScreen;
    }

    public void setInScreen(boolean inScreen) {
        this.inScreen = inScreen;
    }


    public void setpostionValid(boolean postionValid) {
        this.postionValid = postionValid;
    }

    




}
