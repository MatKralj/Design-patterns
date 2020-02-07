package designpatternsstrategy.implementations.animals;

import designpatternsstrategy.abstractions.Animal;
import designpatternsstrategy.implementations.interfaceTypes.CantFly;
import designpatternsstrategy.implementations.interfaceTypes.CantMakeSound;

public class Fish extends Animal{

    public Fish() {
        setFlyType(new CantFly());
        setMakeSoundType(new CantMakeSound());
    }
    
}
