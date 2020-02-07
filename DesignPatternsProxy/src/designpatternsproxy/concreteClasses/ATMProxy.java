package designpatternsproxy.concreteClasses;

import designpatternsproxy.interfaces.GetATMData;

public class ATMProxy implements GetATMData{

    @Override
    public int getATMData() {
        ATMMachine realATMMachine = new ATMMachine();
        
        return realATMMachine.getATMData();
    }

    @Override
    public int getCashInMachine() {
        ATMMachine realATMMachine = new ATMMachine();
        
        return realATMMachine.getCashInMachine();
    }
    
}
