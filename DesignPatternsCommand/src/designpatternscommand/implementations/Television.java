package designpatternscommand.implementations;

import designpatternscommand.abstractions.ElectronicDevice;

public class Television implements ElectronicDevice{
    
    private int volume = 0;

    @Override
    public void on() {
        System.out.println("TV is On");
    }

    @Override
    public void off() {
        System.out.println("TV is Off");
    }

    @Override
    public void voulmeUp() {
        System.out.println("TV volume is at: "+(++volume));
    }

    @Override
    public void volumeDown() {
        System.out.println("TV volume is at: "+(--volume));
    }
    
}
