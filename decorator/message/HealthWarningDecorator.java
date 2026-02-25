/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator.message;

/**
 *
 * @author emirersan
 */
public class HealthWarningDecorator extends MessageDecorator {
    public HealthWarningDecorator(Message message) {
        super(message);
    }

    @Override
    public String getText() {
        return message.getText() + "  HEALTH WARNING: Daily limit exceeded!";
    }
    
}
