package designpatternsbridge.concreteClasses;

import designpatternsbridge.abstractClasses.EntertainmentDevice;
import designpatternsbridge.abstractClasses.RemoteButton;

public class DVDRemote extends RemoteButton{

    private boolean play =true;
    
    public DVDRemote(EntertainmentDevice newDevice) {
        super(newDevice);
    }

    @Override
    public void buttonNinePressed() {
        play = !play;
        
        System.out.println("DVD is playing: "+play);
    }

    
}
