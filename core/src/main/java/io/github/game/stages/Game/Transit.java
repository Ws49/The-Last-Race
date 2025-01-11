package io.github.game.stages.Game;

//COMPOSITE

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import io.github.game.stages.Game.InterfacesGame.TransitParticipant;
import io.github.game.stages.Game.Track.LineRoad;
import io.github.game.stages.Game.Vehicles.base.PlayerVehicle;
import io.github.game.stages.Game.Vehicles.base.TransitVehicles;

public class Transit implements TransitParticipant{
    ArrayList<TransitParticipant> participants;
    ArrayList<LineRoad> wayTransit;
    private int  segmentLentgh;
    private float meters;
    private PlayerVehicle player;
    
    public Transit(ArrayList<LineRoad> wayTransit, int segmentLentgh, PlayerVehicle player){
        participants = new ArrayList<TransitParticipant>();
        this.wayTransit = wayTransit;
        this.segmentLentgh = segmentLentgh;
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
            if(participant instanceof TransitVehicles){

                int startPosition = (int)((TransitVehicles)participant).getMetersTraveled() /segmentLentgh; 
                    int posY = (int)(((wayTransit.get(startPosition % wayTransit.size()).getDrawY() - 480) * -1)+ 200);
                    int posX;

                    if(((TransitVehicles)participant).isRightRoad()){
                        posX = (int)((wayTransit.get(startPosition % wayTransit.size()).getDrawX() + wayTransit.get(startPosition % wayTransit.size()).getDrawW()) - 320);
                    }else{
                        posX = (int)((wayTransit.get(startPosition % wayTransit.size()).getDrawX() - wayTransit.get(startPosition % wayTransit.size()).getDrawW()) - 320);
                    }
        
                    ((TransitVehicles)participant).nextPoint(posX,posY);
                    ((TransitVehicles)participant).setpostionValid(true);

            }

        });
    }

    @Override
    public void update() {   
        participants.forEach(participant->{
            participant.update();
        });

        for (TransitParticipant transitParticipant : participants) {
            if(transitParticipant.getColision().overlaps(player.getHitBox())){
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
            if(participant instanceof TransitVehicles){
                if(((TransitVehicles)participant).isInScreen()){
                    participant.draw(batch);
                }
            }else{
                participant.draw(batch);
            }
        });

       // ShapeRenderer sh = new ShapeRenderer();
       // sh.begin(ShapeType.Filled);
      //  reversedParticipants.forEach(participant->{
      //    sh.rect(((TransitVehicles)participant).getHitBox().x,((TransitVehicles)participant).getHitBox().y,((TransitVehicles)participant).getHitBox().width,((TransitVehicles)participant).getHitBox().height);
       // });
        //sh.end();
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
    


}
