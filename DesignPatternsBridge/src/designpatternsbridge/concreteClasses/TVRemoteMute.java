package designpatternsbridge.concreteClasses;

import designpatternsbridge.abstractClasses.EntertainmentDevice;
import designpatternsbridge.abstractClasses.RemoteButton;

public class TVRemoteMute extends RemoteButton{

    public TVRemoteMute(EntertainmentDevice newDevice) {
        super(newDevice);
    }

    @Override
    public void buttonNinePressed() {
        System.out.println("TV was Muted");
    }
    
}
