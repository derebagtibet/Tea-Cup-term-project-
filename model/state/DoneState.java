/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.state;

/**
 *
 * @author emirersan
 */
import model.TeaMakerModel;

public class DoneState implements TeaState {
    private final TeaMakerModel model;

    public DoneState(TeaMakerModel model) {
        this.model = model;
        model.getRepo().insertCups(model.getCups());

    }

    @Override
    public String getName() {
        return "DONE";
    }

    @Override
    public void onFilled(int cups) {
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onBoilWater() {
    }

    @Override
    public void onReset() {
        model.setCups(0);
        model.setState(new EmptyState(model));
    }
}
