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

public class IdleState implements TeaState {
     private final TeaMakerModel model;

    public IdleState(TeaMakerModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "IDLE";
    }

    @Override
    public void onFilled(int cups) {
    }

    @Override
    public void onStart() {
        model.setState(new MakingTeaState(model));
    }

    @Override
    public void onBoilWater() {
        model.setState(new BoilingWaterState(model));
    }

    @Override
    public void onReset() {
        model.setCups(0);
        model.setState(new EmptyState(model));
    }
    
}
