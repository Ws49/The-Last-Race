package io.github.game.stages.Game.Levels;

import java.util.ArrayList;

import io.github.game.stages.Game.InterfacesGame.ListennerFinalRace;
//OBSERVER
public class PublisherFinalRace {
    ArrayList<ListennerFinalRace> listenersFinishedRace;
    boolean finishedRace;

    public PublisherFinalRace(){
        listenersFinishedRace = new ArrayList<ListennerFinalRace>();
    }
     public void addListener(ListennerFinalRace listenner){
        listenersFinishedRace.add(listenner);
     };

     public void removeListener(ListennerFinalRace listenner){
        listenersFinishedRace.remove(listenner);
     };

     public void notifyListenners(){
        listenersFinishedRace.forEach(listenner->{
            listenner.setStatusRace(finishedRace);
        });
     };

     public void setFinishedRace(boolean finishedRace){
        this.finishedRace = finishedRace;
        notifyListenners();
     }

}
