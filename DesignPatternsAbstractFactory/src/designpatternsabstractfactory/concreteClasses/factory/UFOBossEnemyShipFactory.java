package designpatternsabstractfactory.concreteClasses.factory;

import designpatternsabstractfactory.concreteClasses.boss.ESUFOBossEngine;
import designpatternsabstractfactory.concreteClasses.boss.ESUFOBossGun;
import designpatternsabstractfactory.interfaces.ESEngine;
import designpatternsabstractfactory.interfaces.ESWeapon;
import designpatternsabstractfactory.interfaces.EnemyShipFactory;

public class UFOBossEnemyShipFactory implements EnemyShipFactory {

// Defines the weapon object to associate with the ship
    @Override
    public ESWeapon addESGun() {
        return new ESUFOBossGun(); // Specific to Boss UFO
    }

    // Defines the engine object to associate with the ship
    @Override
    public ESEngine addESEngine() {
        return new ESUFOBossEngine(); // Specific to Boss UFO
    }
}
