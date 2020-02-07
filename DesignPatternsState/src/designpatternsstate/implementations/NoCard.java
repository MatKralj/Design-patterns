package designpatternsstate.implementations;

import designpatternsstate.abstraction.ATMState;

public class NoCard implements ATMState {

    ATMMachine atmMachine;

    public NoCard(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("Please enter a PIN.");
        atmMachine.setATMState(atmMachine.getYesCardState());
    }

    @Override
    public void ejectCard() {
        System.out.println("Insert the card first");
    }

    @Override
    public void insertPin(int pin) {
        System.out.println("Insert the card first");
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        System.out.println("Insert the card first");
    }

}
