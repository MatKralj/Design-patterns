package designpatternsstate.implementations;

import designpatternsstate.abstraction.ATMState;

public class HasCard implements ATMState {

    ATMMachine atmMachine;

    public HasCard(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("You can't enter more than one card");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected");
        atmMachine.setATMState(atmMachine.getNoCardState());
    }

    @Override
    public void insertPin(int pin) {
        if (pin == 1234) {
            System.out.println("Correct pin");
            atmMachine.setCorrectPinEntered(true);
            atmMachine.setATMState(atmMachine.getHasPin());
        }else{
            System.out.println("Wrong pin");
            atmMachine.setCorrectPinEntered(false);
            ejectCard();
        }
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        System.out.println("Enter PIN first");
    }

}
