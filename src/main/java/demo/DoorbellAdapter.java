package demo;

import java.util.Timer;
import java.util.TimerTask;

public class DoorbellAdapter extends Device {

    private final Doorbell doorbell;

    public DoorbellAdapter(String location) {
        super(location);
        doorbell = new Doorbell();
    }

    public void ring() {
        mediator.detect(this);
    }

    public boolean isRinging() {
        return doorbell.isRinging();
    }

    @Override
    public void action() {
        doorbell.ring();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                doorbell.stopRinging();
            }
        }, 5000);

    }
}
