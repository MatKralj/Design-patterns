package designpatternsfacade;

import designpatternsfacade.concreteClasses.BankAccountFacade;

public class DesignPatternsFacade {

    public static void main(String[] args) {
        BankAccountFacade accessingBank = new BankAccountFacade(12345678, 123);
        
        accessingBank.withdrawCash(50.00);
        accessingBank.withdrawCash(900.00);
        accessingBank.depositCash(200.00);
    }
    
}
