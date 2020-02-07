package designpatternscommand.implementations.commands;

import designpatternscommand.abstractions.Command;
import designpatternscommand.abstractions.ElectronicDevice;

public class TurnTVUp implements Command{
    
    ElectronicDevice theDevice;

    public TurnTVUp(ElectronicDevice theDevice) {
        this.theDevice = theDevice;
    }
    
    @Override
    public void execute() {
        this.theDevice.voulmeUp();
    }
    
    @Override
    public void undo() {
        theDevice.volumeDown();
    }
}
