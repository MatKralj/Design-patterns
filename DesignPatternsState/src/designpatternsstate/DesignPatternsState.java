package designpatternsstate;

import designpatternsstate.implementations.ATMMachine;

public class DesignPatternsState {

    public static void main(String[] args) {
        ATMMachine atm = new ATMMachine();
        
        atm.insertCard();
        atm.ejectCard();
        atm.requestCash(100);
        atm.insertPin(1234);
        atm.insertCard();
        atm.requestCash(100);
        atm.insertPin(1222);
        atm.insertCard();
        atm.insertPin(1234);
        atm.requestCash(5000);
        atm.insertCard();
        atm.insertPin(1234);
        atm.requestCash(2000);
        atm.insertCard();
        atm.insertPin(1234);
        atm.requestCash(2000);
    }
    
}
