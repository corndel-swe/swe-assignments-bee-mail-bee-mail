package demo;

public abstract class Device {
    protected String location;
    protected Mediator mediator;

    public Device(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void action();
}
