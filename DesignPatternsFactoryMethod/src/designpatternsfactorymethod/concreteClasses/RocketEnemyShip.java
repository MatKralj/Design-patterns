package designpatternsfactorymethod.concreteClasses;

import designpatternsfactorymethod.abstractClasses.EnemyShip;

public class RocketEnemyShip extends EnemyShip{
    
    public RocketEnemyShip(){
        setName("Rocket enemy ship");
        setAmtDmg(10.0);
    }
}
