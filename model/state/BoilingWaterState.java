package model.state;

import javax.swing.Timer;
import model.TeaMakerModel;

public class BoilingWaterState implements TeaState {

    private final TeaMakerModel model;
    private final Timer timer;

    public BoilingWaterState(TeaMakerModel model) {
        this.model = model;

        timer = new Timer(3000, e -> model.setState(new DoneState(model)));
        timer.setRepeats(false);
        timer.start();
    }

    @Override
    public String getName() {
        return "BOILING_WATER";
    }

    @Override
    public void onFilled(int cups) {
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onBoilWater() {
    }

    @Override
    public void onReset() {
        timer.stop();
        model.setCups(0);
        model.setState(new EmptyState(model));
    }
}
