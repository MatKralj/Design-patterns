package designpatternscommand.implementations.commands;

import designpatternscommand.abstractions.Command;
import designpatternscommand.abstractions.ElectronicDevice;

public class TurnTVDown implements Command{
    
    ElectronicDevice theDevice;

    public TurnTVDown(ElectronicDevice theDevice) {
        this.theDevice = theDevice;
    }
    
    @Override
    public void execute() {
        this.theDevice.volumeDown();
    }

    @Override
    public void undo() {
        this.theDevice.voulmeUp();
    }
    
}
