class SmartHome {
    constructor() {
        this.devices = [];
    }

    addDevice(device) {
        this.devices.push(device);
    }

    motionDetected(location) {
        this.devices
            .filter(device => device.type === 'light')
            .filter(light => light.location === location)
            .forEach(light => light.turnOn());
    }
}

class SmartDevice {
    constructor(location) {
        this.smartHome = null;
        this.type = null;
        this.location = location;
    }

    register(smartHome) {
        smartHome.addDevice(this);
        this.smartHome = smartHome;
    }
}

class SmartCamera extends SmartDevice {
    constructor(location) {
        super(location);
        this.type = 'camera';
    }

    detectMotion() {
        this.smartHome.motionDetected(this.location);
    }
}

class SmartLight extends SmartDevice {
    constructor(location) {
        super(location);
        this.type = 'light';
        this.brightness = 0;
    }

    turnOn() {
        this.brightness = 100;
    }
}