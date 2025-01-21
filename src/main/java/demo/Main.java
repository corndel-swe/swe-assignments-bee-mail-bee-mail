package demo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SmartHome smartHome = SmartHome.getInstance();
        SmartHome home = SmartHome.getInstance();

        System.out.println(smartHome);
        System.out.println(home);

        SmartCamera cameraLivingRoom = new SmartCamera("Living Room");
        SmartCamera cameraKitchen = new SmartCamera("Kitchen");
        SmartLight lightLivingRoom = new SmartLight("Living Room");
        SmartLight lightKitchen = new SmartLight("Kitchen");

        smartHome.addDevice(List.of(cameraLivingRoom, cameraKitchen, lightLivingRoom, lightKitchen));

        cameraLivingRoom.detectMotion();

        DoorbellAdapter doorbellAdapter = new DoorbellAdapter("Front door");
        Doorbell doorbell = new Doorbell();

//        smartHome.addDevice(doorbell);

        smartHome.addDevice(doorbellAdapter);

        doorbellAdapter.ring();

        System.out.println("Is the doorbell ringing? " + doorbellAdapter.isRinging());

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Is the doorbell ringing? " + doorbellAdapter.isRinging());
    }

}
