/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.state.TeaState;
import model.state.EmptyState;
import persistence.TeaLogRepository;
import java.util.ArrayList;
import java.util.List;
import observer.TeaEvent;
import observer.TeaEventType;
import observer.TeaListener;

public class TeaMakerModel {

    private TeaState currentState;
    private int cups;
    private final TeaLogRepository repo;
private final List<TeaListener> listeners = new ArrayList<>();

    public TeaMakerModel(TeaLogRepository repo) {
        this.repo = repo;
        this.currentState = new EmptyState(this);
        this.cups = 0;
    }

    public TeaLogRepository getRepo() {
        return repo;
    }

    public void setState(TeaState state) {
    this.currentState = state;
    fire(new TeaEvent(TeaEventType.STATE_CHANGED, getStateName(), cups, null));
}


    public TeaState getState() {
        return currentState;
    }

    public String getStateName() {
        return currentState.getName();
    }

   public void setCups(int cups) {
    this.cups = cups;
    fire(new TeaEvent(TeaEventType.CUPS_CHANGED, getStateName(), cups, null));
}


    public int getCups() {
        return cups;
    }

    public void filled(int cups) {
        currentState.onFilled(cups);
    }

    public void start() {
        currentState.onStart();
    }

    public void boilWater() {
        currentState.onBoilWater();
    }

    public void reset() {
        currentState.onReset();
    }
    public void addListener(TeaListener l) {
    listeners.add(l);
}

private void fire(TeaEvent e) {
    for (TeaListener l : listeners) {
        l.onTeaEvent(e);
    }
}

}
