package designpatternsdecorator.concreteClasses;

import designpatternsdecorator.abstractClasses.ToppingDecorator;
import designpatternsdecorator.interfaces.Pizza;

public class TomatoSauce extends ToppingDecorator{
    
    public TomatoSauce(Pizza pizza) {
        super(pizza);
        System.out.println("Adding Sauce");
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.25;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+ ", Tomato Sauce";
    }
    
    
}
