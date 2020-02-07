package designpatternsfactorymethod.abstractClasses;

public abstract class EnemyShip {
    
    private String name;
    private double amtDmg;
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public double getAmtDmg(){
        return amtDmg;
    }
    public void setAmtDmg(double amtDmg){
        this.amtDmg = amtDmg;
    }
    
    public void followHeroShip(){
        System.out.println(getName()+" is following the hero");
    }
    
    public void displayEnemyShip(){
        System.out.println(getName()+" is on the screen");
    }
    
    public void enemyShipShoots(){
        System.out.println(getName()+" attacks and deals "+getAmtDmg());
    }
    
}
