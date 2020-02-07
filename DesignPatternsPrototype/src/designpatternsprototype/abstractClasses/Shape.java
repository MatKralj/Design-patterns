package designpatternsprototype.abstractClasses;

import java.util.Objects;

public abstract class Shape {
    protected int x;
    protected int y;
    protected String color;
    
    public Shape(){
        
    }
    
    public Shape(Shape target){
        if(target!=null){
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public abstract Shape clone();

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Shape))
            return false;
        Shape shape2 = (Shape) obj;
        return shape2.x==this.x && shape2.y==this.y && Objects.equals(shape2.color, this.color);
    } 
    
}
