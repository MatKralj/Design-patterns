package designpatternsdecorator.concreteClasses;

import designpatternsdecorator.interfaces.Pizza;

public class PlainPizza implements Pizza{

    @Override
    public String getDescription() {
        return "Thin Dough";
    }

    @Override
    public double getCost() {
        return 4.00;
    }
    
}
