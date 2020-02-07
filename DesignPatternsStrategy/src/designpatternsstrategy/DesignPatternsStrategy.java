package designpatternsstrategy;

import designpatternsstrategy.abstractions.Animal;
import designpatternsstrategy.implementations.animals.Bird;
import designpatternsstrategy.implementations.animals.Dog;
import designpatternsstrategy.implementations.animals.Fish;

public class DesignPatternsStrategy {

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal bird = new Bird();
        Animal fish = new Fish();
        
        System.out.println("Dog flys: "+dog.fly());
        System.out.println("Dog makes sound: "+dog.makeSound()+"\n");
        System.out.println("Bird flys: "+bird.fly());
        System.out.println("Bird makes sound: "+bird.makeSound()+"\n");
        System.out.println("Fish flys: "+fish.fly());
        System.out.println("Fish makes sound: "+fish.makeSound()+"\n");
    }
    
}
 