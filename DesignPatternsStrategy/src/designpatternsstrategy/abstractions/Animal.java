package designpatternsstrategy.abstractions;

public class Animal {
    
    private IFly flyType;
    private IMakeSound makeSoundType;
    
    public String makeSound(){
        return makeSoundType.makeSound();
    }
    
    public String fly(){
        return flyType.fly();
    }

    public void setFlyType(IFly flyType) {
        this.flyType = flyType;
    }

    public void setMakeSoundType(IMakeSound makeSoundType) {
        this.makeSoundType = makeSoundType;
    }
    
}
