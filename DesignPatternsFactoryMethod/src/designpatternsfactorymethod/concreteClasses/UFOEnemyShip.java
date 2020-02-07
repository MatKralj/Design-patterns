package designpatternsfactorymethod.concreteClasses;

import designpatternsfactorymethod.abstractClasses.EnemyShip;

public class UFOEnemyShip extends EnemyShip{
    
    public UFOEnemyShip(){
        setName("UFO EnemyShip");
        setAmtDmg(20.0);
    }
    
}
