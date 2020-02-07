package designpatternsproxy;

import designpatternsproxy.concreteClasses.ATMMachine;
import designpatternsproxy.concreteClasses.ATMProxy;
import designpatternsproxy.interfaces.GetATMData;

public class DesignPatternsProxy {

    public static void main(String[] args) {
        
        GetATMData realATMMachine = new ATMMachine();
        
        GetATMData atmProxy = new ATMProxy();
        
        System.out.println("\n");
    }
    
}
