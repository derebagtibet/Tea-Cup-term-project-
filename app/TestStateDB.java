/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author emirersan
 */
import model.TeaMakerModel;
import model.state.DoneState;
import persistence.TeaLogRepository;

public class TestStateDB {
    public static void main(String[] args) {
        TeaMakerModel model = new TeaMakerModel(new TeaLogRepository());
        model.setCups(4);
        model.setState(new DoneState(model));
        System.out.println("Passing to done and inserted.");
    }
    
}
