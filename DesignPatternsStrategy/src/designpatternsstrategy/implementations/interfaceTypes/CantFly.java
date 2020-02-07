package designpatternsstrategy.implementations.interfaceTypes;

import designpatternsstrategy.abstractions.IFly;

public class CantFly implements IFly{

    @Override
    public String fly() {
        return "I can't fly";
    }
    
}
