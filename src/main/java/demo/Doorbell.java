package demo;

public class Doorbell {
    private boolean isRinging;

    public Doorbell() {
        this.isRinging = false;
    }

    public boolean isRinging() {
        return isRinging;
    }

    public void ring() {
        isRinging = true;
        System.out.println("Ding Dong! The doorbell is ringing.");
    }

    public void stopRinging() {
        isRinging = false;
        System.out.println("The doorbell has stopped ringing.");
    }
}
