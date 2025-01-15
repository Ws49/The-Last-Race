package io.github.game.stages.Game.Vehicles.Transit;

//COMPOSITE

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import io.github.game.stages.Game.InterfacesGame.TransitParticipant;
import io.github.game.stages.Game.Track.LineRoad;
import io.github.game.stages.Game.Vehicles.Player.PlayerVehicle;


public class Transit implements TransitParticipant{
    ArrayList<TransitParticipant> participants;
    ArrayList<LineRoad> wayTransit;
    private int  segmentLentgh;
    private float meters;
    private PlayerVehicle player;
    
    public Transit(ArrayList<LineRoad> wayTransit, PlayerVehicle player){
        participants = new ArrayList<TransitParticipant>();
        this.wayTransit = wayTransit;
        this.segmentLentgh = 200;
        this.meters = 0f;
        this.player = player;
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
    // informa a els aonde eles devem ir

    public void  updateWay(){
        participants.forEach(participant ->{
            

            int startPosition = (int)participant.getMetersTraveled() /segmentLentgh; 
            int posY = (int)(((wayTransit.get(startPosition % wayTransit.size()).getDrawY() - 480) * -1)+ 200);
            int posX;

            if(participant instanceof TransitVehicles){
                if(((TransitVehicles)participant).isRightRoad()){
                    posX = (int)((wayTransit.get(startPosition % wayTransit.size()).getDrawX() + wayTransit.get(startPosition % wayTransit.size()).getDrawW()) - 320);
                }else{
                    posX = (int)((wayTransit.get(startPosition % wayTransit.size()).getDrawX() - wayTransit.get(startPosition % wayTransit.size()).getDrawW()) - 320);
                }
        
                ((TransitVehicles)participant).nextPoint(posX,posY,wayTransit.get(startPosition % wayTransit.size()).getDrawW());
                ((TransitVehicles)participant).setpostionValid(true);
            }


        });
    }

    public ArrayList<Float> getPositionOpponents(){
        ArrayList<Float> positions = new ArrayList<Float>();
        participants.forEach(participant ->{
            if(participant instanceof Opponent){
                 positions.add(participant.getMetersTraveled());
            }
       });

        return positions;
    }

    

    @Override
    public void update() {   

        participants.forEach(participant->{
            participant.update();
        });

        for (TransitParticipant transitParticipant : participants) {
            if(transitParticipant.getColision().overlaps(player.getHitBox()) && player.getMetersTraveled() > 1000){
                player.setCollision(true);
                break;
            }else{
                player.setCollision(false);
            }
    
        }

        updateWay();
    }

    @Override
    public void draw(SpriteBatch batch) {
        List<TransitParticipant> reversedParticipants = participants.reversed();
        reversedParticipants.forEach(participant->{
                if(participant.isInScreen()){
                    participant.draw(batch);
                }
        });

    }

    @Override
    public float getMetersTraveled() {

       participants.forEach(participants->{
            meters += participants.getMetersTraveled();
       });
       return meters;
    }

    @Override
    public Rectangle getColision() {
        return null;
    }

    @Override
    public boolean isInScreen() {

        for (TransitParticipant transitParticipant : participants) {
            if(transitParticipant.isInScreen()){
                return true;
            }
        }

        return false;
    }
    
}
