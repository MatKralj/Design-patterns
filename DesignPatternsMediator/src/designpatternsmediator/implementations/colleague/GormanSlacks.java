package designpatternsmediator.implementations.colleague;

import designpatternsmediator.abstractions.Colleague;
import designpatternsmediator.abstractions.Mediator;

public class GormanSlacks extends Colleague{

    public GormanSlacks(Mediator mediator) {
        super(mediator);
        
        System.out.println("Gorman Slacks signed up for the exchange\n");
    }

}
