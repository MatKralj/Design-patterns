package designpatternsprototype;

import designpatternsprototype.concreteClasses.Circle;

public class DesignPatternsPrototype {

    public static void main(String[] args) {
        Circle circle1 = new Circle();
        circle1.setY(10);
        circle1.setX(20);
        circle1.setRadius(3);
        
        Circle circleClone = (Circle) circle1.clone();
        
        if(circleClone.equals(circle1))
            System.out.println("Objekti su jednaki");
        else
            System.out.println("Objekti nisu jednaki");
        
        circleClone.setRadius(20);
        if(circleClone.equals(circle1))
            System.out.println("Objekti su jednaki");
        else
            System.out.println("Objekti nisu jednaki");
        
    }
    
}
