package designpatternsbridge.abstractClasses;

public abstract class RemoteButton {
    
    
    private EntertainmentDevice theDevice;
    
    public RemoteButton(EntertainmentDevice newDevice){
        this.theDevice = newDevice;
    }
    
    public void buttonFivePressed(){
        theDevice.buttonFivePressed();
    }
    
    public void buttonSevenPressed(){
        theDevice.buttonSevenPressed();
    }
    
    public void buttonSixPressed(){
        theDevice.buttonSixPressed();
    }
    
    public void buttonEightPressed(){
        theDevice.buttonEightPressed();
    }
    
    public abstract void buttonNinePressed();
}
