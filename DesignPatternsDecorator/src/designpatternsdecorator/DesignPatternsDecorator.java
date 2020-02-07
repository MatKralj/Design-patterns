package designpatternsdecorator;

import designpatternsdecorator.concreteClasses.Mozzarella;
import designpatternsdecorator.concreteClasses.PlainPizza;
import designpatternsdecorator.concreteClasses.TomatoSauce;
import designpatternsdecorator.interfaces.Pizza;

public class DesignPatternsDecorator {

    public static void main(String[] args) {
        
        Pizza basicPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));
        
        System.out.println("Ingredients: "+basicPizza.getDescription());
        System.out.println("Cost: "+basicPizza.getCost());
    }
    
}
