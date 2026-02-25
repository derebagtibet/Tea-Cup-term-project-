/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator.message;

/**
 *
 * @author emirersan
 */
public abstract class MessageDecorator implements Message{
    protected final Message message;

    protected MessageDecorator(Message message) {
        this.message = message;
    }
}
