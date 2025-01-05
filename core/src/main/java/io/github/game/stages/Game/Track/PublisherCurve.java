package io.github.game.stages.Game.Track;

import java.util.ArrayList;

import io.github.game.stages.Game.Vehicles.ListenerCurve;

public class PublisherCurve {
    private ArrayList<ListenerCurve> listeners;
    private float curve;

    public PublisherCurve(){
        listeners = new ArrayList<ListenerCurve>();
        curve = 0f;
    }

    public void addListener(ListenerCurve listener){
        listeners.add(listener);
    }

    public void removeListener(ListenerCurve listener){
        listeners.remove(listener);
    }

    
    public void updateCurve(){
        listeners.forEach(listener ->{
            listener.setCurve(curve);
        });
    }

    public void setCurve(float curve){
        this.curve  = curve;
        updateCurve();
    }

}
