package designpatternsbridge.concreteClasses;

import designpatternsbridge.abstractClasses.EntertainmentDevice;

public class DVDDevice extends EntertainmentDevice {
    
    public DVDDevice(int newDeviceState, int newMaxSetting){
        super.deviceState = newDeviceState;
        super.maxSetting = newMaxSetting;
    }

    @Override
    public void buttonFivePressed() {
        System.out.println("DVD skips to prev chapter");
        super.deviceState--;
    }

    @Override
    public void buttonSixPressed() {
        System.out.println("DVD skips to next chapter");
        super.deviceState++;
    }
    
}
