/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator.message;

/**
 *
 * @author emirersan
 */
public class BasicMessage implements Message {
    private final String text;

    public BasicMessage(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
    
    
}
