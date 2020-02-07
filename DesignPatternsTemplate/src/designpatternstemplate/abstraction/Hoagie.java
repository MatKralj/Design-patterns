package designpatternstemplate.abstraction;

public abstract class Hoagie {
    
    public final void makeSandwich(){
        cutBun();
        if(customerWantsMeat()){
            addMeat();
        }
        
        if(customerWantsCheese()){
            addCheese();
        }
        
        if(customerWantsVeg()){
            addVeg();
        }
        
        if(customerWantsCondiments()){
            addCondiments();
        }
        
        wrapTheHoagie();
    }
    
    public void cutBun(){
        System.out.println("The Hoagie is Cut");
    }
    
    public void wrapTheHoagie(){
        System.out.println("Wrap The Hoagie");
    }
    
    public abstract void addMeat();
    public abstract void addCheese();
    public abstract void addVeg();
    public abstract void addCondiments();
    
    public boolean customerWantsMeat(){
        return true;
    }
    
    public boolean customerWantsCheese(){
        return true;
    }
    
    public boolean customerWantsVeg(){
        return true;
    }
    
    public boolean customerWantsCondiments(){
        return true;
    }
    
}
