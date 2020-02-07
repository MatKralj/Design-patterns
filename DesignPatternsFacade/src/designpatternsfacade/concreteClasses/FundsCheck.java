package designpatternsfacade.concreteClasses;

public class FundsCheck {
    
    private double cashInAccount = 1000.00;
    
    public double getCashInAccount(){
        return cashInAccount;
    }
    
    public void decreaseCashInAccount(double cashWithdrawn){
        cashInAccount -= cashWithdrawn;
    }
    
    public void increaseCashInAccount(double cashDeposited){
        cashInAccount += cashDeposited;
    }
    
    public boolean haveEnoughMoney(double cashToWithdrawal){
        if(cashToWithdrawal> getCashInAccount()){
            System.out.println("Error you dont have enough money");
            System.out.println("Current balance: "+getCashInAccount());
            return false;
        }
        
        decreaseCashInAccount(cashToWithdrawal);
        System.out.println("Withdrawal complete: Current balance is: "+getCashInAccount());
        return true;
    }
    
    public void makeDeposit(double cashToDeposit){
        increaseCashInAccount(cashToDeposit);
        
        System.out.println("Deposite complete. Current balance is: "+getCashInAccount());
    }
    
}
