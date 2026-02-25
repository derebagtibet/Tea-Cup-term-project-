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
public class EmptyState implements TeaState{
    private final TeaMakerModel model;

    public EmptyState(TeaMakerModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "EMPTY";
    }

    @Override
    public void onFilled(int cups) {
        model.setCups(cups);
        model.setState(new IdleState(model));
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
