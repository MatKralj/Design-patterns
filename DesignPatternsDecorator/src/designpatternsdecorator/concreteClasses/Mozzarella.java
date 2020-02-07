package designpatternsdecorator.concreteClasses;

import designpatternsdecorator.abstractClasses.ToppingDecorator;
import designpatternsdecorator.interfaces.Pizza;

public class Mozzarella extends ToppingDecorator{
    
    public Mozzarella(Pizza pizza) {
        super(pizza);
        System.out.println("Adding Dough");
        System.out.println("Adding Mozzarela");
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.50;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+ ", Mozzarella";
    }
    
    
}
