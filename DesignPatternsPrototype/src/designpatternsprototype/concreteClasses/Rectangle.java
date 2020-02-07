package designpatternsprototype.concreteClasses;

import designpatternsprototype.abstractClasses.Shape;

public class Rectangle extends Shape{

    private int width;
    private int height;
    
    public Rectangle(){
        
    }
    
    public Rectangle(Rectangle target){
        super(target);
        if(target!=null){
            this.width=target.width;
            this.height=target.height;
        }
    }
    
    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
}
