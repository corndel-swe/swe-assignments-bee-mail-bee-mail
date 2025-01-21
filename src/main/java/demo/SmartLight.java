package demo;

public class SmartLight extends Device {

    public SmartLight(String location) {
        super(location);
    }

    @Override
    public void action() {
        turnOn();
    }

    public void turnOn() {
        System.out.printf("Light at %s turned on%n", location);
    }
}
