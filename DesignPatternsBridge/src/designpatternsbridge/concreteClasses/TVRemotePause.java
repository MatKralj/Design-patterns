package designpatternsbridge.concreteClasses;

import designpatternsbridge.abstractClasses.EntertainmentDevice;
import designpatternsbridge.abstractClasses.RemoteButton;

public class TVRemotePause extends RemoteButton{

    public TVRemotePause(EntertainmentDevice newDevice) {
        super(newDevice);
    }

    @Override
    public void buttonNinePressed() {
        System.out.println("TV was paused");
    }
    
}
