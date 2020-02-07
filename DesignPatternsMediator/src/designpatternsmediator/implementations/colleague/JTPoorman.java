package designpatternsmediator.implementations.colleague;

import designpatternsmediator.abstractions.Colleague;
import designpatternsmediator.abstractions.Mediator;

public class JTPoorman extends Colleague{

    public JTPoorman(Mediator mediator) {
        super(mediator);
        
        System.out.println("JT Poorman signed up for the exchange\n");
    }

}
