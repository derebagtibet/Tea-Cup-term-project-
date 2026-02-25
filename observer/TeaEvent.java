/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

/**
 *
 * @author emirersan
 */
public class TeaEvent {
    private final TeaEventType type;
    private final String stateName;
    private final int cups;
    private final String message;

    public TeaEvent(TeaEventType type, String stateName, int cups, String message) {
        this.type = type;
        this.stateName = stateName;
        this.cups = cups;
        this.message = message;
    }

    public TeaEventType getType() {
        return type;
    }

    public String getStateName() {
        return stateName;
    }

    public int getCups() {
        return cups;
    }

    public String getMessage() {
        return message;
    }
}
