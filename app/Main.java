/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author emirersan
 */
import controller.TeaMakerController;
import view.TeaMakerView;
import javax.swing.JOptionPane;

public class Main {
     public static void main(String[] args) {

        TeaMakerController controller = new TeaMakerController();
        TeaMakerView view = new TeaMakerView();
       controller.getModel().addListener(e -> {

    if (e.getType() == observer.TeaEventType.STATE_CHANGED) {
        String s = e.getStateName();

        view.setStateText(s);
        view.setActiveLed(s);

        if ("EMPTY".equals(s)) {
            view.appendMessage("Machine is empty. Please fill cups.");
        } else if ("IDLE".equals(s)) {
            view.appendMessage("Ready. Press START or BOIL WATER.");
        } else if ("MAKING_TEA".equals(s)) {
            view.appendMessage("Brewing tea... Please wait.");
        } else if ("BOILING_WATER".equals(s)) {
            view.appendMessage("Boiling water... Please wait.");
        } else if ("DONE".equals(s)) {
            view.appendMessage("Tea is ready! Saved to database.");
        } else {
            view.appendMessage("State: " + s);
        }
    }

});



        view.getFilledButton().addActionListener(e -> {
            try {
                int cups = Integer.parseInt(view.getCupsText().trim());
                controller.getModel().filled(cups);
                view.setStateText(controller.getModel().getStateName());
                view.appendMessage("Filled: " + cups + " cups");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Cups must be a number");
            }
        });

        view.getStartButton().addActionListener(e -> {
            controller.getModel().start();
            view.setStateText(controller.getModel().getStateName());
            view.appendMessage("Start pressed");
        });

        view.getBoilButton().addActionListener(e -> {
            controller.getModel().boilWater();
            view.setStateText(controller.getModel().getStateName());
            view.appendMessage("Boil water pressed");
        });

        view.getResetButton().addActionListener(e -> {
    controller.getModel().reset();
    view.appendMessage("Reset completed.");
});


        view.getTotalMonthlyButton().addActionListener(e -> {
    int total = controller.getMonthlyTotal();
    view.setTotalText(String.valueOf(total));
    view.appendMessage("Monthly total cups: " + total);
});


        view.getTotalDailyButton().addActionListener(e -> {
    int total = controller.getTodayTotal();
    view.setTotalText(String.valueOf(total));
    view.appendMessage(controller.getTotalMessage(false));
});



        view.showView();
    }
     

    
}
