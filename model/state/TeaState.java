/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.state;

/**
 *
 * @author emirersan
 */
public interface TeaState {
    String getName();

    void onFilled(int cups);

    void onStart();

    void onBoilWater();

    void onReset();
    
}
