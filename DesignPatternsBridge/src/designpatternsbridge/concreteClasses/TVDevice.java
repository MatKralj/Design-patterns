package designpatternsbridge.concreteClasses;

import designpatternsbridge.abstractClasses.EntertainmentDevice;

public class TVDevice extends EntertainmentDevice{
    
    public TVDevice(int newDeviceState, int newMaxSetting){
        super.deviceState = newDeviceState;
        super.maxSetting = newMaxSetting;
    }

    @Override
    public void buttonFivePressed() {
        System.out.println("Channel Down");
        super.deviceState--;
    }

    @Override
    public void buttonSixPressed() {
        System.out.println("Channel Up");
        super.deviceState++;
    }
    
}
