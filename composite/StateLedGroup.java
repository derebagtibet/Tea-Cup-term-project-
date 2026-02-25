/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package composite;

/**
 *
 * @author emirersan
 */
import java.util.ArrayList;
import java.util.List;
public class StateLedGroup implements UiComponent{
    private final List<UiComponent> children = new ArrayList<>();

    public void add(UiComponent c) {
        children.add(c);
    }

    @Override
    public void setActive(String stateName) {
        for (UiComponent c : children) {
            c.setActive(stateName);
        }
    }
}
