package designpatternsstrategy.implementations.interfaceTypes;

import designpatternsstrategy.abstractions.IMakeSound;

public class CantMakeSound implements IMakeSound {

    @Override
    public String makeSound() {
        return "I can't make sound";
    }

}
