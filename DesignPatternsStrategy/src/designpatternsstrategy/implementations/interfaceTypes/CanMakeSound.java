package designpatternsstrategy.implementations.interfaceTypes;

import designpatternsstrategy.abstractions.IMakeSound;

public class CanMakeSound implements IMakeSound {

    @Override
    public String makeSound() {
        return "I can make sound";
    }

}
