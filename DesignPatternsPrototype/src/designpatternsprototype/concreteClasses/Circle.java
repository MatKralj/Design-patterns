package designpatternsprototype.concreteClasses;

import designpatternsprototype.abstractClasses.Shape;

public class Circle extends Shape{

    public void setRadius(int radius) {
        this.radius = radius;
    }

    private int radius;
    
    public Circle(){
        
    }
    
    public Circle(Circle target){
        super(target);
        if(target!=null){
            this.radius = target.radius;
        }
    }
    
    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Circle) || !super.equals(obj))
            return false;
        
        Circle s2 = (Circle) obj;
        return s2.radius==this.radius;
    }
    
    
    
}
