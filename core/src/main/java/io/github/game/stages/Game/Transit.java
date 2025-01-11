package io.github.game.stages.Game;

//COMPOSITE

import java.util.ArrayList;
import java.util.List;

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
    
    //Atualiza o caminho dos participantes do trÂnsito (oponentes)
    // informa a els onde eles devem ir
    public void  updateWay(){
        participants.forEach(participant ->{
            if(participant instanceof TransitVehicles){

                int startPosition = (int)((TransitVehicles)participant).getMetersTraveled() /segmentLentgh;
                    
                    int posY = (int)(((wayTransit.get(startPosition % wayTransit.size()).getDrawY() - 480) * -1)+ 200);
                    int posX = (int)((wayTransit.get(startPosition % wayTransit.size()).getDrawX() - wayTransit.get(startPosition % wayTransit.size()).getDrawW()) - 320);
                    ((TransitVehicles)participant).nextPoint(posY,posX);
                    ((TransitVehicles)participant).setpostionValid(true);

            }

        });
    }
    // PSEUDO 3D AHAHAHHAAHAHHAHAHAHA
    @Override
    public void update() {   
       
        participants.forEach(participant->{
            participant.update();
            
        });
        updateWay();
    }

    @Override
    public void draw(SpriteBatch batch) {
        List<TransitParticipant> reversedParticipants = participants.reversed();
        
        reversedParticipants.forEach(participant->{
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
