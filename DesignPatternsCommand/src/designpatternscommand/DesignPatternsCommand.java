package designpatternscommand;

import designpatternscommand.abstractions.Command;
import designpatternscommand.abstractions.ElectronicDevice;
import designpatternscommand.implementations.DeviceButton;
import designpatternscommand.implementations.Radio;
import designpatternscommand.implementations.TVRemote;
import designpatternscommand.implementations.Television;
import designpatternscommand.implementations.TurnItAllOff;
import designpatternscommand.implementations.commands.TurnTVOff;
import designpatternscommand.implementations.commands.TurnTVOn;
import designpatternscommand.implementations.commands.TurnTVUp;
import java.util.ArrayList;
import java.util.List;

public class DesignPatternsCommand {

    public static void main(String[] args) {
        ElectronicDevice device = TVRemote.getDevice();
        
        Command onCommand = new TurnTVOn(device);
        
        DeviceButton onPressed = new DeviceButton(onCommand);
        
        onPressed.press();
        //
        Command offCommand = new TurnTVOff(device);
        
        onPressed = new DeviceButton(offCommand);
        
        onPressed.press();
        //
        Command upCommand = new TurnTVUp(device);
        
        onPressed = new DeviceButton(upCommand);
        onPressed.press();
        onPressed.press();
        onPressed.pressUndo();
        onPressed.press();
        onPressed.pressUndo();
        onPressed.press();
        onPressed.press();
        //
        ElectronicDevice television = new Television();
        ElectronicDevice radio = new Radio();
        List<ElectronicDevice> devices = new ArrayList<>();
        
        devices.add(television);
        devices.add(radio);
        
        Command turnOffDevices = new TurnItAllOff(devices);
        DeviceButton turnThemOffButton = new DeviceButton(turnOffDevices);
        turnThemOffButton.press();
        turnThemOffButton.pressUndo();

    }
    
}
