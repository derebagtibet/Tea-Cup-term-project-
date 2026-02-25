package controller;

import decorator.message.BasicMessage;
import decorator.message.HealthWarningDecorator;
import decorator.message.Message;
import model.TeaMakerModel;
import model.state.DoneState;
import persistence.TeaLogRepository;
import strategy.DailyTotal;
import strategy.MonthlyTotal;
import strategy.TotalCupsCalculation;

public class TeaMakerController {

    private final TeaMakerModel model;
    private final TeaLogRepository repo;

    public TeaMakerController() {
        this.repo = new TeaLogRepository();
        this.model = new TeaMakerModel(repo);
    }

    public TeaMakerModel getModel() {
        return model;
    }

    

    public String getTotalMessage(boolean monthly) {
        TotalCupsCalculation strategy =
                monthly ? new MonthlyTotal(repo) : new DailyTotal(repo);

        int total = strategy.calculate();

        Message msg = new BasicMessage("Total cups: " + total);

        if (!monthly && total > 10) {
            msg = new HealthWarningDecorator(msg);
        }

        return msg.getText();
    }
    public int getMonthlyTotal() {
    return new MonthlyTotal(repo).calculate();
}

public int getTodayTotal() {
    return new DailyTotal(repo).calculate();
}

}
