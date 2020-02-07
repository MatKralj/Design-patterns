package designpatternsstrategy.implementations.animals;

import designpatternsstrategy.abstractions.Animal;
import designpatternsstrategy.implementations.interfaceTypes.CanFly;
import designpatternsstrategy.implementations.interfaceTypes.CanMakeSound;

public class Bird extends Animal{

    public Bird() {
        setFlyType(new CanFly());
        setMakeSoundType(new CanMakeSound());
    }
    
}
