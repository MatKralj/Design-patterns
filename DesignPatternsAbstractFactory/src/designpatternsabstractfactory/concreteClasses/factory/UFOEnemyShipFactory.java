package designpatternsabstractfactory.concreteClasses.factory;

import designpatternsabstractfactory.concreteClasses.grunt.ESUFOEngine;
import designpatternsabstractfactory.concreteClasses.grunt.ESUFOGun;
import designpatternsabstractfactory.interfaces.ESEngine;
import designpatternsabstractfactory.interfaces.ESWeapon;
import designpatternsabstractfactory.interfaces.EnemyShipFactory;

public class UFOEnemyShipFactory implements EnemyShipFactory{

    @Override
    public ESWeapon addESGun() {
        return new ESUFOGun();
    }

    @Override
    public ESEngine addESEngine() {
        return new ESUFOEngine();
    }
    
}
