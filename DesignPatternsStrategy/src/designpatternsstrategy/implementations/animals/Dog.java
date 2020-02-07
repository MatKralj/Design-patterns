package designpatternsstrategy.implementations.animals;

import designpatternsstrategy.abstractions.Animal;
import designpatternsstrategy.implementations.interfaceTypes.CanMakeSound;
import designpatternsstrategy.implementations.interfaceTypes.CantFly;

public class Dog extends Animal{
    
    public Dog(){
        setFlyType(new CantFly());
        setMakeSoundType(new CanMakeSound());
    }
}
