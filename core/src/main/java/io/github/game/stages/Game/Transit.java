package io.github.game.stages.Game;

//COMPOSITE

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.github.game.stages.Game.InterfacesGame.TransitParticipant;
import io.github.game.stages.Game.Track.LineRoad;
import io.github.game.stages.Game.Vehicles.base.TransitVehicles;

public class Transit implements TransitParticipant{
    ArrayList<TransitParticipant> participants;
    ArrayList<LineRoad> wayTransit;
    private int  segmentLentgh;
    public Transit(ArrayList<LineRoad> wayTransit, int segmentLentgh){
        participants = new ArrayList<TransitParticipant>();
        this.wayTransit = wayTransit;
        this.segmentLentgh = segmentLentgh;
    }

    public void addParticipant(TransitParticipant participant){
        participants.add(participant);
    }

    public void removeParticipant(TransitParticipant participant){
        participants.remove(participant);
    }

    public int sizeTransit(){
        return participants.size();
    }

    public void  updateWay(){
        participants.forEach(participant ->{
            if(participant instanceof TransitVehicles){
                int startPosition = (int)((TransitVehicles)participant).getMetersTraveled() /segmentLentgh;
                if((int)(((wayTransit.get(startPosition % wayTransit.size()).getDrawY() - 480) * -1)+ 200) < 285 && (int)(((wayTransit.get(startPosition % wayTransit.size()).getDrawY() - 480) * -1)+ 200) > -100){
                    int posY = (int)(((wayTransit.get(startPosition % wayTransit.size()).getDrawY() - 480) * -1)+ 200);
                    int posX = (int)((wayTransit.get(startPosition % wayTransit.size()).getDrawX() - wayTransit.get(startPosition % wayTransit.size()).getDrawW()) - 320);
                    ((TransitVehicles)participant).nextPoint(posY,posX );
                     ((TransitVehicles)participant).setpostionValid(true);
                }else{
                    ((TransitVehicles)participant).setpostionValid(false);
                    ((TransitVehicles)participant).setInScreen(false);
                }
            }

        });
    }

    @Override
    public void update() {   
        participants.forEach(participant->{
            participant.update();
        });
        updateWay();
    }

    @Override
    public void draw(SpriteBatch batch) {
        participants.forEach(participant->{
            if(participant instanceof TransitVehicles){
                if(((TransitVehicles)participant).isInScreen()){
                    participant.draw(batch);
                }
            }else{
                participant.draw(batch);
            }
        });
    }


}
