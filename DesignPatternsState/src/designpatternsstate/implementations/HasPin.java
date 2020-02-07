package designpatternsstate.implementations;

import designpatternsstate.abstraction.ATMState;

public class HasPin implements ATMState {

    ATMMachine atmMachine;

    public HasPin(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("You can't enter more than one card");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected");
        atmMachine.setATMState(this.atmMachine.getNoCardState());
    }

    @Override
    public void insertPin(int pin) {
        System.out.println("You already entered pin");
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        if (cashToWithdraw > atmMachine.getCashInMachine()) {
            System.out.println("Not enough cash in ATM.");
            System.out.println("Card ejected.");
            atmMachine.setATMState(this.atmMachine.getNoCardState());
        } else {
            System.out.println(cashToWithdraw + " is provided by the ATM");
            atmMachine.setCashInMachine(atmMachine.getCashInMachine()-cashToWithdraw);
            
            System.out.println("Card ejected.");
            atmMachine.setATMState(this.atmMachine.getNoCardState());
            
            if(atmMachine.getCashInMachine()<=0){
                atmMachine.setATMState(atmMachine.getNoCashState());
            }
        }
    }

}
