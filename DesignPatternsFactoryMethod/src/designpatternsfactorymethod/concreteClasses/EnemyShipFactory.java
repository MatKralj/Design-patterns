package designpatternsfactorymethod.concreteClasses;

import designpatternsfactorymethod.abstractClasses.EnemyShip;

public class EnemyShipFactory {
    
    public EnemyShip makeEnemyShip(String newShipType){
        newShipType = newShipType.toUpperCase();
        
        if(newShipType.equals("U"))
            return new UFOEnemyShip();
        else if(newShipType.equals("R"))
            return new RocketEnemyShip();
        else if(newShipType.equals("B"))
            return new BigUFOEnemyShip();
        
        return null;
    }
}
