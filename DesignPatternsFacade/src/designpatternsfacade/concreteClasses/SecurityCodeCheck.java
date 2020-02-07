package designpatternsfacade.concreteClasses;

public class SecurityCodeCheck {
    
    private int securityCode = 123;
    
    public int getSecurityCode(){
        return securityCode;
    }
    
    public boolean isCodeCorrect(int secCodeToCheck){
        return secCodeToCheck == getSecurityCode();
    }
}
