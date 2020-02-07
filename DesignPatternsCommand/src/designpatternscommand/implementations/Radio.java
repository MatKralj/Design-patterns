package designpatternscommand.implementations;

import designpatternscommand.abstractions.ElectronicDevice;

public class Radio implements ElectronicDevice{

    private int volume = 0;

    @Override
    public void on() {
        System.out.println("Radio is On");
    }

    @Override
    public void off() {
        System.out.println("Radio is Off");
    }

    @Override
    public void voulmeUp() {
        System.out.println("Radio volume is at: "+(++volume));
    }

    @Override
    public void volumeDown() {
        System.out.println("Radio volume is at: "+(--volume));
    }
    
}
