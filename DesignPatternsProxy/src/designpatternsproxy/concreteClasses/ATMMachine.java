package designpatternsproxy.concreteClasses;

import designpatternsproxy.interfaces.GetATMData;

public class ATMMachine implements GetATMData{

    @Override
    public int getATMData() {
        return 2;
    }

    @Override
    public int getCashInMachine() {
        return 21500;
    }
    
}
