package designpatternsstrategy.implementations.interfaceTypes;

import designpatternsstrategy.abstractions.IFly;

public class CanFly implements IFly{

    @Override
    public String fly() {
        return "I can fly";
    }
    
}
