package designpatternscommand.implementations;

import designpatternscommand.abstractions.ElectronicDevice;

public class TVRemote {
    
    public static ElectronicDevice getDevice(){
        return new Television();
    }
}
