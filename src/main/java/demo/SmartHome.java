package demo;

import java.util.ArrayList;
import java.util.List;

public class SmartHome implements Mediator {
    private List<Device> devices;

    private static SmartHome instance;

    private SmartHome() {
        this.devices = new ArrayList<>();
    }

    public static SmartHome getInstance() {
        if (instance == null) {
            instance = new SmartHome();
        } else {
            System.out.println("Already exists");
        }

        return instance;
    }

    @Override
    public void addDevice(Device device) {
        devices.add(device);
        device.setMediator(this);
    }

    @Override
    public void addDevice(List<Device> devices) {
        this.devices.addAll(devices);
        devices.forEach(device -> device.setMediator(this));
    }

    @Override
    public void detect(Device device) {
        devices.stream()
                .filter(d -> device.getLocation().equals(d.getLocation()))
                .forEach(Device::action);
    }

}
