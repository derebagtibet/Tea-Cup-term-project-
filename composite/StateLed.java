/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package composite;

/**
 *
 * @author emirersan
 */
import javax.swing.JLabel;
public class StateLed implements UiComponent{
     private final String myState;
    private final JLabel label;

    public StateLed(String myState, JLabel label) {
        this.myState = myState;
        this.label = label;
    }

    @Override
    public void setActive(String stateName) {
        if (myState.equals(stateName)) {
            label.setText(myState + " ●");
        } else {
            label.setText(myState + " ○");
        }
    }
}
